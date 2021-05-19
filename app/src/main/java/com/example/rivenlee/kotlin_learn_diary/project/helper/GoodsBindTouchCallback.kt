package com.example.rivenlee.kotlin_learn_diary.project.helper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

/**
 * @Description: 类作用描述
 * @Author: rivenlee
 * @Date: 2021/5/11 15:40
 */
class GoodsBindTouchCallback(private val itemTouchStatus: ItemTouchStatus) : ItemTouchHelper.Callback(){

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        return makeMovementFlags(ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT, 0)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return itemTouchStatus.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

}

interface ItemTouchStatus {
    fun onItemMove(fromPosition: Int, toPosition: Int): Boolean
}