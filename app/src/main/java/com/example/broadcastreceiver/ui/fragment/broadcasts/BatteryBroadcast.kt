package com.example.broadcastreceiver.ui.fragment.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import com.example.broadcastreceiver.base.GlobalConstants


class BatteryBroadcast(private val batteryCallback: BatteryCallback) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == GlobalConstants.ACTION_BATTERY) {
            val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            batteryCallback.onBatteryChanged(level)
        }
    }

    interface BatteryCallback {
        fun onBatteryChanged(battery: Int?)
    }
}