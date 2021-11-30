package com.example.broadcastreceiver.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.broadcastreceiver.R
import com.example.broadcastreceiver.ui.adapter.ViewPagerAdapter
import com.example.broadcastreceiver.ui.viewmodel.ItemViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupViewPagerAdapter()
        observeOnItem()
    }


    private fun observeOnItem() {
        viewModel.observeOnItem(this, { item ->
            setTitle(item)
        })
    }

    private fun setupViewPagerAdapter() {
        val adapter = ViewPagerAdapter(this)
        view_pager.adapter = adapter
    }

    override fun onBackPressed() {
        if (view_pager.currentItem == 0) {
            super.onBackPressed()
        } else {
            view_pager.currentItem = view_pager.currentItem - 1
        }
    }
}