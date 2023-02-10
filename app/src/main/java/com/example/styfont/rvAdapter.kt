package com.example.styfont

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rvlayout.view.*

class rvAdapter(val context: Context,val listdata:String) : RecyclerView.Adapter<rvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(LayoutInflater.from(context).inflate(R.layout.rvlayout,parent,false))
        return viewHolder
    }

    @SuppressLint("ServiceCast")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.te.text = listdata
        holder.copy.setOnClickListener {
            val clipboardManager = holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("xyz",holder.te.text.toString())
            clipboardManager.setPrimaryClip(clipData)
        }

    }

    override fun getItemCount(): Int {
        return 2
    }

    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val te:TextView = itemview.tv
        val copy:ImageView = itemview.copy
    }
}