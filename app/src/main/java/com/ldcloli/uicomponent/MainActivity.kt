package com.ldcloli.uicomponent

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.Gson
import com.ldcloli.lib.mutisteplist.MutistepListAdapter
import com.ldcloli.lib.mutisteplist.TreeNode
import com.ldcloli.lib.mutisteplist.generateTree

import com.ldcloli.lib.mutisteplist.Node


class MainActivity : AppCompatActivity() {
    var mRecyclerView: RecyclerView ?= null
    var mAdapter: MutistepListAdapter<TreeNode>?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val originData = Gson().fromJson(getFromAssets("mock.json"), TreeNode::class.java)
        val root = Node<TreeNode>(originData, null)

        generateTree(root)

        mRecyclerView = findViewById(R.id.recycler)
        mRecyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = MutistepListAdapter(root)
        mRecyclerView?.itemAnimator = DefaultItemAnimator()
        mRecyclerView?.adapter = mAdapter
    }

    fun getFromAssets(fileName: String): String {
        val stringBuilder = StringBuilder()
        //获得assets资源管理器
        val assetManager = this.assets
        //使用IO流读取json文件内容
        try {
            val bufferedReader = BufferedReader(InputStreamReader(
                    assetManager.open(fileName), "utf-8"))
            var line: String ?= null
            while ((bufferedReader.readLine().apply { line = this }) != null) {
                stringBuilder.append(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return stringBuilder.toString()
    }
}
