package com.ldcloli.lib.mutisteplist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import com.ldcloli.lib.R

class MutistepListAdapter<T>(var root: Node<T>): RecyclerView.Adapter<MutistepListAdapter.ViewHolder>() {
    var originList: ArrayList<Node<T>> = ArrayList() //原始数据
    var showList: ArrayList<Node<T>> = ArrayList() //显示数据
    var curShowLevel: Int = 0

    init {
        traverse(originList, root)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_base_use, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return originList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.mText = originList[position].

    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var mText: TextView? = null

        init {
            mText = item.findViewById(R.id.text)
        }

    }

    /**
     * 将一棵树遍历成一个list
     */
    fun traverse(list: ArrayList<Node<T>>, root: Node<T>?) {
        if(root == null) {
            return
        }

        list.add(root)

        if(root.children == null) {
            return
        }

        for (value in 0 until root.children!!.size) {
            traverse(list, root.children!![value])
        }

    }
}

