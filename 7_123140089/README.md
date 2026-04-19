# 📱 Notes App (Week 7 - Local Data Storage)

Aplikasi **Notes App** adalah aplikasi mobile berbasis Android yang digunakan untuk menyimpan dan mengelola catatan (notes) secara lokal menggunakan database dan preferences.

Proyek ini dibuat sebagai bagian dari tugas praktikum minggu ke-7 pada mata kuliah **Pengembangan Aplikasi Mobile**.

---

## 🚀 Fitur Utama

- 📝 CRUD Notes (Create, Read, Update, Delete)
- 🔍 Search notes berdasarkan judul/konten
- 💾 Penyimpanan data lokal menggunakan SQLDelight
- ⚙️ Settings (Theme, dll) menggunakan DataStore
- 📡 Offline-first (data tetap tersedia tanpa internet)
- ⚡ UI State (Loading, Empty, Content)

---

## 🧠 Konsep yang Digunakan

- Local Storage (Data Persistence)
- SQLDelight (Database lokal)
- DataStore Preferences (Settings)
- Repository Pattern
- Offline-first architecture
- State Management (StateFlow)

---

## 🛠️ Teknologi yang Digunakan

- Kotlin
- Jetpack Compose
- SQLDelight
- DataStore Preferences
- Coroutines & Flow

---

## 🌐 Deskripsi Singkat

Aplikasi ini memungkinkan pengguna untuk membuat, membaca, mengedit, dan menghapus catatan secara lokal. Semua data disimpan di dalam database lokal sehingga aplikasi tetap dapat digunakan tanpa koneksi internet (offline-first).

---

## 🏗️ Arsitektur Aplikasi


UI (Compose)
↓
ViewModel
↓
Repository
↓
Local Database (SQLDelight)


Database digunakan sebagai **single source of truth**.

---

## 🗂️ Struktur Project

data/
├── db/
├── repository/

ui/
├── screen/
├── components/

viewmodel/

---

## 🗄️ Database Schema (SQLDelight)

CREATE TABLE Note (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title TEXT NOT NULL,
  content TEXT NOT NULL,
  created_at INTEGER NOT NULL
);

selectAll:
SELECT * FROM Note ORDER BY created_at DESC;

insert:
INSERT INTO Note(title, content, created_at)
VALUES (?, ?, ?);

update:
UPDATE Note SET title = ?, content = ?
WHERE id = ?;

delete:
DELETE FROM Note WHERE id = ?;

search:
SELECT * FROM Note WHERE title LIKE ? OR content LIKE ?;

---

## 🔄 UI State
 Aplikasi menangani beberapa kondisi:

Loading → saat data dimuat
Content → saat data tersedia
Empty → saat tidak ada data
Error → jika terjadi kesalahan

---

## 📸 Screenshot
### 📝 Notes List

### ➕ Add/Edit Note

### 🔍 Search

---

## 🎥 Demo Video

https://link-video-demo.com

---

## ⚙️ Cara Menjalankan
1. Clone repository:
2. git clone https://github.com/username/notes-app.git
3. Buka di Android Studio
4. Sync Gradle
5. Jalankan aplikasi di emulator atau device

---
