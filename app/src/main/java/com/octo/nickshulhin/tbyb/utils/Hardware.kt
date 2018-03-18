package com.octo.nickshulhin.tbyb.utils

object Hardware {
    fun getDeviceName(): String {
        return android.os.Build.MANUFACTURER + android.os.Build.PRODUCT
    }
}