package com.example.broadcastreceiver.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.broadcastreceiver.R
import com.example.broadcastreceiver.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        setupViewPagerAdapter()
    }


    private fun setupViewPagerAdapter() {
        val adapter = ViewPagerAdapter(this)
        view_pager.adapter = adapter
    }

}