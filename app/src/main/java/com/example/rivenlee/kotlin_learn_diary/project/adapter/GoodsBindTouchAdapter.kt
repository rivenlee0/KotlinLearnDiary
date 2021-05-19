package com.example.rivenlee.kotlin_learn_diary.project.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.helper.ItemTouchStatus
import java.util.*

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/5/10 19:30
 */

class GoodsBindTouchAdapter(val onDelClickListener:(item: GoodsBindResult) -> Unit) :
        BaseQuickAdapter<GoodsBindResult, BaseViewHolder>(R.layout.item_goods_bind_touch_recycler),
        ItemTouchStatus {

    override fun convert(holder: BaseViewHolder, item: GoodsBindResult) {
        holder.setText(R.id.tv_name, "${item.text}\n${item.text}")
        holder.getView<TextView>(R.id.tv_del).setOnClickListener {
            onDelClickListener(item)
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(data, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true
    }

}