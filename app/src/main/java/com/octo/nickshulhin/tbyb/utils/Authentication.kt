package com.octo.nickshulhin.tbyb.utils

import android.content.Context
import java.util.*

object Authentication {
    fun getDeviceId(context: Context): String {
        return Storage.readStringFromPreferences(context, "DEVICE_ID")
    }

    fun authenticateDevice(context: Context) {
        Storage.writeStringToPreferences(context, "DEVICE_ID", UUID.randomUUID().toString())
    }
}