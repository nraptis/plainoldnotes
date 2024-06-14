package com.example.plainoldnotes

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plainoldnotes.com.example.plainoldnotes.data.NoteEntity
import com.example.plainoldnotes.databinding.ListItemBinding

class NotesListAdapter(private val notesList: List<NoteEntity>):
RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("onCreateViewHolder", "onCreateViewHolder...")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = notesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("onBindViewHolder", "onBindViewHolder...")
        val note = notesList[position]
        with(holder.binding) {
            noteText.text = note.text
        }
    }
}