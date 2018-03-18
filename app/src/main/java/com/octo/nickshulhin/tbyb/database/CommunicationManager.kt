package com.octo.nickshulhin.tbyb.database

import android.content.Context
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.octo.nickshulhin.tbyb.model.Device
import com.octo.nickshulhin.tbyb.utils.Stealth

object CommunicationManager {
    private val database = FirebaseDatabase.getInstance()

    fun registerDevice(device: Device){
        database.getReference(device.deviceId).setValue(device)
    }

    fun setOnStealthModeChangedListener(device: Device, context: Context){
        database.getReference(device.deviceId).child("stealth").addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val stealthOn = snapshot.getValue(Boolean::class.java)!!
                   Stealth.stealthMode(context, stealthOn)
            }
            override fun onCancelled(databaseError: DatabaseError){}
        })
    }
}