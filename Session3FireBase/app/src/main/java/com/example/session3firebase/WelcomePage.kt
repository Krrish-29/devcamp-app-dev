package com.example.session3firebase

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannedString
import android.text.style.ForegroundColorSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.session3firebase.databinding.ActivityWelcomePageBinding
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import androidx.core.graphics.toColorInt

class WelcomePage : AppCompatActivity() {
    private val binding: ActivityWelcomePageBinding by lazy {
        ActivityWelcomePageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        val spannableString= SpannableString("Welcome")
        spannableString.setSpan(ForegroundColorSpan("#FF0000".toColorInt()),0,5,0)
        binding.welcomeText.text=spannableString

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        },4000)
    }
}