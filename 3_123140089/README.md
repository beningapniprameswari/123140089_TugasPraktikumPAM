# Tugas Praktikum 3 Pengembangan Aplikasi Mobile
## Bening Apni Prameswari
## 123140089
## PAM RB

Aplikasi sederhana berbasis Jetpack Compose yang menampilkan halaman profil pengguna.
Project ini dibuat untuk memenuhi tugas praktikum Pengembangan Aplikasi Mobile – Pertemuan 3.

## 📱 Fitur Aplikasi

Aplikasi menampilkan informasi profil pengguna dengan komponen UI modern dari Jetpack Compose, meliputi:

* Foto profil berbentuk circular
* Nama dan NIM
* Deskripsi singkat (bio)
* Informasi kontak:

  * Email
  * Nomor telepon
  * Lokasi
* Tombol Detail Profile

## 🧩 Komponen UI yang Digunakan

Aplikasi ini menggunakan beberapa komponen utama dari Jetpack Compose:

* Column
* Row
* Box
* Card
* Text
* Button
* Image
* Icon

## 🔁 Reusable Composable Functions

Project ini menggunakan beberapa Composable Function yang reusable, yaitu:

* `ProfileHeader()`
  Menampilkan foto profil, nama, NIM, dan bio.

* `ProfileCard()`
  Menampilkan card berisi informasi profil.

* `InfoItem()`
  Menampilkan setiap item informasi seperti email, phone, dan location.

## 🎨 Tampilan Aplikasi

Berikut tampilan aplikasi ketika dijalankan:

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/5d667925-c65d-4f04-acfa-b43a183cc6d1" />

## 🛠 Teknologi yang Digunakan

* Kotlin
* Jetpack Compose
* Android Studio
* Material 3 UI

## 📂 Struktur Project

```
tugaspam3
│
├── MainActivity.kt
│
├── ProfileHeader()
├── ProfileCard()
└── InfoItem()
```

## 🚀 Cara Menjalankan Project

1. Clone repository ini

```
git clone https://github.com/username/tugaspam3.git
```

2. Buka project di Android Studio

3. Jalankan aplikasi menggunakan Android Emulator/Device
