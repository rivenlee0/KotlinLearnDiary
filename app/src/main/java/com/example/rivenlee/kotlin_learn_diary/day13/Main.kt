package com.example.rivenlee.kotlin_learn_diary.day13

/**
 * author: rivenlee
 * date: 2019/9/5
 * email: rivenlee0@gmail.com
 * 尾递归优化
 */

data class ListNode(val value: Int, var next: ListNode ?= null)

fun findListNode(head: ListNode?, value: Int): ListNode?{
    head?: return null
    if(head.value == value) return head
    return findListNode(head.next, value)
}


data class TreeNode(val value: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root?: return null
    if(root.value == value) return root
    return findTreeNode(root.left, value)?: return findTreeNode(root.right, value)
}

fun main(args: Array<String>) {
    val MAX_NODE_COUNT = 10
    val head = ListNode(0)
    var p = head
    for(i in 1..MAX_NODE_COUNT){
        p.next = ListNode(i)
        p = p.next!!
    }
    println(findListNode(head, MAX_NODE_COUNT - 2)?.value)

}


