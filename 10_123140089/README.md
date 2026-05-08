# Tugas PAM 10 - Testing dan Dependency Injection
## Bening Apni Prameswari
## 123140089
## Pengembangan Aplikasi Mobile RB

Aplikasi Catatan (Notes) sederhana yang dibangun menggunakan Jetpack Compose dengan arsitektur MVVM, SQLDelight untuk penyimpanan lokal, dan Koin untuk Dependency Injection.

## 🕹️ Fitur Utama
- **Manajemen Catatan**: Tambah, Edit, dan Hapus catatan.
- **Pencarian**: Mencari catatan berdasarkan judul atau isi.
- **Favorit**: Menandai catatan sebagai favorit.
- **Pengaturan Tampilan**:
    - Mode Gelap (Dark Mode).
    - Urutan Catatan (Terbaru, Terlama, A-Z).
- **Informasi Perangkat**: Menampilkan informasi brand, model, versi Android, serta level baterai secara real-time.
- **Mode Offline**: Indikator koneksi internet di bagian atas layar.

## ⚙️ Tech Stack
- **UI**: Jetpack Compose
- **Navigation**: Compose Navigation
- **Architecture**: MVVM (ViewModel, StateFlow)
- **Database**: SQLDelight (SQLite)
- **Dependency Injection**: Koin
- **Local Settings**: DataStore Preferences
- **Platform Integration**: BatteryManager, ConnectivityManager, Build Info.

## 🖼️ Media
### Screenshots
<img width="1600" height="900" alt="image" src="https://github.com/user-attachments/assets/9ad83b95-0db7-45ab-8d94-1b8e73ca4fc4" />
<img width="1600" height="900" alt="image" src="https://github.com/user-attachments/assets/c47b4860-dd10-45d3-8099-efd5d962acb8" />

### Video Demo: https://youtu.be/1scuReq0emI

## ▶️ Testing
Proyek ini mencakup pengujian komprehensif dengan total **18 unit test cases passed**:

### 1. Unit Test: NoteRepository (6 Tests)
Menguji interaksi database (CRUD) menggunakan driver SQLite in-memory.
- `getAllNotes returns list of notes`
- `insertNote adds note correctly`
- `updateNote modifies existing note`
- `deleteNote removes note from database`
- `toggleFavorite changes favorite status`
- `searchNotes returns matching notes`

### 2. Unit Test: NotesViewModel (6 Tests)
- `initial state displays device and battery info`
- `onSearchQueryChange updates state`
- `deleteNote calls repository`
- `uiState emits updated notes when repository changes` (Turbine Flow Test)
- `uiState reflects network status change` (Turbine Flow Test)
- `toggleDarkMode calls settingsManager`

### 3. Unit Test: ProfileViewModel (5 Tests)
- `initial state displays device and battery info`
- `onSearchQueryChange updates state`
- `addNote calls repository`
- `deleteNote calls repository`
- `uiState emits updated notes when repository changes`

### 4. Others (1 Test)
- `ExampleUnitTest`: `addition_isCorrect`

### 5. Instrumented UI Test: NotesScreen (3 Tests)
- `notesScreen_emptyState_showsInfoMessage`
- `notesScreen_withData_showsNotesList`
- `notesScreen_fabClick_isPossible`

## Cara Menjalankan Test
1. **Local Unit Tests**:
   ```bash
   ./gradlew test
   ```
2. **Android Instrumented Tests**:
   Pastikan emulator atau perangkat fisik terhubung, lalu jalankan:
   ```bash
   ./gradlew connectedAndroidTest
   ```
---
