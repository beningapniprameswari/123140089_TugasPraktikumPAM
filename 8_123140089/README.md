# Tugas Praktikum PAM Minggu 8 - Platform Specific Features
## Bening Apni Prameswari
## 123140089
## Pengembangan Aplikasi Mobile RB

---

## 📌 Deskripsi Tugas
Pada tugas ini dilakukan pengembangan aplikasi Notes App dengan menambahkan fitur platform-specific menggunakan pendekatan Dependency Injection (Koin) serta implementasi fitur device dan network.

---

## 🎯 Tujuan
- Mengimplementasikan Dependency Injection menggunakan Koin
- Mengakses informasi perangkat (Device Info)
- Mendeteksi status jaringan (Network Monitor)
- Menampilkan informasi device dan status network di UI

---

## ⚙️ Fitur yang Diimplementasikan

### 1. Dependency Injection (Koin)
- Menggunakan Koin untuk mengelola dependency
- Semua dependency di-inject melalui module Koin

### 2. Device Info (Expect/Actual)
- Menggunakan konsep `expect/actual`
- Menampilkan informasi device seperti:
  - OS
  - Versi
  - Device Name

### 3. Network Monitor (Expect/Actual)
- Mendeteksi status jaringan (Online / Offline)
- Implementasi berbeda untuk setiap platform

### 4. Settings Screen
- Menampilkan informasi device
- UI sederhana untuk menampilkan data device

### 5. Network Status Indicator
- Indikator status network pada main screen
- Update secara real-time

---

## 🏗️ Arsitektur
Aplikasi menggunakan pendekatan modular:
- Presentation Layer (UI)
- Domain Layer
- Data Layer
- Dependency Injection (Koin)

---

## 📸 Screenshot

### Device Info
<img width="615" height="634" alt="image" src="https://github.com/user-attachments/assets/f2d7e759-4ba9-4a5b-9552-2ba1fd42a244" />

### Network Indicator
<img width="526" height="334" alt="image" src="https://github.com/user-attachments/assets/19506516-73d4-4f27-995a-599f58cb4862" />
<img width="579" height="371" alt="image" src="https://github.com/user-attachments/assets/2d1e8f2c-28ff-4cdd-8961-ee211bdc98b6" />

---

## 🎥 Video Demo
https://youtu.be/E1sNzV9xUYw 

---

## 🚀 Cara Menjalankan Project

1. Clone repository: git clone https://github.com/beningapniprameswari/123140089_TugasPraktikumPAM/tree/7536c33c1173cbd185114c01f84fef2cdd892fae/8_123140089
2. Buka project di Android Studio
3. Sync Gradle
4. Jalankan aplikasi di emulator / device
