package com.example.plainoldnotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.plainoldnotes.data.NoteEntity
import com.example.plainoldnotes.data.SampleDataProvider

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    val notesList = MutableLiveData<List<NoteEntity>>()

    init {
        notesList.value = SampleDataProvider.getNotes()
    }
}