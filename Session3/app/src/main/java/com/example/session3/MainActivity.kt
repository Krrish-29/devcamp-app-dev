package com.example.session3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.session3.databinding.ActivityMainBinding
import java.net.URI

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.openwebpage.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/"))
            startActivity(intent)
        }
        binding.OpenApp.setOnClickListener {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        binding.editTextText.setOnClickListener {

        }
    }

}