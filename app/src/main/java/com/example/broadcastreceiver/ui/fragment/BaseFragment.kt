package com.example.broadcastreceiver.ui.fragment

import android.content.BroadcastReceiver
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    lateinit var broadcastReceiver: BroadcastReceiver

    override fun onPause() {
        context?.unregisterReceiver(broadcastReceiver)
        super.onPause()
    }
}