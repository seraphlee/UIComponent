package com.ldcloli.lib.mutisteplist

fun <T> traverse(root: Node<T>?, result: MutableList<Node<T>>) {
    if(root == null) {
        return
    }

    traverse(root, result)

}