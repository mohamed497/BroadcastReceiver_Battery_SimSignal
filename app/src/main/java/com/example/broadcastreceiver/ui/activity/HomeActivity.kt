package com.example.broadcastreceiver.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.broadcastreceiver.R
import com.example.broadcastreceiver.ui.adapter.ViewPagerAdapter
import com.example.broadcastreceiver.ui.fragment.BatteryFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), BatteryFragment.ItemCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupViewPagerAdapter()
        val batteryFragment = BatteryFragment()
        batteryFragment.callBack = this
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

    override fun onClickItem(title: String) {
        setTitle(title)
    }
}