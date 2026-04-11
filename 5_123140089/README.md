# Tugas Praktikum 5 PAM – Notes App Navigation

## **Nama:** Bening Apni Prameswari  
## **NIM:** 123140089  
## **Kelas:** Pengembangan Aplikasi Mobile RB

---

## 📌 Deskripsi

Aplikasi ini merupakan pengembangan dari tugas sebelumnya dengan menambahkan fitur navigasi antar layar menggunakan Jetpack Compose Navigation. Aplikasi memiliki beberapa screen seperti Notes, Favorites, dan Profile serta mendukung perpindahan antar halaman dengan baik.

---

## 🚀 Fitur Utama

### 1. Bottom Navigation
- Terdiri dari 3 tab:
  - Notes
  - Favorites
  - Profile
- Navigasi menggunakan NavController

### 2. Notes Screen
- Menampilkan daftar catatan
- Klik item → menuju Detail Screen

### 3. Favorite Notes
- Menampilkan daftar catatan yang ditandai sebagai favorite
- User dapat menandai note sebagai favorite
- Note favorit akan muncul di tab Favorite Notes
- Memudahkan user mengakses catatan penting dengan cepat

### 4. Detail Screen
- Menampilkan detail note berdasarkan `noteId`
- Menggunakan navigation argument

### 5. Add Note Screen
- Tombol Floating Action Button (FAB)
- Navigasi ke halaman tambah note

### 6. Edit and Delete Note Screen
- Mengedit catatan yang sudah ada
- Data dikirim menggunakan `noteId`
- User dapat memperbarui isi note
- User juga dapat menghapus (delete) note
- Setelah dihapus, note tidak akan muncul lagi di daftar

### 7. Navigation Flow
- Mendukung:
  - Forward navigation
  - Back navigation
- Menggunakan `navController.navigate()` dan `popBackStack()`

---

## 🧠 Konsep yang Digunakan

- Jetpack Compose
- Navigation Compose
- MVVM (lanjutan dari tugas sebelumnya)
- State Management

---


---

## 📱 Tampilan Aplikasi

### Notes Screen
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/a59afe95-4db1-4287-a45c-324593a842bb" />

### Detail Screen
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/33c8f8c5-99bb-43de-b673-7682810dc38b" />

### Favorite Notes
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/ba86d474-325e-4bb7-a3de-dd17d90bf72b" />

### Add Note
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/f6b574b7-5296-4092-9469-3d112c33c095" />

### Edit and Delete Note
<img width="670" height="378" alt="image" src="https://github.com/user-attachments/assets/9071f967-2085-4c42-bd23-546c076603be" />

---

## 🎬 Link Video Demontrasi: https://youtu.be/X9leGAfDsaY 

---

## ▶️ Cara Menjalankan

1. Clone repository: git clone https://github.com/beningapniprameswari/5_123140089.git 

2. Buka di Android Studio

3. Jalankan di Emulator/Device

---

## 📌 Kriteria Tugas

✔ Bottom Navigation (3 tab)  
✔ Navigation dengan argument (noteId)  
✔ Navigation flow (forward & back)  
✔ Struktur code rapi  
✔ README + screenshot  

---

## 🎯 Catatan

- Navigation menggunakan NavHost & NavController
- Setiap screen dipisah dalam folder `screens`
- Routing menggunakan string (route)

---
