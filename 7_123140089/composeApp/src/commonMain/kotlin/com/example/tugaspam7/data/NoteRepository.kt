package com.example.tugaspam7.data

import com.example.tugaspam7.database.AppDatabase
import com.example.tugaspam7.database.Note
import kotlinx.coroutines.flow.Flow
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

class NoteRepository(database: AppDatabase) {
    private val queries = database.appDatabaseQueries

    fun getAllNotes(): Flow<List<Note>> {
        return queries.selectAllNotes().asFlow().mapToList(Dispatchers.IO)
    }

    fun searchNotes(query: String): Flow<List<Note>> {
        return queries.searchNotes(query, query).asFlow().mapToList(Dispatchers.IO)
    }

    suspend fun insertNote(title: String, content: String) {
        queries.insertNote(title, content, System.currentTimeMillis())
    }

    suspend fun updateNote(id: Long, title: String, content: String) {
        queries.updateNote(title, content, id)
    }

    suspend fun deleteNote(id: Long) {
        queries.deleteNote(id)
    }
}
