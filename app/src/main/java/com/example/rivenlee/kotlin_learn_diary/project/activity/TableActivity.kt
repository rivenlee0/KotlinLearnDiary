package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rivenlee.kotlin_learn_diary.APPContext
import com.example.rivenlee.kotlin_learn_diary.KotlinApplication
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.design_mode.observer.TextChangedListener
import com.example.rivenlee.kotlin_learn_diary.design_mode.observer.TextView
import com.example.rivenlee.kotlin_learn_diary.project.viewmodel.TableViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import kotlinx.android.synthetic.main.activity_table.*
import java.lang.Exception
import javax.inject.Inject
import kotlin.concurrent.thread

/**
 * FileName: TableActivity
 * Author: rivenLee
 * Date: 2020/6/29 13:59
 */
@AndroidEntryPoint
class TableActivity : AppCompatActivity() {

    @Inject
    lateinit var tv: TextView

    private val viewModel: TableViewModel by lazy {
        ViewModelProvider(this).get(TableViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        setupViewModel()
        tv.listener = object : TextChangedListener {
            override fun onTextChanged(newText: String) {
                Toast.makeText(this@TableActivity, newText, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupViewModel() {
        viewModel.liveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    fun observerClick(v: View) {
        tv.text = "observerClick"
//        send()
    }

    fun liveDataClick(v: View) {
        viewModel.viewModelFunction()
    }

    fun enumClick(v: View) {
        LOLNIUBI().main()
    }

    private fun send() {
        val intent = Intent(this, AlarmManagerReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        val alarm = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, System.currentTimeMillis(), 15 * 1000L, pendingIntent)
    }

}

class AlarmManagerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "repeating alarm", Toast.LENGTH_SHORT).show();
    }

}

interface AnalyticsService {
    fun analyticsMethods()
}

class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
    override fun analyticsMethods() {

    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl): AnalyticsService

}

enum class LOL {
    AD, ADC, APC, JUNGLE, SUPPORT
}

class LOLNIUBI {

    private lateinit var bundle: Bundle

    fun main() {
        setLOL(LOL.APC)
        when (getLOL()) {
            LOL.APC -> {
                Toast.makeText(APPContext, "APC才能拯救世界", Toast.LENGTH_SHORT).show()
            }
            LOL.AD -> {
                Toast.makeText(APPContext, "上单才能拯救世界", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(APPContext, "别的位置都是垃圾", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setLOL(lol: LOL) {
        bundle = Bundle().apply {
            putString("我玩哪个位置", lol.name)
        }
    }

    private fun getLOL(): LOL {
        bundle.getString("我玩哪个位置")?.let {
            return LOL.valueOf(it)
        }
        throw Exception("先说你玩啥位置")
    }

}