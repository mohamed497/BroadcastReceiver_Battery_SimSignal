package com.example.broadcastreceiver.ui.adapter

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.broadcastreceiver.ui.fragment.BatteryFragment
import com.example.broadcastreceiver.ui.fragment.SimFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                BatteryFragment()
            }
            1 -> {
                SimFragment()
            }
            else -> {
                BatteryFragment()
            }
        }
    }

}