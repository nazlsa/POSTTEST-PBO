🚀 Fitur Utama
Manajemen Kategori: Membuat dan mengelola pengelompokan produk.

Manajemen Supplier: Mencatat informasi pemasok barang.

Manajemen Produk (Baju & Aksesori): Pencatatan detail produk termasuk stok, harga, motif, dan bahan.

Sistem Validasi: Pengecekan stok otomatis dan validasi input data.

Demo OOP: Menu khusus untuk menguji konsep Polymorphism dan Method Overloading.

🏗️ Struktur OOP & Arsitektur Kode
Proyek ini mengimplementasikan pilar-pilar utama OOP:

Inheritance (Pewarisan): - Kelas Baju dan Aksesori adalah subclass yang mewarisi atribut serta metode dari superclass Produk.

Polymorphism: - Method Overriding: Metode tampilInfo() dirombak di setiap subclass untuk menampilkan detail spesifik (seperti motif baju atau bahan aksesori).

Method Overloading: Berbagai versi metode getInfo() dan cekKompatibilitas() digunakan untuk memberikan informasi berdasarkan parameter yang berbeda.

Encapsulation (Enkapsulasi): - Penggunaan akses modifier private pada atribut kelas dan penyediaan getter/setter untuk mengontrol akses data.

Abstraction:

Penggunaan kelas induk Produk sebagai cetak biru untuk entitas barang di dalam sistem.

📝 Contoh Penggunaan
Saat aplikasi berjalan, Anda dapat memilih menu "Baju" untuk menambah stok. Sistem akan meminta Anda memilih Kategori dan Supplier yang sudah ada sebelum membuat produk baru. Anda juga bisa mencoba menu "Test Polymorphism" untuk melihat bagaimana satu metode yang sama dapat menghasilkan output berbeda tergantung objeknya.