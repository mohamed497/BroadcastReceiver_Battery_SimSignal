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
import androidx.fragment.app.activityViewModels
import com.example.broadcastreceiver.R
import kotlinx.android.synthetic.main.fragment_battery.*
import com.example.broadcastreceiver.base.GlobalConstants
import com.example.broadcastreceiver.ui.viewmodel.ItemViewModel


class BatteryFragment : Fragment() {
    private val viewModel: ItemViewModel by activityViewModels()
    private lateinit var batteryBroadcastReceiver: BroadcastReceiver
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_battery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBatteryBroadcast()
        batteryIdFragment.setOnClickListener {
            onItemClicked(batteryIdFragment.text.toString())
        }
    }

    private fun setupBatteryBroadcast() {
        batteryBroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == GlobalConstants.ACTION_BATTERY) {
                    val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    Log.d(BatteryFragment::class.java.simpleName, "onReceive battery $level")
                    batteryIdFragment.text = level.toString().plus(" ").plus("%")
                }
            }

        }
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
    fun onItemClicked(item: String){
        viewModel.selectItem(item)
    }
}