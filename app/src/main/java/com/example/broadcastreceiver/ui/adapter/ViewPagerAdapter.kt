package com.example.broadcastreceiver.ui.adapter

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.broadcastreceiver.ui.fragment.BatteryFragment
import com.example.broadcastreceiver.ui.fragment.SimFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragments = arrayOf(BatteryFragment(), SimFragment())

    override fun getItemCount(): Int = fragments.size


    override fun createFragment(position: Int): Fragment = fragments[position]

}