package com.example.session3firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.session3firebase.databinding.ActivityLoginPageBinding
import com.example.session3firebase.databinding.ActivityWelcomePageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.MainScope

class LoginPage : AppCompatActivity() {
    private val binding: ActivityLoginPageBinding by lazy {
        ActivityLoginPageBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser: FirebaseUser?=auth.currentUser
        if(currentUser!=null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()

        binding.donthaveanaccount.setOnClickListener {
            startActivity(Intent(this, SignUpPage::class.java))
        }
        binding.login.setOnClickListener {
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()
            if(email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"Please fill all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener {
                        task -> if(task.isSuccessful){
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}