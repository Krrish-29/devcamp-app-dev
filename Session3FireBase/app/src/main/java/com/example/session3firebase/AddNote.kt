package com.example.session3firebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.session3firebase.databinding.ActivityAddNoteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNote : AppCompatActivity() {
    private val binding: ActivityAddNoteBinding by lazy{
        ActivityAddNoteBinding.inflate(layoutInflater)
    }
    private lateinit var database: DatabaseReference
    private lateinit var  auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database= FirebaseDatabase.getInstance().reference
        auth= FirebaseAuth.getInstance()
        binding.savebutton.setOnClickListener {
            val title=binding.title.text.toString()
            val note=binding.note.text.toString()
            if(title.isEmpty()||note.isEmpty()){
                Toast.makeText(this,"Please fill all fields",Toast.LENGTH_SHORT).show()
            }
            else{
                val currentUser=auth.currentUser
                currentUser?.let{user ->
                    val noteKey=database.child("users").child(user.uid).child("notes").push().key
                    val noteItem= NoteItem(title,note,noteKey?:"")
                    if(noteKey!=null){
                        database.child("user").child(user.uid).child("notes").child(noteKey).setValue(noteItem)
                            .addOnCompleteListener {
                                task -> if(task.isSuccessful){
                                    Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT).show()
                                finish()
                                }
                                else{
                                Toast.makeText(this,"Note not saved", Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                }
            }
        }
    }
}