package com.example.session3firebase

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.InterceptPlatformTextInput
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.session3firebase.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()
        binding.logout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, LoginPage::class.java))
        }
        binding.createNote.setOnClickListener {
            startActivity(Intent(this, AddNote::class.java))
        }
        binding.openNote.setOnClickListener {
            startActivity(Intent(this, allNotes::class.java))
        }
    }
}