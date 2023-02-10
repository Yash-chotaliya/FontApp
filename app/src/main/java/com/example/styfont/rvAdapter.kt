package com.example.styfont

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rvlayout.view.*

class rvAdapter(private val context : Context, private val data:String,val list : ArrayList<Typeface>) : RecyclerView.Adapter<rvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rvlayout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rvtext.typeface = list[position]
        holder.rvtext.text = data
        holder.copy.setOnClickListener {
            val clipboardManager = holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("xyz",holder.rvtext.text.toString())
            clipboardManager.setPrimaryClip(clipData)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview) {
        val rvtext:TextView = itemview.rvtext
        val copy:ImageView = itemview.copy
    }
}