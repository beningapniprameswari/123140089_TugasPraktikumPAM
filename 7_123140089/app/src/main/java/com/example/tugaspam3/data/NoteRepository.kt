package com.example.tugaspam3.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.tugaspam3.database.NoteDatabase
import com.example.tugaspam3.database.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class NoteRepository(db: NoteDatabase) {
    private val queries = db.noteEntityQueries

    fun getAllNotes(): Flow<List<NoteEntity>> {
        return queries.getAllNotes().asFlow().mapToList(Dispatchers.IO)
    }

    fun searchNotes(query: String): Flow<List<NoteEntity>> {
        return queries.searchNotes(query).asFlow().mapToList(Dispatchers.IO)
    }

    suspend fun insertNote(title: String, content: String, id: Long? = null) {
        queries.insertNote(
            id = id,
            title = title,
            content = content,
            isFavorite = false,
            createdAt = System.currentTimeMillis()
        )
    }

    suspend fun updateNote(id: Long, title: String, content: String) {
        val existing = queries.getNoteById(id).executeAsOne()
        queries.insertNote(
            id = id,
            title = title,
            content = content,
            isFavorite = existing.isFavorite,
            createdAt = existing.createdAt
        )
    }

    suspend fun deleteNote(id: Long) {
        queries.deleteNote(id)
    }

    suspend fun toggleFavorite(id: Long) {
        queries.toggleFavorite(id)
    }

    fun getNoteById(id: Long): NoteEntity? {
        return queries.getNoteById(id).executeAsOneOrNull()
    }
}
