package com.example.broadcastreceiver.ui.fragment.broadcasts

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.TelephonyManager
import com.example.broadcastreceiver.base.GlobalConstants

class SimBroadcast(private val simCallback: SimCallback) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == GlobalConstants.ACTION_SIM) {
            val telephoneMgr =
                context!!.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val signal = (telephoneMgr.signalStrength?.level).toString()
                simCallback.onSimSignalChanged(signal)

            } else {
                simCallback.onSimSignalChanged("Old Version")
            }

        }
    }

    interface SimCallback {
        fun onSimSignalChanged(signal: String)
    }
}