import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Kategori> listKategori = new ArrayList<>();
    static ArrayList<Supplier> listSupplier = new ArrayList<>();
    static ArrayList<Baju>     listBaju     = new ArrayList<>();
    static ArrayList<Aksesori> listAksesori = new ArrayList<>();

    static int idKategoriCounter = 1;
    static int idSupplierCounter = 1;
    static int idBajuCounter     = 1;
    static int idAksesoriCounter = 1;

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
                case 4 -> menuAksesori();
                case 5 -> testPolymorphism();
                case 0 -> {
                    System.out.println("\n  Terima kasih telah menggunakan Sistem OmahKoe Batik!");
                    System.out.println("  Sampai jumpa!");
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
        System.out.println("║  4. Kelola Data Aksesori                 ║");
        System.out.println("║  5. TEST POLYMORPHISM                    ║");
        System.out.println("║  0. Exit Program                         ║");
        System.out.println("╚══════════════════════════════════════════╝");
    }

    static void menuKategori() {
        boolean back = false;
        while (!back) {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│       MENU DATA KATEGORI     │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Tambah Kategori          │");
            System.out.println("│  2. Lihat Semua              │");
            System.out.println("│  3. Edit Kategori            │");
            System.out.println("│  4. Hapus Kategori           │");
            System.out.println("│  0. Kembali                  │");
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

        String nama = "";
        String desk = "";
        boolean valid = false;

        while (!valid) {
            System.out.print("  Nama Kategori : ");
            nama = sc.nextLine().trim();
            if (nama.isEmpty()) {
                System.out.println("  [!] Nama kategori tidak boleh kosong!");
            } else {
                valid = true;
            }
        }

        valid = false;
        while (!valid) {
            System.out.print("  Deskripsi     : ");
            desk = sc.nextLine().trim();
            if (desk.isEmpty()) {
                System.out.println("  [!] Deskripsi tidak boleh kosong!");
            } else {
                valid = true;
            }
        }

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

        System.out.println("  Data saat ini:");
        target.tampilInfo();
        System.out.print("\n  Nama baru      : ");
        String nama = sc.nextLine().trim();
        System.out.print("  Deskripsi baru : ");
        String desk = sc.nextLine().trim();

        target.setNamaKategori(nama);
        target.setDeskripsi(desk);
        System.out.println("  [✓] Kategori berhasil diperbarui!");
    }

    static void hapusKategori() {
        lihatKategori();
        if (listKategori.isEmpty()) return;
        int id = inputInt("  Masukkan ID Kategori yang dihapus: ");
        Kategori target = cariKategori(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        for (Baju b : listBaju) {
            if (b.getKategori().getIdKategori() == id) {
                System.out.println("  [!] Tidak bisa dihapus, masih dipakai baju: " + b.getNamaProduk());
                return;
            }
        }

        for (Aksesori a : listAksesori) {
            if (a.getKategori().getIdKategori() == id) {
                System.out.println("  [!] Tidak bisa dihapus, masih dipakai aksesori: " + a.getNamaProduk());
                return;
            }
        }

        listKategori.remove(target);
        System.out.println("  [✓] Kategori berhasil dihapus!");
    }

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
                default -> System.out.println("  [!] Pilihan tidak valid.");
            }
        }
    }

    static void tambahSupplier() {
        System.out.println("\n--- Tambah Supplier ---");

        String nama = "";
        String telp = "";
        String almt = "";
        boolean valid = false;

        while (!valid) {
            System.out.print("  Nama Supplier : ");
            nama = sc.nextLine().trim();
            if (nama.isEmpty()) {
                System.out.println("  [!] Nama supplier tidak boleh kosong!");
            } else {
                valid = true;
            }
        }

        valid = false;
        while (!valid) {
            System.out.print("  No. Telepon   : ");
            telp = sc.nextLine().trim();
            String telpDigits = telp.replaceAll("[^0-9]", "");
            if (telpDigits.length() < 10) {
                System.out.println("  [!] Nomor telepon harus minimal 10 digit!");
            } else {
                valid = true;
            }
        }

        valid = false;
        while (!valid) {
            System.out.print("  Alamat        : ");
            almt = sc.nextLine().trim();
            if (almt.isEmpty()) {
                System.out.println("  [!] Alamat tidak boleh kosong!");
            } else {
                valid = true;
            }
        }

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

        System.out.println("  Data saat ini:");
        target.tampilInfo();
        System.out.print("\n  Nama baru      : ");
        String nama = sc.nextLine().trim();
        System.out.print("  No. Telp baru  : ");
        String telp = sc.nextLine().trim();
        System.out.print("  Alamat baru    : ");
        String almt = sc.nextLine().trim();

        target.setNamaSupplier(nama);
        target.setNoTelepon(telp);
        target.setAlamat(almt);
        System.out.println("  [✓] Supplier berhasil diperbarui!");
    }

    static void hapusSupplier() {
        lihatSupplier();
        if (listSupplier.isEmpty()) return;
        int id = inputInt("  Masukkan ID Supplier yang dihapus: ");
        Supplier target = cariSupplier(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        for (Baju b : listBaju) {
            if (b.getSupplier().getIdSupplier() == id) {
                System.out.println("  [!] Tidak bisa dihapus, masih dipakai baju: " + b.getNamaProduk());
                return;
            }
        }

        for (Aksesori a : listAksesori) {
            if (a.getSupplier().getIdSupplier() == id) {
                System.out.println("  [!] Tidak bisa dihapus, masih dipakai aksesori: " + a.getNamaProduk());
                return;
            }
        }

        listSupplier.remove(target);
        System.out.println("  [✓] Supplier berhasil dihapus!");
    }

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
                default -> System.out.println("  [!] Pilihan tidak valid.");
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

        System.out.print("  Nama Baju : ");
        String nama  = sc.nextLine().trim();
        System.out.print("  Motif     : ");
        String motif = sc.nextLine().trim();
        System.out.print("  Ukuran    : ");
        String ukrn  = sc.nextLine().trim();
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

        System.out.println("  Data saat ini:");
        target.tampilInfo();

        System.out.print("\n  Nama baru  (Enter = skip): ");
        String nama = sc.nextLine().trim();
        System.out.print("  Motif baru (Enter = skip): ");
        String motif = sc.nextLine().trim();
        System.out.print("  Ukuran baru(Enter = skip): ");
        String ukrn = sc.nextLine().trim();
        System.out.print("  Harga baru (0 = skip)    : ");
        double harga = inputDoubleLangsung();
        System.out.print("  Stok baru  (0 = skip)    : ");
        int stok = inputIntLangsung();

        if (!nama.isEmpty())  target.setNamaProduk(nama);
        if (!motif.isEmpty()) target.setMotif(motif);
        if (!ukrn.isEmpty())  target.setUkuran(ukrn);
        if (harga > 0)        target.setHarga(harga);
        if (stok > 0)         target.setStok(stok);

        System.out.print("  Ganti Kategori? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            lihatKategori();
            int idKat = inputInt("  Pilih ID Kategori baru: ");
            Kategori kat = cariKategori(idKat);
            if (kat != null) target.setKategori(kat);
        }

        System.out.print("  Ganti Supplier? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            lihatSupplier();
            int idSup = inputInt("  Pilih ID Supplier baru: ");
            Supplier sup = cariSupplier(idSup);
            if (sup != null) target.setSupplier(sup);
        }

        System.out.println("  [✓] Data baju berhasil diperbarui!");
    }

    static void hapusBaju() {
        lihatBaju();
        if (listBaju.isEmpty()) return;
        int id = inputInt("  Masukkan ID Baju yang dihapus: ");
        Baju target = cariBaju(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.print("  Yakin hapus '" + target.getNamaProduk() + "'? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            listBaju.remove(target);
            System.out.println("  [✓] Baju berhasil dihapus!");
        } else {
            System.out.println("  (Penghapusan dibatalkan)");
        }
    }

    static void menuAksesori() {
        boolean back = false;
        while (!back) {
            System.out.println("\n┌──────────────────────────────┐");
            System.out.println("│      MENU DATA AKSESORI      │");
            System.out.println("├──────────────────────────────┤");
            System.out.println("│  1. Tambah Aksesori          │");
            System.out.println("│  2. Lihat Semua              │");
            System.out.println("│  3. Edit Aksesori            │");
            System.out.println("│  4. Hapus Aksesori           │");
            System.out.println("│  0. Kembali                  │");
            System.out.println("└──────────────────────────────┘");
            int pilihan = inputInt("Pilih: ");
            switch (pilihan) {
                case 1 -> tambahAksesori();
                case 2 -> lihatAksesori();
                case 3 -> editAksesori();
                case 4 -> hapusAksesori();
                case 0 -> back = true;
                default -> System.out.println("  [!] Pilihan tidak valid.");
            }
        }
    }

    static void tambahAksesori() {
        System.out.println("\n--- Tambah Aksesori ---");

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

        System.out.print("  Nama Aksesori : ");
        String nama  = sc.nextLine().trim();
        System.out.print("  Jenis         : ");
        String jenis = sc.nextLine().trim();
        System.out.print("  Bahan         : ");
        String bahan = sc.nextLine().trim();
        System.out.print("  Warna         : ");
        String warna = sc.nextLine().trim();
        double harga = inputDouble("  Harga (Rp)   : ");
        int    stok  = inputInt("  Stok (pcs)   : ");

        Aksesori aksesori = new Aksesori(idAksesoriCounter++, nama, jenis, bahan, warna, harga, stok, kat, sup);
        listAksesori.add(aksesori);
        System.out.println("  [✓] Aksesori berhasil ditambahkan!");
    }

    static void lihatAksesori() {
        System.out.println("\n--- Daftar Aksesori OmahKoe ---");
        if (listAksesori.isEmpty()) {
            System.out.println("  (Belum ada data aksesori)");
            return;
        }
        for (Aksesori a : listAksesori) {
            System.out.println("  ═══════════════════════════════");
            a.tampilInfo();
        }
        System.out.println("  ═══════════════════════════════");
        System.out.println("  Total: " + listAksesori.size() + " item aksesori");
    }

    static void editAksesori() {
        lihatAksesori();
        if (listAksesori.isEmpty()) return;
        int id = inputInt("  Masukkan ID Aksesori yang diedit: ");
        Aksesori target = cariAksesori(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.println("  Data saat ini:");
        target.tampilInfo();

        System.out.print("\n  Nama baru  (Enter = skip): ");
        String nama = sc.nextLine().trim();
        System.out.print("  Jenis baru (Enter = skip): ");
        String jenis = sc.nextLine().trim();
        System.out.print("  Bahan baru (Enter = skip): ");
        String bahan = sc.nextLine().trim();
        System.out.print("  Warna baru (Enter = skip): ");
        String warna = sc.nextLine().trim();
        System.out.print("  Harga baru (0 = skip)    : ");
        double harga = inputDoubleLangsung();
        System.out.print("  Stok baru  (0 = skip)    : ");
        int stok = inputIntLangsung();

        if (!nama.isEmpty())  target.setNamaProduk(nama);
        if (!jenis.isEmpty()) target.setJenis(jenis);
        if (!bahan.isEmpty()) target.setBahan(bahan);
        if (!warna.isEmpty()) target.setWarna(warna);
        if (harga > 0)        target.setHarga(harga);
        if (stok > 0)         target.setStok(stok);

        System.out.print("  Ganti Kategori? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            lihatKategori();
            int idKat = inputInt("  Pilih ID Kategori baru: ");
            Kategori kat = cariKategori(idKat);
            if (kat != null) target.setKategori(kat);
        }

        System.out.print("  Ganti Supplier? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            lihatSupplier();
            int idSup = inputInt("  Pilih ID Supplier baru: ");
            Supplier sup = cariSupplier(idSup);
            if (sup != null) target.setSupplier(sup);
        }

        System.out.println("  [✓] Data aksesori berhasil diperbarui!");
    }

    static void hapusAksesori() {
        lihatAksesori();
        if (listAksesori.isEmpty()) return;
        int id = inputInt("  Masukkan ID Aksesori yang dihapus: ");
        Aksesori target = cariAksesori(id);
        if (target == null) { System.out.println("  [!] ID tidak ditemukan."); return; }

        System.out.print("  Yakin hapus '" + target.getNamaProduk() + "'? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            listAksesori.remove(target);
            System.out.println("  [✓] Aksesori berhasil dihapus!");
        } else {
            System.out.println("  (Penghapusan dibatalkan)");
        }
    }

    static Kategori cariKategori(int id) {
        for (Kategori k : listKategori)
            if (k.getIdKategori() == id) return k;
        return null;
    }

    static Supplier cariSupplier(int id) {
        for (Supplier s : listSupplier)
            if (s.getIdSupplier() == id) return s;
        return null;
    }

    static Baju cariBaju(int id) {
        for (Baju b : listBaju)
            if (b.getIdProduk() == id) return b;
        return null;
    }

    static Aksesori cariAksesori(int id) {
        for (Aksesori a : listAksesori)
            if (a.getIdProduk() == id) return a;
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

    static String formatHarga(double harga) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#,##0",
                new java.text.DecimalFormatSymbols(new java.util.Locale("id", "ID")));
        return "Rp " + df.format((long) harga);
    }

    static void testPolymorphism() {
        System.out.println("\n  ╔════════════════════════════════════════════╗");
        System.out.println("  ║          TEST POLYMORPHISM                 ║");
        System.out.println("  ╠════════════════════════════════════════════╣");
        System.out.println("  ║  1. Test Override: tampilInfo()            ║");
        System.out.println("  ║  2. Test Override: hitungDiskon()          ║");
        System.out.println("  ║  3. Test Overload: kurangiStok()           ║");
        System.out.println("  ║  4. Test Overload: getInfo()               ║");
        System.out.println("  ║  5. Test Overload: hitungDiskon()          ║");
        System.out.println("  ║  6. Test Overload: getInfoBaju()           ║");
        System.out.println("  ║  7. Test Overload: getInfoAksesori()       ║");
        System.out.println("  ║  8. Test Abstract Class & Interface IDiskon║");
        System.out.println("  ║  0. Kembali                                ║");
        System.out.println("  ╚════════════════════════════════════════════╝");
        int pilihan = inputInt("Pilih: ");

        switch (pilihan) {
            case 1 -> testOverrideTampilInfo();
            case 2 -> testOverrideHitungDiskon();
            case 3 -> testOverloadKurangiStok();
            case 4 -> testOverloadGetInfo();
            case 5 -> testOverloadHitungDiskon();
            case 6 -> testOverloadGetInfoBaju();
            case 7 -> testOverloadGetInfoAksesori();
            case 8 -> testAbstractDanInterface();
            case 0 -> { }
            default -> System.out.println("  [!] Pilihan tidak valid.");
        }
    }

    static void testAbstractDanInterface() {
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("   TEST ABSTRACT CLASS & INTERFACE IDiskon");
        System.out.println("══════════════════════════════════════════════════");

        if (listBaju.isEmpty() && listAksesori.isEmpty()) {
            System.out.println("\n  [!] Belum ada data. Silakan tambah Baju/Aksesori terlebih dahulu.");
            return;
        }

        System.out.println("\n[2] Abstract Method — tampilInfo() :");
        if (!listBaju.isEmpty()) {
            System.out.println("\n  >>> Baju (override tampilInfo):");
            listBaju.get(0).tampilInfo();
        }
        if (!listAksesori.isEmpty()) {
            System.out.println("\n  >>> Aksesori (override tampilInfo):");
            listAksesori.get(0).tampilInfo();
        }

        System.out.println("\n[3] Interface IDiskon — hitungDiskon() :");
        if (!listBaju.isEmpty()) {
            Baju b = listBaju.get(0);
            System.out.println("  >>> [Baju] " + b.getNamaProduk() +
                    " — diskon beli 10 pcs: " + formatHarga(b.hitungDiskon(10)));
        }
        if (!listAksesori.isEmpty()) {
            Aksesori a = listAksesori.get(0);
            System.out.println("  >>> [Aksesori] " + a.getNamaProduk() +
                    " — diskon bahan '" + a.getBahan() + "': " +
                    formatHarga(a.hitungDiskon(1)));
        }

        // ── Bagian 4: Interface IDiskon — getInfoDiskon() ─────────────────────
        System.out.println("\n[4] Interface IDiskon - getInfoDiskon() :");
        if (!listBaju.isEmpty()) {
            System.out.println("  >>> [Baju]");
            System.out.println("  " + listBaju.get(0).getInfoDiskon());
        }
        if (!listAksesori.isEmpty()) {
            System.out.println("\n  >>> [Aksesori]");
            System.out.println("  " + listAksesori.get(0).getInfoDiskon());
        }

        ArrayList<IDiskon> daftarDiskon = new ArrayList<>();
        for (Baju b    : listBaju)     daftarDiskon.add(b);
        for (Aksesori a: listAksesori) daftarDiskon.add(a);

        int no = 1;
        for (IDiskon item : daftarDiskon) {
            System.out.println("  " + no++ + ". getInfoDiskon() → "
                    + item.getInfoDiskon().split("\n")[0]);
        }

    }


    static void testOverrideTampilInfo() {
        if (!listBaju.isEmpty()) {
            System.out.println(">>> BAJU (Override tampilInfo):");
            listBaju.get(0).tampilInfo();
        }

        if (!listAksesori.isEmpty()) {
            System.out.println("\n>>> AKSESORI (Override tampilInfo):");
            listAksesori.get(0).tampilInfo();
        }

        if (listBaju.isEmpty() && listAksesori.isEmpty()) {
            System.out.println("  [!] Belum ada data untuk ditest.");
        }
    }

    static void testOverrideHitungDiskon() {
        if (!listBaju.isEmpty()) {
            Baju b = listBaju.get(0);
            System.out.println(">>> BAJU: " + b.getNamaProduk());
            System.out.println("    Harga asli: " + formatHarga(b.getHarga()));
            System.out.println("    Diskon untuk 3 pcs: " + formatHarga(b.hitungDiskon(3)));
            System.out.println("    Diskon untuk 7 pcs: " + formatHarga(b.hitungDiskon(7)));
            System.out.println("    Diskon untuk 12 pcs: " + formatHarga(b.hitungDiskon(12)));
        }

        if (!listAksesori.isEmpty()) {
            Aksesori a = listAksesori.get(0);
            System.out.println("\n>>> AKSESORI: " + a.getNamaProduk());
            System.out.println("    Harga asli: " + formatHarga(a.getHarga()));
            System.out.println("    Bahan: " + a.getBahan());
            System.out.println("    Diskon untuk 1 pcs: " + formatHarga(a.hitungDiskon(1)));
        }

        if (listBaju.isEmpty() && listAksesori.isEmpty()) {
            System.out.println("  [!] Belum ada data untuk ditest.");
        }
    }

    static void testOverloadKurangiStok() {
        if (!listBaju.isEmpty()) {
            Baju b = listBaju.get(0);
            System.out.println(">>> BAJU: " + b.getNamaProduk());
            System.out.println("    Stok awal: " + b.getStok());

            System.out.println("\n  Versi 1: kurangiStok(2)");
            b.kurangiStok(2);

            System.out.println("\n  Versi 2: kurangiStok(1, \"Terjual di toko\")");
            b.kurangiStok(1, "Terjual di toko");

            System.out.println("\n  Versi 3: kurangiStok(1, \"Penjualan online\", \"2026-04-09\")");
            b.kurangiStok(1, "Penjualan online", "2026-04-09");
        } else {
            System.out.println("  [!] Belum ada data baju untuk ditest.");
        }
    }

    static void testOverloadGetInfo() {
        if (!listBaju.isEmpty()) {
            Baju b = listBaju.get(0);
            System.out.println(">>> BAJU: " + b.getNamaProduk());
            System.out.println("  Versi 1 - getInfo():");
            System.out.println("    " + b.getInfo());
            System.out.println("  Versi 2 - getInfo(true) [Detail]:");
            String info2 = "ID: " + b.getIdProduk() + " | Nama: " + b.getNamaProduk() +
                    " | Harga: " + formatHarga(b.getHarga()) + " | Stok: " + b.getStok();
            System.out.println("    " + info2);
            System.out.println("  Versi 3 - getInfo(\"kategori\"):");
            System.out.println("    " + b.getInfo("kategori"));
            System.out.println("  Versi 3 - getInfo(\"supplier\"):");
            System.out.println("    " + b.getInfo("supplier"));
        }

        if (!listAksesori.isEmpty()) {
            Aksesori a = listAksesori.get(0);
            System.out.println("\n>>> AKSESORI: " + a.getNamaProduk());
            System.out.println("  Versi 1 - getInfo():");
            System.out.println("    " + a.getInfo());
            System.out.println("  Versi 2 - getInfo(true) [Detail]:");
            String info2 = "ID: " + a.getIdProduk() + " | Nama: " + a.getNamaProduk() +
                    " | Harga: " + formatHarga(a.getHarga()) + " | Stok: " + a.getStok();
            System.out.println("    " + info2);
        }

        if (listBaju.isEmpty() && listAksesori.isEmpty()) {
            System.out.println("  [!] Belum ada data untuk ditest.");
        }
    }

    static void testOverloadHitungDiskon() {
        if (!listBaju.isEmpty()) {
            Baju b = listBaju.get(0);
            System.out.println(">>> BAJU: " + b.getNamaProduk());
            System.out.println("  Versi 1 - hitungDiskon(5):");
            System.out.println("    " + formatHarga(b.hitungDiskon(5)));
            System.out.println("  Versi 2 - hitungDiskon(5, \"member\"):");
            System.out.println("    " + formatHarga(b.hitungDiskon(5, "member")));
            System.out.println("  Versi 3 - hitungDiskon(5, \"vip\", true) [dengan promo]:");
            System.out.println("    " + formatHarga(b.hitungDiskon(5, "vip", true)));
        }

        if (!listAksesori.isEmpty()) {
            Aksesori a = listAksesori.get(0);
            System.out.println("\n>>> AKSESORI: " + a.getNamaProduk());
            System.out.println("  Versi 1 - hitungDiskon(1):");
            System.out.println("    " + formatHarga(a.hitungDiskon(1)));
            System.out.println("  Versi 2 - hitungDiskon(1, \"" + a.getWarna() + "\") [Limited]:");
            System.out.println("    " + formatHarga(a.hitungDiskon(1, a.getWarna())));
            System.out.println("  Versi 3 - hitungDiskon(1, \"" + a.getWarna() + "\", true) [Bundle]:");
            System.out.println("    " + formatHarga(a.hitungDiskon(1, a.getWarna(), true)));
        }

        if (listBaju.isEmpty() && listAksesori.isEmpty()) {
            System.out.println("  [!] Belum ada data untuk ditest.");
        }
    }

    static void testOverloadGetInfoBaju() {
        if (!listBaju.isEmpty()) {
            Baju b = listBaju.get(0);
            System.out.println(">>> BAJU: " + b.getNamaProduk());
            System.out.println("  Versi 1 - getInfoBaju():");
            String info1 = "ID: " + b.getIdProduk() + " | Nama: " + b.getNamaProduk() +
                    " | Motif: " + b.getMotif() + " | Ukuran: " + b.getUkuran() +
                    " | Harga: " + formatHarga(b.getHarga());
            System.out.println("    " + info1);
            System.out.println("  Versi 2 - getInfoBaju(\"motif\"):");
            System.out.println("    " + b.getInfoBaju("motif"));
            System.out.println("  Versi 3 - getInfoBaju(\"ukuran\"):");
            System.out.println("    " + b.getInfoBaju("ukuran"));
            System.out.println("  Versi 4 - getInfoBaju(\"harga-diskon\"):");
            String hargaDiskon = b.getNamaProduk() + " - Harga Normal: " + formatHarga(b.getHarga()) +
                    " | Diskon: " + formatHarga(b.hitungDiskon(1));
            System.out.println("    " + hargaDiskon);
        } else {
            System.out.println("  [!] Belum ada data baju untuk ditest.");
        }
    }

    static void testOverloadGetInfoAksesori() {
        if (!listAksesori.isEmpty()) {
            Aksesori a = listAksesori.get(0);
            System.out.println(">>> AKSESORI: " + a.getNamaProduk());
            System.out.println("  Versi 1 - getInfoAksesori():");
            System.out.println("    " + a.getInfoAksesori());
            System.out.println("  Versi 2 - getInfoAksesori(\"bahan\"):");
            System.out.println("    " + a.getInfoAksesori("bahan"));
            System.out.println("  Versi 2 - getInfoAksesori(\"warna\"):");
            System.out.println("    " + a.getInfoAksesori("warna"));
            System.out.println("  Versi 2 - getInfoAksesori(\"jenis\"):");
            System.out.println("    " + a.getInfoAksesori("jenis"));
            System.out.println("  Versi 2 - getInfoAksesori(\"premium\"):");
            System.out.println("    " + a.getInfoAksesori("premium"));
        } else {
            System.out.println("  [!] Belum ada data aksesori untuk ditest.");
        }
    }
}