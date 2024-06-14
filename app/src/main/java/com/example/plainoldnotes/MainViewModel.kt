package com.example.plainoldnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plainoldnotes.com.example.plainoldnotes.data.NoteEntity
import com.example.plainoldnotes.data.SampleDataProvider
import java.util.Date

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    /*
    val notesList = MutableLiveData<List<NoteEntity>>()

    init {
        notesList.value = SampleDataProvider.getNotes()
    }

     */

    private val _notesList = MutableLiveData<List<NoteEntity>>()
    val notesList: LiveData<List<NoteEntity>> get() = _notesList

    init {
        // Add some dummy data
        _notesList.value = listOf(
            NoteEntity(0, Date(), "Note 1"),
            NoteEntity(1, Date(), "Note 2"),
            NoteEntity(2, Date(),"Note 3")
        )
    }
}