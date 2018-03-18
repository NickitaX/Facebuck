package com.octo.nickshulhin.tbyb.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE

object Storage {

    internal fun writeStringToPreferences(context: Context, prefName: String, content: String) {
        val editor = context.getSharedPreferences("PREFERENCES", MODE_PRIVATE).edit()
        editor.putString(prefName, content)
        editor.commit()
    }

    fun readStringFromPreferences(context: Context, prefName: String): String {
        val prefs = context.getSharedPreferences("PREFERENCES", MODE_PRIVATE)
        return prefs.getString(prefName, "")
    }
}