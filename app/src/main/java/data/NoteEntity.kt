package com.example.plainoldnotes.data

import com.example.plainoldnotes.com.example.plainoldnotes.NEW_NOTE_ID
import java.util.Date

data class NoteEntity (
    var id: Int,
    var date: Date,
    var text: String
) {
    constructor(): this(NEW_NOTE_ID, Date(), "")
    constructor(date: Date, text: String): this(NEW_NOTE_ID, date, text)
}
