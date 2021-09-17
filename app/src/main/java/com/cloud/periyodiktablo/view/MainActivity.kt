package com.cloud.periyodiktablo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloud.periyodiktablo.adapter.ElementAdapter
import com.cloud.periyodiktablo.databinding.ActivityMainBinding
import com.cloud.periyodiktablo.model.ElementModelData.getElementList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val adapter = ElementAdapter(elementList = getElementList())
        binding.recyclerView.adapter = adapter
        val layoutManager = GridLayoutManager(this, 9, RecyclerView.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.recycledViewPool.setMaxRecycledViews(0, 0)
    }
}