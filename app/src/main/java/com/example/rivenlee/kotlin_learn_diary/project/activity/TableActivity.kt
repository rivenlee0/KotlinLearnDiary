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
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.design_mode.observer.TextChangedListener
import com.example.rivenlee.kotlin_learn_diary.design_mode.observer.TextView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

/**
 * FileName: TableActivity
 * Author: rivenLee
 * Date: 2020/6/29 13:59
 */
@AndroidEntryPoint
class TableActivity : AppCompatActivity() {

    private var tv : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)
        tv = TextView().apply {
            listener = object : TextChangedListener {
                override fun onTextChanged(newText: String) {
                    Toast.makeText(this@TableActivity, newText, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    public fun observerClick(v: View){
        tv?.text = "observerClick"
//        send()
    }


    private fun send(){
        val intent = Intent(this, AlarmManagerReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this , 0, intent, 0)
        val alarm = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarm.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, System.currentTimeMillis(), 15* 1000L, pendingIntent)
    }

}

class AlarmManagerReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "repeating alarm", Toast.LENGTH_SHORT).show();
    }

}

interface AnalyticsService {
    fun analyticsMethods()
}

class AnalyticsServiceImpl @Inject constructor(): AnalyticsService{
    override fun analyticsMethods() {

    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule{

    @Binds
    abstract fun bindAnalyticsService(analyticsServiceImpl: AnalyticsServiceImpl): AnalyticsService

}