package com.octo.nickshulhin.tbyb.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.octo.nickshulhin.tbyb.services.MainService

class RebootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, p1: Intent) {
        val myIntent = Intent(context, MainService::class.java)
        context.startService(myIntent)
    }
}