POSTTEST - 3

# 📦 Sistem Pengelolaan Stok Baju Batik - OmahKoe

## 🎯 Deskripsi Proyek

Sistem Pengelolaan Stok Baju Batik adalah aplikasi berbasis Java yang dirancang untuk mengelola inventaris produk OmahKoe Batik. Sistem ini menggunakan konsep **Object-Oriented Programming (OOP)** termasuk **Inheritance** untuk mengelola berbagai jenis produk dengan efisien.

---

## 📋 Fitur Utama

### 1. ✅ Kelola Data Kategori
- **Tambah Kategori** - Menambahkan kategori produk baru
- **Lihat Semua** - Menampilkan daftar lengkap kategori
- **Edit Kategori** - Mengubah data kategori yang sudah ada
- **Hapus Kategori** - Menghapus kategori (dengan validasi relasi)

### 2. ✅ Kelola Data Supplier
- **Tambah Supplier** - Menambahkan supplier baru dengan validasi:
    - Nama supplier tidak boleh kosong
    - Nomor telepon minimal 10 digit
    - Alamat tidak boleh kosong
- **Lihat Semua** - Menampilkan daftar lengkap supplier
- **Edit Supplier** - Mengubah data supplier
- **Hapus Supplier** - Menghapus supplier (dengan validasi relasi)

### 3. ✅ Kelola Data Baju (Child Class dari Produk)
- **Tambah Baju** - Menambahkan baju dengan:
    - Memilih kategori & supplier
    - Input motif dan ukuran (spesifik baju)
- **Lihat Semua** - Menampilkan daftar stok baju dengan detail lengkap
- **Edit Baju** - Mengubah informasi baju (nama, motif, ukuran, harga, stok)
- **Hapus Baju** - Menghapus baju dengan konfirmasi

### 4. ✅ Kelola Data Aksesori (Child Class dari Produk)
- **Tambah Aksesori** - Menambahkan aksesori dengan:
    - Memilih kategori & supplier
    - Input jenis, bahan, dan warna (spesifik aksesori)
- **Lihat Semua** - Menampilkan daftar aksesori dengan detail lengkap
- **Edit Aksesori** - Mengubah informasi aksesori
- **Hapus Aksesori** - Menghapus aksesori dengan konfirmasi

---

## 🏗️ Struktur OOP & Inheritance

### Diagram Class Hierarchy
                ┌──────────────┐
                │   Produk     │
                │  (Parent)    │
                └──────┬───────┘
                       │
      ┌────────────────┴────────────────┐
      │                                  │
┌──▼───┐                        ┌────▼─────┐
│ Baju │                        │ Aksesori  │
│(Child)                        │ (Child)   │
└──────┘                        └───────────┘


### Konsep OOP yang Diterapkan
* Access Modifier ada 4 jenis
1. public - Bisa diakses dari mana saja (getter/setter, method publik)
2. private - Hanya dalam class sendiri (field data)
3. protected - Bisa diakses oleh subclass & same package (helper methods)
4. default - Same package saja (method tampilInfo, validasi)

* Inheritance (Pewarisan)
// Baju mewarisi dari Produk
  public class Baju extends Produk {
  // Otomatis punya semua property & method dari Produk
  // Hanya perlu tambah yang spesifik untuk Baju
  }

Aksesori juga mewarisi dari Produk
public class Aksesori extends Produk {
Sama seperti Baju, hanya dengan properties unik
}

🔒 Validasi Data
Kategori:
✅ Nama kategori tidak boleh kosong
✅ Deskripsi tidak boleh kosong

Supplier:
✅ Nama supplier tidak boleh kosong
✅ Nomor telepon minimal 10 digit (hanya angka)
✅ Alamat tidak boleh kosong

Baju (extends Produk):
✅ Harus memilih kategori yang ada
✅ Harus memilih supplier yang ada
✅ Harga harus positif (> 0)
✅ Stok tidak boleh negatif (≥ 0)
✅ Motif & ukuran tidak boleh kosong

Aksesori (extends Produk):
✅ Harus memilih kategori yang ada
✅ Harus memilih supplier yang ada
✅ Harga harus positif (> 0)
✅ Stok tidak boleh negatif (≥ 0)
✅ Jenis, bahan & warna tidak boleh kosong

Relasi:
✅ Kategori tidak bisa dihapus jika masih digunakan produk
✅ Supplier tidak bisa dihapus jika masih digunakan produk

*Urutan Penggunaan yang Benar*
Buat Kategori terlebih dahulu

Menu 1 → Pilih 1 (Tambah Kategori)
Isi nama kategori dan deskripsi
Buat Supplier

Menu 2 → Pilih 1 (Tambah Supplier)
Isi nama, nomor telepon (min 10 digit), alamat
Buat Baju atau Aksesori

Menu 3 (Baju) / Menu 4 (Aksesori)
Pilih 1 (Tambah)
Pilih kategori dan supplier dari daftar yang sudah ada
Isi data sesuai tipe produk

