# 📱 News Reader App (Week 6 - Networking & REST API)

Aplikasi **News Reader** adalah aplikasi mobile berbasis Kotlin Multiplatform yang digunakan untuk mengambil dan menampilkan data berita dari API publik menggunakan **Ktor Client**.

Proyek ini dibuat sebagai bagian dari tugas praktikum minggu ke-6 pada mata kuliah Pengembangan Aplikasi Mobile.

---

## 🚀 Fitur Utama

- 🔎 Mengambil data berita dari API (JSONPlaceholder / NewsAPI)
- 📰 Menampilkan daftar artikel (title, description, image)
- 📄 Detail artikel saat item diklik
- 🔄 Pull to Refresh
- ⚡ Loading, Success, dan Error State handling
- 🧱 Menggunakan Repository Pattern

---

## 🧠 Konsep yang Digunakan

- HTTP & REST API (GET, POST, dll)
- Ktor Client untuk networking
- Kotlinx Serialization untuk parsing JSON
- Repository Pattern untuk manajemen data
- State Management (UiState)

---

## 🛠️ Teknologi yang Digunakan

- Kotlin Multiplatform
- Jetpack Compose / Compose Multiplatform
- Ktor Client
- Kotlinx Serialization
- Coroutines & Flow

---

## 🌐 API yang Digunakan

Contoh API:
- https://jsonplaceholder.typicode.com/posts  
atau  
- https://newsapi.org/

---

## 🔄 UI State

Aplikasi menggunakan state untuk menangani kondisi:

- **Loading** → Menampilkan progress indicator
- **Success** → Menampilkan data
- **Error** → Menampilkan pesan error + tombol retry

---

## 📸 Screenshot

### 🔄 Loading State
![Loading](screenshots/loading.png)

### ✅ Success State
![Success](screenshots/success.png)

### ❌ Error State
![Error](screenshots/error.png)

---

## 🎥 Demo Video

Masukkan link video di sini:

---

## ⚙️ Cara Menjalankan

1. Clone repository: 
2. Buka project di Android Studio
3. Sync Gradle
4. Jalankan aplikasi
