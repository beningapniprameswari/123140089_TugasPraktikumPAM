package com.example.tugaspam3.data

import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.tugaspam3.database.NoteDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class NoteRepositoryTest {
    private lateinit var repository: NoteRepository
    private lateinit var database: NoteDatabase

    @Before
    fun setup() {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        NoteDatabase.Schema.create(driver)
        database = NoteDatabase(driver)
        repository = NoteRepository(database)
    }

    @Test
    fun `getAllNotes returns list of notes`() = runTest {
        // Menggunakan timestamp eksplisit agar urutan terjamin (DESC)
        repository.insertNote("Title 1", "Content 1", createdAt = 1000L)
        repository.insertNote("Title 2", "Content 2", createdAt = 2000L)

        val notes = repository.getAllNotes().first()
        assertEquals(2, notes.size)
        // Title 2 (2000L) harus di atas Title 1 (1000L) karena DESC
        assertEquals("Title 2", notes[0].title)
        assertEquals("Title 1", notes[1].title)
    }

    @Test
    fun `insertNote adds note correctly`() = runTest {
        repository.insertNote("New Note", "Content")
        val notes = repository.getAllNotes().first()
        assertEquals(1, notes.size)
        assertEquals("New Note", notes[0].title)
    }

    @Test
    fun `updateNote modifies existing note`() = runTest {
        repository.insertNote("Original", "Content", id = 1L)
        repository.updateNote(1L, "Updated", "New Content")

        val note = repository.getNoteById(1L)
        assertNotNull(note)
        assertEquals("Updated", note?.title)
        assertEquals("New Content", note?.content)
    }

    @Test
    fun `deleteNote removes note from database`() = runTest {
        repository.insertNote("To Delete", "Content", id = 1L)
        repository.deleteNote(1L)

        val note = repository.getNoteById(1L)
        assertNull(note)
    }

    @Test
    fun `toggleFavorite changes favorite status`() = runTest {
        repository.insertNote("Note", "Content", id = 1L)
        
        repository.toggleFavorite(1L)
        assertEquals(true, repository.getNoteById(1L)?.isFavorite)

        repository.toggleFavorite(1L)
        assertEquals(false, repository.getNoteById(1L)?.isFavorite)
    }

    @Test
    fun `searchNotes returns matching notes`() = runTest {
        repository.insertNote("Apple", "Fruit")
        repository.insertNote("Banana", "Fruit")
        
        val results = repository.searchNotes("App").first()
        assertEquals(1, results.size)
        assertEquals("Apple", results[0].title)
    }
}
