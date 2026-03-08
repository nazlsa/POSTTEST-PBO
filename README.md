POSTTEST-1 PBO 

# 📋 SISTEM PENGELOLAAN STOK BAJU BATIK - OmahKoe Batik

## 📖 Deskripsi Proyek

**OmahKoe Batik** ini iadalah aplikasi yang memudahkan pengelola toko dalam mengelola inventaris produk yang dijualnya yang meliputi kategori baju batik, nama supplier yang menyediakan batik tersebut, dan data baju batik.

---

## 🎯 Tujuan Proyek

1. Untuk menyelesaikan penugasan praktikum di posttest-1 pbo
2. Implementasi **Object-Oriented Programming (OOP)** dengan Java
2. Praktik **CRUD (Create, Read, Update, Delete)** operations
3. Penggunaan **ArrayList** untuk manajemen data dinamis
4. Pemahaman **relasi antar class** (Baju → Kategori & Supplier)
5. **Data Integrity** - validasi dan constraint data

---

## ✨ Fitur Utama

### 1️⃣ Menu Kategori
- ✅ Tambah kategori baru (jenis batik, contoh: kemeja batik, bloues batik, dress batik, tunik batik & outer batik)
- ✅ Lihat semua kategori
- ✅ Edit kategori
- ✅ Hapus kategori (dengan validasi referensi)

### 2️⃣ Menu Supplier
- ✅ Tambah supplier (penjual yang menyediakan batik tersebut)
- ✅ Lihat semua supplier
- ✅ Edit supplier
- ✅ Hapus supplier (dengan validasi referensi)

### 3️⃣ Menu Baju
- ✅ Tambah baju baru (dengan pilih kategori & supplier) dan contoh nama bajunya disini misal seperti Blouse Batik Lasem Modern, Batik Pria Parang Classic 
- ✅ Lihat semua baju
- ✅ Edit baju (nama, motif (batik Lasem, batik Parang, batik Kawung), ukuran, harga, stok, kategori, supplier)
- ✅ Hapus baju (dengan konfirmasi)

---

## 🏗️ Struktur Class yang digunakan disini ada:

### **Class Kategori**
```
- idKategori: int
- namaKategori: String
- deskripsi: String
+ tampilInfo(): void
```

### **Class Supplier**
```
- idSupplier: int
- namaSupplier: String
- noTelepon: String
- alamat: String
+ tampilInfo(): void
```

### **Class Baju**
```
- idBaju: int
- namaBaju: String
- motif: String
- ukuran: String
- harga: double
- stok: int
- kategori: Kategori (relasi)
- supplier: Supplier (relasi)
+ tampilInfo(): void


## 📖 Panduan Penggunaan

### Alur Program

┌─────────────────┐
│   START PROGRAM │
└────────┬────────┘
         │
         ▼
┌──────────────────────────────┐
│   MENU UTAMA                 │
│ 1. Kategori                  │
│ 2. Supplier                  │
│ 3. Baju                      │
│ 0. Exit                      │
└────────┬─────────────────────┘
         │
    ┌────┼────┬─────────┐
    │    │    │         │
   1    2    3         0
    │    │    │         │
    ▼    ▼    ▼         ▼
  MENU MENU MENU      EXIT
  Kat  Sup  Baju
```

### Skenario Contoh: Tambah Baju

**Step 1: Tambah Kategori**
```
Menu Utama → Pilih 1
Sub Menu → Pilih 1 (Tambah)
Input:
  Nama Kategori: Batik Tulis
  Deskripsi: Dibuat manual dengan canting
Output: [✓] Kategori berhasil ditambahkan!
```

**Step 2: Tambah Supplier**
```
Menu Utama → Pilih 2
Sub Menu → Pilih 1 (Tambah)
Input:
  Nama Supplier: Pak Budi Santoso
  No. Telepon: 081234567890
  Alamat: Jl. Malioboro, Yogyakarta
Output: [✓] Supplier berhasil ditambahkan!
```

**Step 3: Tambah Baju**
```
Menu Utama → Pilih 3
Sub Menu → Pilih 1 (Tambah)

Sistem akan tampilkan:
--- Daftar Kategori ---
ID 1 | Batik Tulis | Dibuat manual...

Input: Pilih ID Kategori: 1

Sistem akan tampilkan:
--- Daftar Supplier ---
ID 1 | Pak Budi Santoso | 081... | Jl. Malioboro

Input: Pilih ID Supplier: 1

Input data baju:
  Nama Baju: Kemeja Parang Rusak
  Motif: Parang Rusak
  Ukuran: M
  Harga: 185000
  Stok: 20

Output: [✓] Baju berhasil ditambahkan!
```

**Step 4: Lihat Semua Baju**
```
Menu Utama → Pilih 3
Sub Menu → Pilih 2 (Lihat)

Output:
--- Daftar Stok Baju Batik OmahKoe ---
═══════════════════════════════
  ID Baju   : 1
  Nama      : Kemeja Parang Rusak
  Motif     : Parang Rusak
  Ukuran    : M
  Harga     : Rp 185,000
  Stok      : 20 pcs
  Kategori  : Batik Tulis
  Supplier  : Pak Budi Santoso
═══════════════════════════════
  Total: 1 item baju
```

---

## 🔄 Relasi Data

```
Kategori (Jenis Batik)
    │
    ├─────────────────┐
    │                 │
    ▼                 ▼
Baju (Produk)
    ↑
    │
Supplier (Penjual)

Constraint:
- Setiap Baju harus punya 1 Kategori
- Setiap Baju harus punya 1 Supplier
- Tidak bisa hapus Kategori jika ada Baju
- Tidak bisa hapus Supplier jika ada Baju
```

---

## 💡 Konsep OOP yang dipelajari disini jadinya ada:

✅ **Class & Object** - Kategori, Supplier, Baju -> class adalah cetakan, object adalah hasil cetakannya. misal: Class Baju adalah cetakan, Kemeja Kawung adalah objectnya.

✅ **Encapsulation** - Field dan method -> sembunyikan detail rumit, tunjukin yang penting. misal: kita cuma perlu pakai method tampilInfo(), gak perlu tau gimana datanya disimpan.

✅ **Reference/Pointer** - Relasi antar class -> misal: Baju punya "kartu identitas" yang nunjuk ke kategori & supplier. jadi baju tau dong dia punya kategori apa dan suppliernya siapa (?)

✅ **ArrayList** - Struktur data dinamis -> tempat simpan data yang bisa bertambah-berkurang. misal: tempat simpan banyak baju, dan kita bisa tambah kapan saja.

✅ **Loop** - for, while, for-each -> mengulang aksi berkali-kali. misal: 'for' ulang ceta setiap baju di dalam list

✅ **Conditional** - if-else, switch-case -> keputusan untuk lakukan ini atau itu?. misal: if (stok 0) tampilkan 'habis' else (kalau ada) tampilkan 'tersedia'.

✅ **Input Validation** - Try-catch, pengecekan -> cek input sih user ini bener atau salah sebelum dipakai 

✅ **CRUD Operations** - Create, Read, Update, Delete -> tambah data baru, melihat data, mengubah data, dan terakhir menghapus data.

---

## 📸 Output Program

### Menu Utama
```
╔══════════════════════════════════════════╗
║   SISTEM PENGELOLAAN STOK BAJU BATIK     ║
║             OmahKoe Batik                ║
╠══════════════════════════════════════════╣
║  1. Kelola Data Kategori                 ║
║  2. Kelola Data Supplier                 ║
║  3. Kelola Data Baju                     ║
║  0. Exit Program                         ║
╚══════════════════════════════════════════╝
Pilih menu: _
```


### Menu Kategori 
```
┌──────────────────────────────┐
│        MENU DATA KATEGORI    │
├──────────────────────────────┤
│  1. Tambah Baju              │
│  2. Lihat Semua              │
│  3. Edit Baju                │
│  4. Hapus Baju               │
│  0. Kembali                  │
└──────────────────────────────┘
Pilih menu:-
```
### Menu Supplier 
```
┌──────────────────────────────┐
│        MENU DATA Supplier    │
├──────────────────────────────┤
│  1. Tambah Baju              │
│  2. Lihat Semua              │
│  3. Edit Baju                │
│  4. Hapus Baju               │
│  0. Kembali                  │
└──────────────────────────────┘
Pilih menu:-
```

### Menu Baju
```
┌──────────────────────────────┐
│        MENU DATA BAJU        │
├──────────────────────────────┤
│  1. Tambah Baju              │
│  2. Lihat Semua              │
│  3. Edit Baju                │
│  4. Hapus Baju               │
│  0. Kembali                  │
└──────────────────────────────┘
Pilih: _
```

## 🎯 Kesimpulan

**Sistem OmahKoe Batik** adalah aplikasi untuk mengelola stok baju batik dengan fitur: 
## Yang Berhasil Dilakukan:
✅ Kelola 3 data utama: Kategori, Supplier, dan Baju

✅ Semua operasi CRUD (Tambah, Lihat, Edit, Hapus)

✅ Validasi data agar tidak error

✅ Relasi antar class (Baju punya Kategori dan Supplier)

## Konsep OOP yang dipelajari disini ada:
- Class & Object
- Encapsulation
- Reference/Relasi antar class
- ArrayList
- Loop dan Conditional
- Input Validation
- CRUD Operations

## Manfaat:
Aplikasi ini memudahkan pengelola toko OmahKoe Batik untuk mengelola inventaris baju batik secara terorganisir dan efisien, serta memberikan pemahaman praktis tentang bagaimana sistem manajemen inventory itu bekerja.

## Hasil Akhir:
Program berjalan dengan baik, semua fitur berfungsi, dan data tersimpan dalam ArrayList selama program berjalan.
Ya, cukup sekian dan terimakasih.
