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
import kotlinx.android.synthetic.main.fragment_battery.*
import kotlinx.android.synthetic.main.fragment_battery.batteryIdFragment
import kotlinx.android.synthetic.main.fragment_sim.*

class SimFragment : BaseFragment() {
//    private lateinit var signalBroadcastReceiver: BroadcastReceiver

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSignalBroadcast()

    }

    private fun setupSignalBroadcast() {
        super.broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent?.action == GlobalConstants.ACTION2) {
                    val telephoneMgr =
                        context!!.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                    val simState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        telephoneMgr.signalStrength?.gsmSignalStrength
                    } else {
                        R.string.android_version
                    }
                    signalIdFragment.text = simState.toString()
                }

            }

        }
    }



}