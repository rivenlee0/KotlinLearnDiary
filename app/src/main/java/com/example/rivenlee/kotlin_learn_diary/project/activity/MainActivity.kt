package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val BOTTOM_INDEX: String = "bottom_index"

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_SQUARE = 0x02
    private val FRAGMENT_WECHAT = 0x03
    private val FRAGMENT_SYSTEM = 0x04
    private val FRAGMENT_PROJECT = 0x05

    private var mIndex = FRAGMENT_HOME

    private var homeFragment : HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            mIndex = savedInstanceState.getInt(BOTTOM_INDEX)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.run {
            labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }
        showFragment(mIndex)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(BOTTOM_INDEX, mIndex)
    }

    private var onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {
                return@OnNavigationItemSelectedListener when(it.itemId){
                    R.id.action_home -> {
                        showFragment(FRAGMENT_HOME)
                        true
                    }
                    R.id.action_square -> {
                        showFragment(FRAGMENT_SQUARE)
                        true
                    }
                    R.id.action_system -> {
                        showFragment(FRAGMENT_SYSTEM)
                        true
                    }
                    R.id.action_project -> {
                        showFragment(FRAGMENT_PROJECT)
                        true
                    }
                    R.id.action_wechat -> {
                        showFragment(FRAGMENT_WECHAT)
                        true
                    }
                    else -> {
                        false
                    }
                }
    }

    private fun showFragment(index: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        hideFragments(beginTransaction)
        mIndex = index
        when (index){
            FRAGMENT_HOME -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment.getInstance()
                    beginTransaction.add(R.id.container, homeFragment!!, "home")
                } else {
                    beginTransaction.show(homeFragment!!)
                }
            }
        }
        beginTransaction.commit()

    }

    private fun hideFragments(beginTransaction: FragmentTransaction) {
        homeFragment?.let { beginTransaction.hide(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        homeFragment = null
    }
}
