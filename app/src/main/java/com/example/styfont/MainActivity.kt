package com.example.styfont

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.styfont.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = rvAdapter(this,"Enter text here",list)

        binding.search.setOnClickListener{
            binding.rv.adapter = rvAdapter(this,binding.text.text.toString(),list)
        }
    }
}