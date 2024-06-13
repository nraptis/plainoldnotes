package com.example.plainoldnotes.data

import com.example.plainoldnotes.com.example.plainoldnotes.data.NoteEntity
import java.util.Date

class SampleDataProvider {

    companion object {
        private val sampleText1 = "A simple note"
        private val sampleText2 = "A note with\nline feed..."
        private val sampleText3 = """
            It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.
            The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
            """.trimIndent()

    }

    private fun getDate(diff: Long): Date {
        return Date(Date().time + diff)
    }

    fun getNotes() = arrayListOf(
        NoteEntity(1, getDate(0), sampleText1),
        NoteEntity(2, getDate(1), sampleText2),
        NoteEntity(3, getDate(2), sampleText3)
    )

}