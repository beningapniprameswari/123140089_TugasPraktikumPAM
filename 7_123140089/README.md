# Tugas Praktikum 7 PAM – Notes App
## **Nama:** Bening Apni Prameswari  
## **NIM:** 123140089  
## **Kelas:** Pengembangan Aplikasi Mobile RB

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
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/dfd66aa6-e4d1-4524-8488-b92e0bdcc482" />

### ➕ Add Note
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/12a8746d-a7ee-4357-b4ec-09bdf7dd908f" />

### Delete Note
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/21115d8f-3770-4758-884d-ed891247a6e8" />

### ✂️ Edit Note
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/449a72ab-a0cb-49f9-ae40-0a4ed0352251" />

### 🔍 Search
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/7896c9d2-6775-486d-a3cc-5660194d5902" />

### 🪄 Theme
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/fad113e0-694d-4a00-9ac1-5b04f63fb571" />

---

## 🎥 Demo Video
https://youtu.be/tqY5vockfm0

---

## ⚙️ Cara Menjalankan
1. Clone repository: git clone https://github.com/beningapniprameswari/123140089_TugasPraktikumPAM/tree/534bf9ce7b4bfef1bb470b1a25640536a0c7533d/7_123140089
3. Buka di Android Studio
4. Sync Gradle
5. Jalankan aplikasi di emulator atau device

---
