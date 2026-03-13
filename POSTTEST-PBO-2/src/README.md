POSTTEST-2
# Sistem Pengelolaan Stok Baju Batik - OmahKoe

## 🎯 Fitur Utama

### 1. Kelola Data Kategori
- Tambah kategori baru
- Lihat semua kategori
- Edit kategori
- Hapus kategori (dengan cek relasi ke baju)

### 2. Kelola Data Supplier
- Tambah supplier dengan validasi:
    - Nama supplier tidak boleh kosong
    - Nomor telepon minimal 10 digit
    - Alamat tidak boleh kosong
- Lihat semua supplier
- Edit supplier
- Hapus supplier (dengan cek relasi ke baju)

### 3. Kelola Data Baju
- Tambah baju (pilih kategori & supplier)
- Lihat semua baju dengan detail lengkap
- Edit baju (nama, motif, ukuran, harga, stok, kategori, supplier)
- Hapus baju dengan konfirmasi


## 📚 Konsep OOP yang diterapkan kali ini dari modul ke tiga yaitu ada:

### 1. Encapsulation
- private String namaSupplier;        // Access Modifier: PRIVATE
- public String getNamaSupplier() { } // Access Modifier: PUBLIC
- public void setNamaSupplier() { }   // Access Modifier: PUBLIC


### 2. Access Modifier (4 Jenis)
- public - Bisa diakses dari mana saja (getter/setter, constructor)
- private - Hanya dalam class sendiri (field data)
- protected - Bisa diakses subclass & same package (helper methods)
- Default - Same package saja (tampilInfo method)

3. Getter & Setter
   Semua field mempunyai getter untuk membaca dan setter untuk mengubah nilai dengan validasi.

#### 🔒 Validasi Data
1. Kategori
Nama kategori tidak boleh kosong
Deskripsi tidak boleh kosong

2. Supplier
Nama supplier tidak boleh kosong
Nomor telepon minimal 10 digit (hanya angka)
Alamat tidak boleh kosong

3. Baju
Harus memilih kategori yang ada
Harus memilih supplier yang ada
Harga harus positif (> 0)
Stok tidak boleh negatif (≥ 0)
