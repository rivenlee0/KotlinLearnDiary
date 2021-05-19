package com.example.rivenlee.kotlin_learn_diary.project.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.activity.GoodsBindListActivity
import com.example.rivenlee.kotlin_learn_diary.project.adapter.ChildStatePagerAdapter
import com.example.rivenlee.kotlin_learn_diary.project.adapter.GoodsBindResult
import com.example.rivenlee.kotlin_learn_diary.project.adapter.GoodsBindTouchAdapter
import com.example.rivenlee.kotlin_learn_diary.project.helper.GoodsBindTouchCallback
import com.example.rivenlee.kotlin_learn_diary.project.listener.GoodsBindSelectChangedListener
import com.example.rivenlee.kotlin_learn_diary.project.listener.SearchListener
import kotlinx.android.synthetic.main.fragment_goods_bind.*
import org.jetbrains.anko.collections.forEachByIndex
import org.jetbrains.anko.support.v4.toast

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/5/8 17:35
 */
class GoodsBindFragment : Fragment(R.layout.fragment_goods_bind), GoodsBindSelectChangedListener {

    private var listener: SearchListener? = null
    private var fragmentList = mutableListOf<Fragment>()

    companion object {
        fun newInstance(): GoodsBindFragment {
            val fragment = GoodsBindFragment ()
//            fragment.listener = listener
            return fragment
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentList.apply {
            add(GoodsBindListFragment.newInstance(this@GoodsBindFragment))
            add(GoodsBindListFragment.newInstance(this@GoodsBindFragment))
        }
        view_pager.adapter = ChildStatePagerAdapter(childFragmentManager, mutableListOf("足迹", "全站商品"), fragmentList)
        view_pager.offscreenPageLimit = 2
        tab_layout.setupWithViewPager(view_pager)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = GoodsBindTouchAdapter {
                (context as GoodsBindListActivity).selectedMap.remove(it.id)
                onChangedListener()
            }.apply {
                setList((context as GoodsBindListActivity).selectedMap.values)
                ItemTouchHelper(GoodsBindTouchCallback(this)).attachToRecyclerView(recycler_view)
            }
        }


    }


    fun startResultPage(keyword: String) {
        toast(keyword)
    }

    override fun onChangedListener() {
        fragmentList.forEach {
            (it as? GoodsBindListFragment)?.notifyAdapter()
        }
        val dataList = (context as GoodsBindListActivity).selectedMap.values
        dataList.forEachIndexed { index, goodsBindResult ->
            goodsBindResult.rank = (index + 1).toString()
        }
        (recycler_view.adapter as? GoodsBindTouchAdapter)?.setList(dataList)
        tv_selected_num.text = "已选择${dataList.size}个商品"

    }
}