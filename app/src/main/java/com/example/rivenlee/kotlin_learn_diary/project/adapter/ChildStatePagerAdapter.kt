package com.example.rivenlee.kotlin_learn_diary.project.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/5/10 11:17
 */
class ChildStatePagerAdapter(fm: FragmentManager, private val titles: MutableList<String>, private val fragments: MutableList<Fragment>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[(titles.size - 1).coerceAtMost(0.coerceAtLeast(position))]
    }

    override fun getCount(): Int {
        return titles.size
    }
}