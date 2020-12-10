package com.example.rivenlee.kotlin_learn_diary.project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * FileName: MainViewModel
 * Author: rivenLee
 * Date: 2020/9/16 17:02
 */
class TableViewModel : ViewModel() {
    val liveData = MutableLiveData<String>()
    fun viewModelFunction(){
        liveData.value = "viewModel_liveData"
    }
}