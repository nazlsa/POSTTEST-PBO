import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Kategori> listKategori = new ArrayList<>();
    static ArrayList<Supplier> listSupplier = new ArrayList<>();
    static ArrayList<Baju>     listBaju     = new ArrayList<>();
    static int idKategoriCounter = 1;
    static int idSupplierCounter = 1;
    static int idBajuCounter     = 1;

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            tampilMenuUtama();
            int pilihan = inputInt("Pilih menu: ");
            switch (pilihan) {
                case 1 -> menuKategori();
                case 2 -> menuSupplier();
                case 3 -> menuBaju();
                case 0 -> {
                    System.out.println("\n  Terima kasih telah menggunakan Sistem OmahKoe Batik ini!");
                    System.out.println("  Sampai jumpa lagi, ya!");
                    running = false;
                }
                default -> System.out.println("  [!] Pilihan tidak valid, coba lagi.");
            }
        }
        sc.close();
    }

    static void tampilMenuUtama() {
        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║   SISTEM PENGELOLAAN STOK BAJU BATIK     ║");
        System.out.println("║             OmahKoe Batik                ║");
        System.out.println("╠══════════════════════════════════════════╣");
        System.out.println("║  1. Kelola Data Kategori                 ║");
        System.out.println("║  2. Kelola Data Supplier                 ║");
        System.out.println("║  3. Kelola Data Baju                     ║");
        System.out.println("║  0. Exit Program                         ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    // untuk menu kategori
    static void menuKategori() {
        boolean back = false;
        while (!back) {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│       MENU DATA KATEGORI      │");
            System.out.println("├────────────────────────────── ┤");
            System.out.println("│  1. Tambah Kategori (Create)  │");
            System.out.println("│  2. Lihat Semua     (Read)    │");
            System.out.println("│  3. Edit Kategori   (Update)  │");
            System.out.println("│  4. Hapus Kategori  (Delete)  │");
            System.out.println("│  0. Kembali                   │");
            System.out.println("└──────────────────────────────┘");
            int pilihan = inputInt("Pilih: ");
            switch (pilihan) {
                case 1 -> tambahKategori();
                case 2 -> lihatKategori();
                case 3 -> editKategori();
                case 4 -> hapusKategori();
                case 0 -> back = true;
                default -> System.out.println("  [!] Pilihan tidak valid.");
            }
        }
    }

    static void tambahKategori() {
        System.out.println("\n--- Tambah Kategori ---");
        System.out.print("  Nama Kategori : "); String nama = sc.nextLine().trim();
        System.out.print("  Deskripsi     : "); String desk = sc.nextLine().trim();

        Kategori kategorisBaru = new Kategori(idKategoriCounter++, nama, desk);
        listKategori.add(kategorisBaru);
        System.out.println("  [✓] Kategori berhasil ditambahkan!");
    }

    static void lihatKategori() {
        System.out.println("\n--- Daftar Kategori ---");
        if (listKategori.isEmpty()) {
            System.out.println("  (Belum ada data kategori)");
            return;
        }
        for (Kategori k : listKategori) {
            System.out.println("  ─────────────────────");
            k.tampilInfo();
        }
        System.out.println("  ─────────────────────");
    }

    static void editKategori() {
        lihatKategori();
        if (listKategori.isEmpty()) return;
        int id = inputInt("  Masukkan ID Kategori yang diedit: ");
        Kategori target = cariKategori(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.println("  Data saat ini:"); target.tampilInfo();
        System.out.print("\n  Nama baru      : "); String nama = sc.nextLine().trim();
        System.out.print("  Deskripsi baru : "); String desk = sc.nextLine().trim();
        target.namaKategori = nama;
        target.deskripsi    = desk;
        System.out.println("  [✓] Kategori berhasil diperbarui!");
    }

    static void hapusKategori() {
        lihatKategori();
        if (listKategori.isEmpty()) return;
        int id = inputInt("  Masukkan ID Kategori yang dihapus: ");
        Kategori target = cariKategori(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        for (Baju b : listBaju) {
            if (b.kategori.idKategori == id) {
                System.out.println("  [!] Tidak bisa dihapus, masih dipakai baju: " + b.namaBaju);
                return;
            }
        }
        listKategori.remove(target);
        System.out.println("  [✓] Kategori berhasil dihapus!");
    }

    // untuk menu supplier / pengirim baju batiknya
    static void menuSupplier() {
        boolean back = false;
        while (!back) {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│       MENU DATA SUPPLIER     │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Tambah Supplier          │");
            System.out.println("│  2. Lihat Semua              │");
            System.out.println("│  3. Edit Supplier            │");
            System.out.println("│  4. Hapus Supplier           │");
            System.out.println("│  0. Kembali                  │");
            System.out.println("└──────────────────────────────┘");
            int pilihan = inputInt("Pilih: ");
            switch (pilihan) {
                case 1 -> tambahSupplier();
                case 2 -> lihatSupplier();
                case 3 -> editSupplier();
                case 4 -> hapusSupplier();
                case 0 -> back = true;
                default -> System.out.println("  [!] Pilihan kamu tidak valid.");
            }
        }
    }

    static void tambahSupplier() {
        System.out.println("\n--- Tambah Supplier ---");
        System.out.print("  Nama Supplier : "); String nama = sc.nextLine().trim();
        System.out.print("  No. Telepon   : "); String telp = sc.nextLine().trim();
        System.out.print("  Alamat        : "); String almt = sc.nextLine().trim();

        Supplier supplierBaru = new Supplier(idSupplierCounter++, nama, telp, almt);
        listSupplier.add(supplierBaru);
        System.out.println("  [✓] Supplier berhasil ditambahkan!");
    }

    static void lihatSupplier() {
        System.out.println("\n--- Daftar Supplier ---");
        if (listSupplier.isEmpty()) {
            System.out.println("  (Belum ada data supplier)");
            return;
        }
        for (Supplier s : listSupplier) {
            System.out.println("  ─────────────────────");
            s.tampilInfo();
        }
        System.out.println("  ─────────────────────");
    }

    static void editSupplier() {
        lihatSupplier();
        if (listSupplier.isEmpty()) return;
        int id = inputInt("  Masukkan ID Supplier yang diedit: ");
        Supplier target = cariSupplier(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.println("  Data saat ini:"); target.tampilInfo();
        System.out.print("\n  Nama baru      : "); String nama = sc.nextLine().trim();
        System.out.print("  No. Telp baru  : "); String telp = sc.nextLine().trim();
        System.out.print("  Alamat baru    : "); String almt = sc.nextLine().trim();

        target.namaSupplier = nama;
        target.noTelepon    = telp;
        target.alamat       = almt;
        System.out.println("  [✓] Supplier berhasil diperbarui!");
    }

    static void hapusSupplier() {
        lihatSupplier();
        if (listSupplier.isEmpty()) return;
        int id = inputInt("  Masukkan ID Supplier yang dihapus: ");
        Supplier target = cariSupplier(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        for (Baju b : listBaju) {
            if (b.supplier.idSupplier == id) {
                System.out.println("  [!] Tidak bisa dihapus, masih dipakai baju: " + b.namaBaju);
                return;
            }
        }
        listSupplier.remove(target);
        System.out.println("  [✓] Supplier berhasil dihapus!");
    }

    // untuk menu baju batik
    static void menuBaju() {
        boolean back = false;
        while (!back) {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│        MENU DATA BAJU        │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Tambah Baju              │");
            System.out.println("│  2. Lihat Semua              │");
            System.out.println("│  3. Edit Baju                │");
            System.out.println("│  4. Hapus Baju               │");
            System.out.println("│  0. Kembali                  │");
            System.out.println("└──────────────────────────────┘");
            int pilihan = inputInt("Pilih: ");
            switch (pilihan) {
                case 1 -> tambahBaju();
                case 2 -> lihatBaju();
                case 3 -> editBaju();
                case 4 -> hapusBaju();
                case 0 -> back = true;
                default -> System.out.println("  [!] Pilihan kamu tidak valid.");
            }
        }
    }

    static void tambahBaju() {
        System.out.println("\n--- Tambah Baju ---");

        lihatKategori();
        if (listKategori.isEmpty()) {
            System.out.println("  [!] Tambahkan Kategori terlebih dahulu.");
            return;
        }
        int idKat = inputInt("  Pilih ID Kategori: ");
        Kategori kat = cariKategori(idKat);
        if (kat == null) { System.out.println("  [!] ID Kategori tidak ditemukan."); return; }

        lihatSupplier();
        if (listSupplier.isEmpty()) {
            System.out.println("  [!] Tambahkan Supplier terlebih dahulu.");
            return;
        }
        int idSup = inputInt("  Pilih ID Supplier: ");
        Supplier sup = cariSupplier(idSup);
        if (sup == null) { System.out.println("  [!] ID Supplier tidak ditemukan."); return; }

        System.out.print("  Nama Baju : "); String nama  = sc.nextLine().trim();
        System.out.print("  Motif     : "); String motif = sc.nextLine().trim();
        System.out.print("  Ukuran    : "); String ukrn  = sc.nextLine().trim();
        double harga = inputDouble("  Harga (Rp): ");
        int    stok  = inputInt("  Stok (pcs) : ");

        Baju bajuBaru = new Baju(idBajuCounter++, nama, motif, ukrn, harga, stok, kat, sup);
        listBaju.add(bajuBaru);
        System.out.println("  [✓] Baju berhasil ditambahkan!");
    }

    static void lihatBaju() {
        System.out.println("\n--- Daftar Stok Baju Batik OmahKoe ---");
        if (listBaju.isEmpty()) {
            System.out.println("  (Belum ada data baju)");
            return;
        }
        for (Baju b : listBaju) {
            System.out.println("  ═══════════════════════════════");
            b.tampilInfo();
        }
        System.out.println("  ═══════════════════════════════");
        System.out.println("  Total: " + listBaju.size() + " item baju");
    }

    static void editBaju() {
        lihatBaju();
        if (listBaju.isEmpty()) return;
        int id = inputInt("  Masukkan ID Baju yang diedit: ");
        Baju target = cariBaju(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.println("  Data saat ini:"); target.tampilInfo();

        System.out.print("\n  Nama baru  (Enter = skip): "); String nama = sc.nextLine().trim();
        System.out.print("  Motif baru (Enter = skip): "); String motif = sc.nextLine().trim();
        System.out.print("  Ukuran baru (Enter = skip): "); String ukrn = sc.nextLine().trim();
        System.out.print("  Harga baru (0 = skip)    : "); double harga = inputDoubleLangsung();
        System.out.print("  Stok baru  (0 = skip)    : "); int stok = inputIntLangsung();

        if (!nama.isEmpty())  target.namaBaju = nama;
        if (!motif.isEmpty()) target.motif    = motif;
        if (!ukrn.isEmpty())  target.ukuran   = ukrn;
        if (harga > 0)        target.harga    = harga;
        if (stok > 0)         target.stok     = stok;

        System.out.print("  Ganti Kategori? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            lihatKategori();
            int idKat = inputInt(" Pilih ID Kategori baru: ");
            Kategori kat = cariKategori(idKat);
            if (kat != null) target.kategori = kat;
        }

        System.out.print("  Ganti Supplier? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            lihatSupplier();
            int idSup = inputInt("  Pilih ID Supplier baru: ");
            Supplier sup = cariSupplier(idSup);
            if (sup != null) target.supplier = sup;
        }

        System.out.println("  [✓] Data baju berhasil diperbarui!");
    }

    static void hapusBaju() {
        lihatBaju();
        if (listBaju.isEmpty()) return;
        int id = inputInt("  Masukkan ID Baju yang dihapus: ");
        Baju target = cariBaju(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.print("  Yakin hapus '" + target.namaBaju + "'? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            listBaju.remove(target);
            System.out.println("  [✓] Baju berhasil dihapus!");
        } else {
            System.out.println("  (Penghapusan dibatalkan)");
        }
    }

    static Kategori cariKategori(int id) {
        for (Kategori k : listKategori)
            if (k.idKategori == id) return k;
        return null;
    }

    static Supplier cariSupplier(int id) {
        for (Supplier s : listSupplier)
            if (s.idSupplier == id) return s;
        return null;
    }

    static Baju cariBaju(int id) {
        for (Baju b : listBaju)
            if (b.idBaju == id) return b;
        return null;
    }

    static int inputInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try { return Integer.parseInt(line); }
            catch (NumberFormatException e) { System.out.println("  [!] Masukkan angka yang valid."); }
        }
    }

    static int inputIntLangsung() {
        String line = sc.nextLine().trim();
        try { return Integer.parseInt(line); } catch (Exception e) { return 0; }
    }

    static double inputDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try { return Double.parseDouble(line); }
            catch (NumberFormatException e) { System.out.println("  [!] Masukkan angka yang valid."); }
        }
    }

    static double inputDoubleLangsung() {
        String line = sc.nextLine().trim();
        try { return Double.parseDouble(line); } catch (Exception e) { return 0; }
    }
}

// test commit