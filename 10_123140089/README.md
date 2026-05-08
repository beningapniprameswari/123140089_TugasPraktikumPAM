# Tugas PAM 3 - Notes Application

Aplikasi Catatan (Notes) sederhana yang dibangun menggunakan Jetpack Compose dengan arsitektur MVVM, SQLDelight untuk penyimpanan lokal, dan Koin untuk Dependency Injection.

## Fitur Utama
- **Manajemen Catatan**: Tambah, Edit, dan Hapus catatan.
- **Pencarian**: Mencari catatan berdasarkan judul atau isi.
- **Favorit**: Menandai catatan sebagai favorit.
- **Pengaturan Tampilan**:
    - Mode Gelap (Dark Mode).
    - Urutan Catatan (Terbaru, Terlama, A-Z).
- **Informasi Perangkat**: Menampilkan informasi brand, model, versi Android, serta level baterai secara real-time.
- **Mode Offline**: Indikator koneksi internet di bagian atas layar.

## Tech Stack
- **UI**: Jetpack Compose
- **Navigation**: Compose Navigation
- **Architecture**: MVVM (ViewModel, StateFlow)
- **Database**: SQLDelight (SQLite)
- **Dependency Injection**: Koin
- **Local Settings**: DataStore Preferences
- **Platform Integration**: BatteryManager, ConnectivityManager, Build Info.

## Testing
Proyek ini mencakup pengujian komprehensif dengan total **24 test cases passed**:

### 1. Unit Test: NoteRepository (6 Tests)
Menguji interaksi database (CRUD) menggunakan driver SQLite in-memory.
- `getAllNotes returns list of notes`
- `insertNote adds note correctly`
- `updateNote modifies existing note`
- `deleteNote removes note from database`
- `toggleFavorite changes favorite status`
- `searchNotes returns matching notes`

### 2. Unit Test: NotesViewModel & ProfileViewModel (14 Tests)
Menguji logika bisnis dan State management menggunakan **MockK**.
- Initial state verification.
- Search functionality.
- Business logic for adding/deleting notes.
- Profile update logic.

### 3. Flow Test: Turbine (2 Tests)
Menguji aliran data asinkron (Flow/StateFlow).
- Memastikan UI State memancarkan data catatan terbaru saat repository berubah.
- Memastikan UI State bereaksi terhadap perubahan status jaringan (Online/Offline).

### 4. UI Test: NotesScreen (4 Tests)
Menguji komponen UI dan interaksi pengguna menggunakan **Compose Test Rule**.
- Menampilkan pesan saat data kosong.
- Menampilkan daftar catatan saat ada data.
- Memastikan tombol FAB (Tambah Catatan) dapat diklik.

## Cara Menjalankan Test
1. **Local Unit Tests** (Repository & ViewModel):
   ```bash
   ./gradlew test
   ```
2. **Android Instrumented Tests** (UI Test):
   Pastikan emulator atau perangkat fisik terhubung, lalu jalankan:
   ```bash
   ./gradlew connectedAndroidTest
   ```

---
**Author**: 8_123140089
