public class Produk {

    protected int idProduk;
    protected String namaProduk;
    protected double harga;
    protected int stok;
    protected Kategori kategori;
    protected Supplier supplier;

    public Produk(int idProduk, String namaProduk, double harga, int stok,
                  Kategori kategori, Supplier supplier) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
        this.supplier = supplier;
    }

    public int getIdProduk() { return idProduk; }
    public String getNamaProduk() { return namaProduk; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public Kategori getKategori() { return kategori; }
    public Supplier getSupplier() { return supplier; }

    public void setNamaProduk(String namaProduk) {
        if (namaProduk != null && !namaProduk.trim().isEmpty()) {
            this.namaProduk = namaProduk;
        }
    }

    public void setHarga(double harga) {
        if (harga > 0) { this.harga = harga; }
    }

    public void setStok(int stok) {
        if (stok >= 0) { this.stok = stok; }
    }

    public void setKategori(Kategori kategori) {
        if (kategori != null) { this.kategori = kategori; }
    }

    public void setSupplier(Supplier supplier) {
        if (supplier != null) { this.supplier = supplier; }
    }

    //override
    public void tampilInfo() {
        System.out.println("  ID Produk : " + idProduk);
        System.out.println("  Nama      : " + namaProduk);
        System.out.println("  Harga     : " + Main.formatHarga(harga));
        System.out.println("  Stok      : " + stok + " pcs");
        System.out.println("  Kategori  : " + kategori.getNamaKategori());
        System.out.println("  Supplier  : " + supplier.getNamaSupplier());
    }

    //override
    public double hitungDiskon(int jumlah) {
        return 0;
    }

    // overload hanya jumlah
    protected boolean kurangiStok(int jumlah) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Stok berhasil dikurangi. Sisa: " + stok);
            return true;
        } else {
            System.out.println("[!] Stok tidak cukup!");
            return false;
        }
    }

    // overload untuk versi 2 jumlah + alasan
    protected boolean kurangiStok(int jumlah, String alasan) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Stok berkurang " + jumlah + " pcs");
            System.out.println("    Alasan: " + alasan);
            System.out.println("    Sisa stok: " + stok);
            return true;
        } else {
            System.out.println("[!] Stok tidak cukup untuk: " + alasan);
            return false;
        }
    }


    // overload untuk kurangi stok dengan jumlah + alasan + tanggal
    protected boolean kurangiStok(int jumlah, String alasan, String tanggal) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Pengurangan stok tercatat:");
            System.out.println("    Jumlah   : " + jumlah + " pcs");
            System.out.println("    Alasan   : " + alasan);
            System.out.println("    Tanggal  : " + tanggal);
            System.out.println("    Sisa     : " + stok + " pcs");
            return true;
        } else {
            System.out.println("[!] Gagal: Stok tidak cukup!");
            System.out.println("    Diminta  : " + jumlah + " pcs");
            System.out.println("    Tersedia : " + stok + " pcs");
            return false;
        }
    }

    protected boolean cekStokCukup(int jumlah) {
        return stok >= jumlah;
    }

    // overload hanya untuk id produk + nama produk
    public String getInfo() {
        return "ID: " + idProduk + " | Nama: " + namaProduk;
    }


    // overload untuk detail produk
    public String getInfo(boolean detail) {
        if (detail) {
            return "ID: " + idProduk + " | Nama: " + namaProduk +
                    " | Harga: Rp " + String.format("%,.0f", harga) +
                    " | Stok: " + stok;
        }
        return getInfo();
    }


    // overload dengan filter berdasarkan tipe (kategori/supplier)
    public String getInfo(String tipe) {
        if (tipe.equalsIgnoreCase("kategori")) {
            return namaProduk + " (" + kategori.getNamaKategori() + ")";
        } else if (tipe.equalsIgnoreCase("supplier")) {
            return namaProduk + " dari " + supplier.getNamaSupplier();
        }
        return getInfo();
    }
}