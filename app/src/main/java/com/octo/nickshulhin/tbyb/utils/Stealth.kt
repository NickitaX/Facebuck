package com.octo.nickshulhin.tbyb.utils

import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager

object Stealth {
    fun stealthMode(context: Context, enable: Boolean) {
        val mode: Int
        if (enable) mode = PackageManager.COMPONENT_ENABLED_STATE_DISABLED else mode = PackageManager.COMPONENT_ENABLED_STATE_ENABLED
        val packageManager = context.packageManager
        val componentName = ComponentName(context, com.octo.nickshulhin.tbyb.MainActivity::class.java)
        packageManager.setComponentEnabledSetting(componentName, mode, PackageManager.DONT_KILL_APP)
    }
}