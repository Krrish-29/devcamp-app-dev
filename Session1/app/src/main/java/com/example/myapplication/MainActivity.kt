package com.example.myapplication

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate:hi!")
        Toast.makeText(this,"OnCreate",Toast.LENGTH_SHORT).show()


        val toastButton=findViewById<Button>(R.id.Toastbutton)
        toastButton.setOnClickListener{
            Toast.makeText(this,"Hi Guys!",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"Hi Guys!",Toast.LENGTH_LONG).show()
        }


        val frag=findViewById<Button>(R.id.fragButton)
        frag.setOnClickListener {
            val fragment= BlankFragment()
            val transient=supportFragmentManager.beginTransaction()
            transient.replace(R.id.frameLayout,fragment)
            transient.commit()
        }

    }
    override fun onStart(){
        super.onStart()
        Log.d("TAG","onStart:hi!")
        Toast.makeText(this,"OnStart",Toast.LENGTH_SHORT).show()
    }
    override fun onResume(){
        super.onResume()
        Log.d("TAG","onResume:hi!")
        Toast.makeText(this,"OnResume",Toast.LENGTH_SHORT).show()
    }
    override fun onPause(){
        super.onPause()
        Log.d("TAG","onPause:hi!")
        Toast.makeText(this,"OnPause",Toast.LENGTH_SHORT).show()
    }
    override fun onStop(){
        super.onStop()
        Log.d("TAG","onStop:hi!")
        Toast.makeText(this,"OnStop",Toast.LENGTH_SHORT).show()
    }
    override fun onRestart(){
        super.onRestart()
        Log.d("TAG","onRestart:hi!")
        Toast.makeText(this,"OnRestart",Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy:hi!")
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()
    }
}