package com.ldcloli.lib.mutisteplist

import com.google.gson.annotations.SerializedName

/**
 * 数据源类型
 * 至少有一个value、一个孩子索引
 */
data class TreeNode(
        @SerializedName("value") var value: String?,
        @SerializedName("children") var children: MutableList<TreeNode>?
)


//建立标准封装数据的树结构
fun generateTree(root: Node<TreeNode>) {

    //原始数据 -> 组件的标准封装数据
    root.data.children?.forEach {
        Node(it, root)
    }

    root.children?.forEach {
        generateTree(it)
    }

}