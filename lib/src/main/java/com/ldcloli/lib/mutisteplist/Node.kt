package com.ldcloli.lib.mutisteplist

/**
 * 数据源的封装类
 *
 */
class Node<T>(var data: T, private var parent: Node<T>?) {
    init {
        if (this.parent != null) {
            parent!!.children?.add(this)
        }
    }

    var children: MutableList<Node<T>>? = ArrayList()

    //层级
    var level: Int = 0
        get() {
            return if (parent == null) {
                0
            } else {
                parent!!.level + 1
            }
        }

    //是否展开
    var isExpand: Boolean = false

}