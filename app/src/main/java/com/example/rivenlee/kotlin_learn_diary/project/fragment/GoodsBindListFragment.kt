package com.example.rivenlee.kotlin_learn_diary.project.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.adapter.GoodsBindAdapter
import com.example.rivenlee.kotlin_learn_diary.project.adapter.GoodsBindResult
import com.example.rivenlee.kotlin_learn_diary.project.listener.GoodsBindSelectChangedListener
import kotlinx.android.synthetic.main.fragment_goods_bind_list.*

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/5/10 11:26
 */
class GoodsBindListFragment : Fragment(R.layout.fragment_goods_bind_list){

    private var goodsBindSelectChangedListener: GoodsBindSelectChangedListener? = null

    companion object {
        fun newInstance(goodsBindSelectChangedListener: GoodsBindSelectChangedListener?): GoodsBindListFragment {
            val fragment = GoodsBindListFragment ()
            fragment.goodsBindSelectChangedListener = goodsBindSelectChangedListener
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataList = initData()
        recycler_view.apply {
            val goodsBindAdapter = GoodsBindAdapter(onItemClick = {
                goodsBindSelectChangedListener?.onChangedListener()
            })
            adapter = goodsBindAdapter
            goodsBindAdapter.setList(dataList)
        }
    }

    private fun initData(): MutableList<GoodsBindResult> {
        return mutableListOf<GoodsBindResult>().apply {
            for (i in 1..20) {
                add(GoodsBindResult(i.toString(), "商品$i", false, null))
            }
        }
    }

    fun notifyAdapter(){
        (recycler_view.adapter as? GoodsBindAdapter)?.notifyDataSetChanged()
    }


}