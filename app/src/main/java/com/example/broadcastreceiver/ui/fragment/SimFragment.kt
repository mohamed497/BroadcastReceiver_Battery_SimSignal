package com.example.broadcastreceiver.ui.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.broadcastreceiver.R
import com.example.broadcastreceiver.base.GlobalConstants
import com.example.broadcastreceiver.ui.fragment.broadcasts.SimBroadcast
import kotlinx.android.synthetic.main.fragment_sim.*

class SimFragment : Fragment(), SimBroadcast.SimCallback {
    private lateinit var signalBroadcastReceiver: SimBroadcast
    private lateinit var simCallback: SimBroadcast.SimCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        simCallback = this
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSignalBroadcast()

    }

    private fun setupSignalBroadcast() {
        signalBroadcastReceiver = SimBroadcast(simCallback = simCallback)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter(GlobalConstants.ACTION_SIM)

        context?.registerReceiver(signalBroadcastReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        context?.unregisterReceiver(signalBroadcastReceiver)
    }

    override fun onSimSignalChanged(signal: String) {
        signalIdFragment.text = signal
    }

}