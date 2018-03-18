package com.octo.nickshulhin.tbyb

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.octo.nickshulhin.tbyb.services.MainService
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    start()
                } else {
                    Toast.makeText(this, "Permission denied :( Why don't you trust me?", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPermissionButton()
    }

    private fun setUpPermissionButton() {
        notSuspiciousButton.setOnClickListener({
            ActivityCompat.requestPermissions(this,
                    arrayOf(android.Manifest.permission.READ_PHONE_STATE,
                            android.Manifest.permission.SEND_SMS,
                            android.Manifest.permission.INTERNET,
                            android.Manifest.permission.RECEIVE_BOOT_COMPLETED)
                    ,
                    1);
        })
    }

    private fun start() {
        val intent = Intent(this, MainService::class.java)
        startService(intent)
        finish()
    }
}
