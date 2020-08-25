package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateHandle
import com.example.rivenlee.kotlin_learn_diary.R
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent

/**
 * FileName: TableActivity
 * Author: rivenLee
 * Date: 2020/6/29 13:59
 */
@AndroidEntryPoint
class TableActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

    }

}

interface AnalyticsService {
    fun analyticsMethods()
}

@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule{

    public abstract fun bindAnalyticsService(): AnalyticsService

}