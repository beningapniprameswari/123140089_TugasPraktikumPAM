# Tugas Praktikum 6 PAM – News Reader App
## **Nama:** Bening Apni Prameswari  
## **NIM:** 123140089  
## **Kelas:** Pengembangan Aplikasi Mobile RB

---
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
<img width="1920" height="1080" alt="Screenshot (388)" src="https://github.com/user-attachments/assets/2bc1baf4-3ccf-44cc-9e96-93ccf1ab94a3" />

### ✅ Success State
<img width="1920" height="1080" alt="Screenshot (390)" src="https://github.com/user-attachments/assets/6f1f32b0-9e1e-4643-a2c0-e228b579de0e" />

### ❌ Error State
<img width="1920" height="1080" alt="Screenshot (393)" src="https://github.com/user-attachments/assets/9c6855a7-33bd-47e1-a322-cc9f01a0faad" />

### 📄Detail News
<img width="1920" height="1080" alt="Screenshot (394)" src="https://github.com/user-attachments/assets/cd57b512-a090-414d-b47a-cffbaff8d881" />

---

## 🎥 Demo Video
https://youtu.be/URF47lp-NUU

---

## ⚙️ Cara Menjalankan

1. Clone repository: https://github.com/beningapniprameswari/123140089_TugasPraktikumPAM/tree/93e71a7bad64cb78893d323638ed1136a8e0ec68/6_123140089 
2. Buka project di Android Studio
3. Sync Gradle
4. Jalankan aplikasi
