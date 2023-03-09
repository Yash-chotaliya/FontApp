package com.example.styfont

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.styfont.databinding.RvlayoutBinding

class rvAdapter(private val context : Context, private val data:String, private val list : ArrayList<Typeface>) : RecyclerView.Adapter<rvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvlayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rvtext.typeface = list[position]
        holder.rvtext.text = data
        holder.copy.setOnClickListener {
            val clipboardManager = holder.itemView.context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("xyz",holder.rvtext.text.toString())
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(context,"text copied",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemBinding:RvlayoutBinding):RecyclerView.ViewHolder(itemBinding.root) {
        val rvtext:TextView = itemBinding.rvtext
        val copy:ImageView = itemBinding.copy
    }
}