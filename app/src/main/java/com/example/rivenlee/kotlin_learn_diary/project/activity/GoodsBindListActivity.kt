package com.example.rivenlee.kotlin_learn_diary.project.activity

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.day14.add
import com.example.rivenlee.kotlin_learn_diary.project.adapter.GoodsBindResult
import com.example.rivenlee.kotlin_learn_diary.project.fragment.GoodsBindFragment
import kotlinx.android.synthetic.main.goods_bind_list_activity.*
import org.jetbrains.anko.toast

/**
 * 多列表联动
 */
class GoodsBindListActivity : AppCompatActivity(R.layout.goods_bind_list_activity) {

    private val goodsBindFragment: GoodsBindFragment = GoodsBindFragment.newInstance()
    val selectedMap = mutableMapOf<String, GoodsBindResult>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_search_container, goodsBindFragment, "")
        transaction.commitAllowingStateLoss()
        et_search.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (v.text.toString().isEmpty()) {
                    toast("search is empty")
                    return@setOnEditorActionListener true
                }
                goodsBindFragment.startResultPage(v.text.toString())
            }
            false
        }

    }

}

