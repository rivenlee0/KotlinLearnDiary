package com.example.rivenlee.kotlin_learn_diary.project.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.rivenlee.kotlin_learn_diary.R
import com.example.rivenlee.kotlin_learn_diary.project.activity.GoodsBindListActivity
import org.jetbrains.anko.toast

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/5/10 13:45
 */

class GoodsBindAdapter(private val onItemClick: () -> Unit) : BaseQuickAdapter<GoodsBindResult, BaseViewHolder>(R.layout.item_goods_bind_recycler) {

    private val GOODS_BIND_SELECTED_ITEM_MAX = 6


    override fun convert(holder: BaseViewHolder, item: GoodsBindResult) {
        val selectedMap = (context as GoodsBindListActivity).selectedMap
        item.isSelected = selectedMap.containsKey(item.id)
        item.rank = selectedMap[item.id]?.rank?:""
        holder.setText(R.id.tv_id, item.text?:"")
                .setVisible(R.id.tv_is_selected, item.isSelected)
                .setVisible(R.id.tv_un_selected, !item.isSelected)
                .setText(R.id.tv_rank, item.rank?:"")
                .setGone(R.id.tv_rank, item.rank.isNullOrEmpty())

        holder.itemView.setOnClickListener {
            item.isSelected = !item.isSelected
            if (item.isSelected) {
                if (selectedMap.size >= GOODS_BIND_SELECTED_ITEM_MAX) {
                    context.toast("最多支持选${GOODS_BIND_SELECTED_ITEM_MAX}家")
                    item.isSelected = false
                    return@setOnClickListener
                }
                item.id?.let { selectedMap[it] = item }
            } else {
                item.id?.let { selectedMap.remove(it) }
            }
            onItemClick()
        }
    }


}


class GoodsBindResult(
        var id: String?,
        var text: String?,
        var isSelected: Boolean = false,
        var rank: String?
)