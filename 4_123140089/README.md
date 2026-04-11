# Tugas Praktikum 4 PAM – Profile App (MVVM)

Nama: Bening Apni Prameswari  
NIM: 123140089  
Kelas: Pengembangan Aplikasi Mobile RB  
---
## 📌 Deskripsi
Aplikasi ini merupakan pengembangan dari Profile App (Tugas 3) dengan penambahan konsep MVVM, StateFlow, Edit Profile, dan Dark Mode menggunakan Jetpack Compose.

---
## 🚀 Fitur

- **MVVM Pattern**
  - ViewModel & StateFlow
  - Data menggunakan `ProfileUiState`

- **Edit Profile**
  - Edit nama & bio
  - Menggunakan state hoisting
  - Tombol Save untuk update data

- **Dark Mode**
  - Switch untuk light/dark mode
  - State disimpan di ViewModel

---

## 🧠 Arsitektur
- **Model:** ProfileUiState  
- **ViewModel:** ProfileViewModel  
- **View:** Composable UI  

Alur:

UI → ViewModel → StateFlow → UI

---
## 🧩 Komponen
Column, Row, Box, Card, Text, Button, Image, Icon, TextField, Switch

---
## 🔁 Composable
ProfileHeader, ProfileCard, InfoItem, EditProfileForm

---
## 🎨 Tampilan

**Profile**
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/56402c9d-7e9a-4f16-bb08-65f19591579b" />


**Edit Profile**
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/083f557d-b939-4da8-a367-7e3c0fef3272" />


**Dark Mode**
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/3843ebb2-3f92-4852-b458-965ad218f772" />

---
## 📂 Struktur

model/

viewmodel/

ui/

MainActivity.kt

---

## ▶️ Cara Menjalankan

git clone https://github.com/beningapniprameswari/4_123140089.git

Buka di Android Studio → Run Emulator

---
