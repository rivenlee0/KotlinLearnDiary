
[https://www.jianshu.com/p/5ecdf922593a](https://www.jianshu.com/p/5ecdf922593a)

##### 提纲
- 什么是Lifecycle；
- 如何使用Lifecycle观察宿主状态；
- Fragment是如何实现Lifecycle的；
- Activity是如何实现Lifecycle的；
- Lifecycle是如何分发宿主状态。

##### 什么是Lifecycle
Lifecycle是具备宿主生命周期感知能力的组件。它能持有组件（如Activity或Fragment）生命周期状态的信息，并且允许其他观察者监听宿主的状态。它也是Jetpack组件库的核心基础，包括我们就会讲到的LiveData，ViewModel组件等也都是基于它来实现的。

> 再也不用手动分发宿主生命周期，再也不用手动反注册了

![](https://upload-images.jianshu.io/upload_images/5196125-f3522046003dfb86.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

##### Lifecycle的两种写法
Lifecycle有两种实现方法，下面我们一一来介绍一下：
使用Lifecycle前需要先添加依赖：
```
 //通常情况下，只需要添加appcompat就可以了
api 'androidx.appcompat:appcompat:1.1.0'
 //如果想单独使用，可引入下面这个依赖
api 'androidx.lifecycle:lifecycle-common:2.1.0'
```
###### LifecycleObserver配合注解：
```
//1. 自定义的LifecycleObserver观察者，在对应方法上用注解声明想要观  察的宿主的生命周期事件即可
class LocationObserver implements LifecycleObserver{
    //宿主执行了onstart时，会分发该事件
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart(@NotNull LifecycleOwner owner){
      //开启定位
    }

  //宿主执行了onstop时 会分发该事件
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  void onStop(@NotNull LifecycleOwner owner){
     //停止定位
  }
 }

//2. 注册观察者,观察宿主生命周期状态变化
class MyFragment extends Fragment{
  public void onCreate(Bundle bundle){
    LocationObserver observer =new LocationObserver()
    getLifecycle().addObserver(observer);
  }
 }
```
###### LifecycleEventObserver宿主生命周期事件封装成Lifecycle.Event
```
//1.源码
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(LifecycleOwner source, Lifecycle.Event event);
}
//2.用法
class LocationObserver extends LifecycleEventObserver{
    @override
    void onStateChanged(LifecycleOwner source, Lifecycle.Event event){
      //需要自行判断life-event是onstart, 还是onstop
    }
}
```
上面的这两种Lifecycle写法老师比较推荐**第二种**，因为第一种你虽然用注解很爽，但是如果没有添加lifecycle-compiler这个注解处理器的话，运行时会使用反射的形式回调到对应的方法上。

##### Fragment是如何实现Lifecycle的？

使用Fragment实现Lifecycle需要在各个生命周期方法内里雍LifecycleRegistry分发相应的事件给每个观察者，以实现生命周期观察的能力：
```
public class Fragment implements LifecycleOwner {
LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
  @Override
  public Lifecycle getLifecycle() {
      //复写自LifecycleOwner,所以必须new LifecycleRegistry对象返回
      return mLifecycleRegistry;
  }

 void performCreate(){
     mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
  }

 void performStart(){
     mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
  }
  .....
 void performResume(){
     mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
  }
}
```
#####LifecycleOwner、Lifecycle、LifecycleRegistry的关系
事件在分发宿主生命期事件的流程中设计到三个分类，我们分别来捋一捋：
- LifecycleOwner：我们的Activity/Fragment都实现了该接口，用以生命它是一个能够提供生命周期事件的宿主。同事必须复写getLifecycle()方法提供一个Lifecycle对象；
- Lifecycke：是一个抽象类，里面定义了两个枚举State宿主的状态，Event需要分发的事件的类型；
- LifecycleRegistry：是Lifecycle的唯一实现类，主要用来负责注册Observer，以及分发宿主状态事件给它们。

![](https://upload-images.jianshu.io/upload_images/5196125-9770759b790ca963.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/860)

##### Activity是如何实现Lifecycle的？
Activity实现Lifecycle需要借助于ReportFragment往Activity上添加一个fragment用以报告生命周期的变化。目的是为了兼容不是集成自AppCompactActivity的场景，同时也支持我们自定义LifecycleOwener的场景，注意了，这点**面试会考！！！**。
```
public class ComponentActivity extends Activity implements LifecycleOwner{
  private LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
   @NonNull
   @Override
   public Lifecycle getLifecycle() {
      return mLifecycleRegistry;
   }

  protected void onCreate(Bundle bundle) {
      super.onCreate(savedInstanceState);
      //往Activity上添加一个fragment,用以报告生命周期的变化
      //目的是为了兼顾不是继承自AppCompactActivity的场景.
      ReportFragment.injectIfNeededIn(this);
}
```

###### ReportFragment核心源码
这里的实现其实跟Fragment中的源码是一样的，在各个生命周期方法内利用LifecycleRegistry派发相应的Lifecycle.Event事件给每个观察者：
```
  public class ReportFragment extends Fragment{
    public static void injectIfNeededIn(Activity activity) {
        android.app.FragmentManager manager =   activity.getFragmentManager();
        if (manager.findFragmentByTag(REPORT_FRAGMENT_TAG) ==   null) {
            manager.beginTransaction().add(new ReportFragment(), REPORT_FRAGMENT_TAG).commit();
            manager.executePendingTransactions();
      }
}
    @Override
    public void onStart() {
        super.onStart();
        dispatch(Lifecycle.Event.ON_START);
    }
    @Override
    public void onResume() {
        super.onResume();
        dispatch(Lifecycle.Event.ON_RESUME);
    }
    @Override
    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
    }
    private void dispatch(Lifecycle.Event event) {
         Lifecycle lifecycle = activity.getLifecycle();
         if (lifecycle instanceof LifecycleRegistry) {
             ((LifecycleRegistry)   lifecycle).handleLifecycleEvent(event);
         }
}
```
##### 宿主生命周期与宿主状态模型图
LifecycleRegistry在分发事件的时候会涉及到两个概念：
- 宿主生命周期：就是我们烂熟于心的onCreate,onStart,onResume,onPause,onStop...；
- 宿主的状态：这个不是很好理解，这个意思是指宿主执行了上述方法后，它处于对应周期的生命状态。

从下面这张图不难看出宿主生命周期与宿主状态的对应关系分裂为onCreate-Created、onStart-Started、onResume-Resumed、onPause-Started、onStop-Created、onDestroy-Destroyed，这里不用全部记住有个印象即可。

![](https://upload-images.jianshu.io/upload_images/5196125-6566f207e3fe80c2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/860)

##### 添加observer时，完整的生命周期事件分发
基于Lifecycle的特性我们在任意生命周期方法内注册观察者都能接受到完整的生命周期事件，比如在onResume中注册一个观察者，它会依次收到：

```
LifecycleEvent.onCreate -> LifecycleEvent.onStart -> LifecycleEvent.onResume
```

##### 添加Observer时完整的生命周期事件分发源码分析
这一点需要掌握，面试中是肯定会考察的。但是如果没有看过源码是回答不上来的：
```
public void addObserver(@NonNull LifecycleObserver observer) {
        //添加新的Observer时，会首先根据宿主的状态计算出它的初始状态，只要不是在onDestroy中注册的，它的初始状态都是INITIALIZED
        State initialState = mState == DESTROYED ? DESTROYED : INITIALIZED;
        //接着会把observer包装成ObserverWithState，这个类主要是包含了观察者及其状态。每个事件都会经由这个对象类转发,这个类后面会来分析
        ObserverWithState statefulObserver = new ObserverWithState(observer, initialState);
        //添加到集合，如果之前已经添加过了，则return
        ObserverWithState previous = mObserverMap.putIfAbsent(observer, statefulObserver);
        if (previous != null) {
            return;
        }

        State targetState = calculateTargetState(observer);
        //这里的while循环，是实现上图状态同步与事件分发的主要逻辑
        //拿观察者的状态和宿主当前状态做比较，如果小于0，说明两者状态还没有对齐。
        while ((statefulObserver.mState.compareTo(targetState) < 0
                && mObserverMap.contains(observer))) {
            pushParentState(statefulObserver.mState);
            //接着就会分发一次相应的事件，于此同时statefulObserver的mState对象也会被升级
            //假设是在宿主的onresume方法内注册的该观察者
            //第一次：分发on_Create事件，观察者状态INIT->CREATED
            //第二次：分发on_Start事件，观察者状态CREATED->STARTED
            //第三次：分发on_Resume事件，观察者状态STARTED->RESUMED
            statefulObserver.dispatchEvent(lifecycleOwner, upEvent(statefulObserver.mState));
            //再一次计算观察者应该到达的状态，在下一轮循环中和宿主状态在做比较，知道两者状态对齐，退出循环。
            targetState = calculateTargetState(observer);
        }
    }
```
##### 宿主生命周期变化后相应事件的分发
这一点了解即可，面试中也不会考这一部分的内容：
```
public void handleLifecycleEvent(@NonNull Lifecycle.Event event){
        //宿主的每个生命周期的变化都会分发一个对应的Lifecycle.Event，走到这里
        //此时会根据需要分发的事件反推出 宿主当前的状态
        State next = getStateAfter(event);
        // moveToState方法只是将传入的宿主新的state和前持有宿主状态作比对，然后保存一下。
        moveToState(next);
}
//如果宿主状态有变动，则调用sync方法来完成事件的分发和观察者状态的同步
private void sync() {
        while (!isSynced()) {
        //如果宿主当前转态 小于 mObserverMap集合中最先添加的那个观察者的状态
        //则说明宿主可能发生了状态回退，比如当前是RESUMED状态，执行了onPause则回退到STARTED状态
        //此时调用backwardPass把集合中的每个一观察者分发一个on_pause事件，并同步它的状态。
            if (mState.compareTo(mObserverMap.eldest().getValue().mState) < 0) {
                backwardPass(lifecycleOwner);
            }
        //如果宿主当前转态 大于 mObserverMap集合中最先添加的那个观察者的状态
        //则说明宿主可能发生了状态前进，比如当前是STARTED状态，执行了onResume则前进到RESUMED状态
        //此时调用forwardPass把集合中的每个一观察者分发一个on_resume事件，并同步它的状态。
            Entry<LifecycleObserver, ObserverWithState> newest = mObserverMap.newest();
            if (!mNewEventOccurred && newest != null
                    && mState.compareTo(newest.getValue().mState) > 0) {
                forwardPass(lifecycleOwner);
            }
        }
    }
```

##### ObserverWithState：持有观察者及其状态的内部类
把传入的LifecycleObserver适配成LifecycleEventObserver，目的是为了统一事件的分发形式。

持有观察者的状态，方便与宿主状态做比对同步：
```
static class ObserverWithState {
        State mState;
        LifecycleEventObserver mLifecycleObserver;
        ObserverWithState(LifecycleObserver observer, State initialState) {
            //把传入的LifecycleObserver适配成LifecycleEventObserver，目的是为了统一事件的分发形式
            //因为我们前面提到观察者有三种类型,每种类型接收事件的形式并不一样，如果在分发的时候不统一事件分发的形式，将会变得很麻烦
            //至于是如何适配转换的，由于不是本文重点，所以不再详细展开
            //但核心思想这里说明一下，同学们自行看下就能明白
            //它会判断传入的observer是前面提到的那一种类型，进而转换成对应的适配器类，适配器类会对onStateChanged方法进行适配，并以相应的方式(反射、中转、)把事件转发到我们的observer上
            mLifecycleObserver = Lifecycling.lifecycleEventObserver(observer);
            mState = initialState;
        }

        void dispatchEvent(LifecycleOwner owner, Event event) {
            //再一次根据需要分发的事件类型反推出该观察者的状态,这样的好处是事件 &  状态 一一对应，不会出现跳跃。但阅读上可能会稍微有点绕
            State newState = getStateAfter(event);
            mState = min(mState, newState);
            //把事件分发给被包装的对象，完成本次流程。
            mLifecycleObserver.onStateChanged(owner, event);
            mState = newState;
        }
    }
```
![](https://upload-images.jianshu.io/upload_images/5196125-2399d3f7c7d9913a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/860)

##### 总结
本篇从 **三种用法+分发原理+面试考点** 三个维度展开对Lifecycle组件的介绍，现在相信同学们已经掌握了Lifecycle的核心了。Lifecycle组件是Jetpack组件库的核心，一旦跟宿主生命周期挂钩，那可以做很多文章，后面讲到的LiveData、ViewModel都是基于它来实现的。
- 本篇最后给同学们留下一个小作业，基于Lifecycle实现APP前后台切换事件观察的能力。这个作业可以让同学们加深对Lifecycle组件的理解
###### 作业：基于Lifecycle实现APP前后台切换事件观察的能力
```
class AppLifecycleOwner implements LifecycleOwner{
  LifecycleRegistry registry = new LifecycleRegistry(this)
  @ovrride
  Lifecycle getLifecycle(){
    return  registry
  }

  void init(Application application){
    //利用application的  ActivityLifecycleCallbacks 去监听每一个  Activity的onstart,onStop事件。
    //计算出可见的Activity数量，从而计算出当前处于前台还是后台。然后分发  给每个观察者
  }
}
```
