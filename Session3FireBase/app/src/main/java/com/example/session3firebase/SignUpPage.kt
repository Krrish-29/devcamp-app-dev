package com.example.session3firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.session3firebase.databinding.ActivitySignUpPageBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpPage : AppCompatActivity() {
    private val binding: ActivitySignUpPageBinding by lazy{
        ActivitySignUpPageBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()

        binding.alreadyhaveanaccount.setOnClickListener {
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }
        binding.signupbutton.setOnClickListener {
            val email=binding.Email.text.toString()
            val username=binding.Username.text.toString()
            val password=binding.Password.text.toString()
            val repeatpassword=binding.RepeatPassword.text.toString()

            if(email.isEmpty()||username.isEmpty()||password.isEmpty()||repeatpassword.isEmpty()){
                Toast.makeText(this,"Fill all the Details", Toast.LENGTH_SHORT).show()
            }
            else if(password!=repeatpassword){
                Toast.makeText(this,"Password must be same", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registered Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginPage::class.java))
                        } else {
                            Toast.makeText(this,"Registration Failed",Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

    }
}