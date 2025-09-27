package com.example.session3firebase

import android.telephony.data.RouteSelectionDescriptor
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.session3firebase.databinding.NotesitemBinding

class NoteAdapter(private val notes: List<NoteItem>,private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    interface OnItemClickListener{
        fun onDeleteClick(noteId: String)
        fun onUpdateClick(noteId:String,title:String,description:String)
    }
    class NoteViewHolder(val binding: NotesitemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteItem) {
            binding.title.text = note.title
            binding.description.text = note.description
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val binding = NotesitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {
        val note = notes[position]
        holder.bind(note)
        holder.binding.Delete.setOnClickListener {
            itemClickListener.onDeleteClick(note.noteId)
        }
        holder.binding.Update.setOnClickListener {
            itemClickListener.onUpdateClick(note.noteId,note.title,note.description)
        }
    }
}