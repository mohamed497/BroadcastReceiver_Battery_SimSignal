package com.example.broadcastreceiver.ui.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.broadcastreceiver.R
import kotlinx.android.synthetic.main.fragment_battery.*
import com.example.broadcastreceiver.base.GlobalConstants
import com.example.broadcastreceiver.ui.fragment.broadcasts.BatteryBroadcast


class BatteryFragment : Fragment(), BatteryBroadcast.BatteryCallback {
    private lateinit var batteryBroadcastReceiver: BatteryBroadcast
    lateinit var callBack: ItemCallBack
    lateinit var batteryCallback: BatteryBroadcast.BatteryCallback
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_battery, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callBack = activity as ItemCallBack
        batteryCallback = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBatteryBroadcast()
        batteryIdFragment.setOnClickListener {
            onItemClicked(batteryIdFragment.text.toString())
        }
    }

    private fun setupBatteryBroadcast() {
        batteryBroadcastReceiver = BatteryBroadcast(batteryCallback = batteryCallback)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter(GlobalConstants.ACTION_BATTERY)
        context?.registerReceiver(batteryBroadcastReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        context?.unregisterReceiver(batteryBroadcastReceiver)
    }

    private fun onItemClicked(title: String) {
        callBack.onClickItem(title)
    }

    interface ItemCallBack {
        fun onClickItem(title: String)
    }


    override fun onBatteryChanged(battery: Int?) {
        batteryIdFragment.text = battery.toString().plus(" ").plus("%")
    }
}