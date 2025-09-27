package com.example.session3firebase

import android.app.AlertDialog
import android.database.DatabaseUtils
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.session3firebase.databinding.ActivityAddNoteBinding
import com.example.session3firebase.databinding.ActivityAllNotesBinding
import com.example.session3firebase.databinding.UpdateNotesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class allNotes : AppCompatActivity(), NoteAdapter.OnItemClickListener {
    private val binding: ActivityAllNotesBinding by lazy{
        ActivityAllNotesBinding.inflate(layoutInflater)
    }
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth= FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance().reference
        recyclerView=binding.noteView
        recyclerView.layoutManager= LinearLayoutManager(this)
        val currentUser=auth.currentUser
        currentUser?.let{
            user ->
            val noteReference=database.child("user").child(user.uid).child("notes")
            noteReference.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val noteList=mutableListOf<NoteItem>()
                    for(noteSnapshot in snapshot.children){
                        val note=noteSnapshot.getValue(NoteItem::class.java)
                        note?.let{
                            noteList.add(it)
                        }
                    }
                    noteList.reverse()
                    val adapter= NoteAdapter(noteList,this@allNotes)
                    recyclerView.adapter=adapter
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }

    }

    override fun onDeleteClick(noteId: String) {
        val currentUser=auth.currentUser
        currentUser?.let{
            user->
            val noteReference=database.child("user").child(user.uid).child("notes")
            noteReference.child(noteId).removeValue()
        }
    }

    override fun onUpdateClick(noteId: String,title:String,description:String) {
        val dialogBinding= UpdateNotesBinding.inflate(LayoutInflater.from(this))
        val dialog= AlertDialog.Builder(this).setView(dialogBinding.root)
            .setTitle("Update Note")
            .setPositiveButton("Update"){
                dialog,_->
                val newTitle=dialogBinding.title.text.toString()
                val newDescription=dialogBinding.note.text.toString()
                updateNoteDatabase(noteId,newTitle,newDescription)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel"){
                dialog,_->
                dialog.dismiss()
            }
            .create()
        dialogBinding.title.setText(title)
        dialogBinding.note.setText(description)
        dialog.show()

    }
    private fun updateNoteDatabase(noteId:String,newTitle:String,newDescription:String){
        val currentUser=auth.currentUser
        currentUser?.let{
                user->
            val noteReference=database.child("user").child(user.uid).child("notes")
            val updateNote= NoteItem(newTitle,newDescription,noteId)
            noteReference.child(noteId).setValue(updateNote)
                .addOnCompleteListener {
                        task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"Note Updated", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this,"Failed to update",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}