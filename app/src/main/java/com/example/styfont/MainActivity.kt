package com.example.styfont

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Typeface>()
        list.add(resources.getFont(R.font.f1))
        list.add(resources.getFont(R.font.f2))
        list.add(resources.getFont(R.font.f3))
        list.add(resources.getFont(R.font.f4))
        list.add(resources.getFont(R.font.f5))
        list.add(resources.getFont(R.font.f6))
        list.add(resources.getFont(R.font.f7))
        list.add(resources.getFont(R.font.f8))
        list.add(resources.getFont(R.font.f9))
        list.add(resources.getFont(R.font.f10))
        list.add(resources.getFont(R.font.f11))
        list.add(resources.getFont(R.font.f12))
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = rvAdapter(this,"Enter text here",list)

        search.setOnClickListener{
            rv.adapter = rvAdapter(this,text.text.toString(),list)
        }
    }
}