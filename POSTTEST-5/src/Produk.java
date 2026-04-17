public abstract class Produk implements IDiskon {

    protected int idProduk;
    protected String namaProduk;
    protected double harga;
    protected int stok;
    protected Kategori kategori;
    protected Supplier supplier;

    protected String motif;
    protected String ukuran;

    public Produk(int idProduk, String namaProduk, double harga, int stok,
                  Kategori kategori, Supplier supplier) {
        this.idProduk = idProduk;
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
        this.supplier = supplier;
        this.motif = "";
        this.ukuran = "";
    }

    public Produk(int idProduk, String namaProduk, double harga, int stok,
                  Kategori kategori, Supplier supplier, String motif, String ukuran) {
        this(idProduk, namaProduk, harga, stok, kategori, supplier);
        this.motif = motif != null ? motif : "";
        this.ukuran = ukuran != null ? ukuran : "";
    }

    public abstract String getTipeProduk();
    public abstract void tampilInfo();

    @Override
    public abstract double hitungDiskon(int jumlah);
    @Override
    public abstract String getInfoDiskon();

    public void setMotif(String motif) {
        this.motif = motif != null ? motif : "";
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran != null ? ukuran : "";
    }

    public String getMotif() {
        return motif;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setNamaProduk(String namaProduk) {
        if (namaProduk != null && !namaProduk.trim().isEmpty()) {
            this.namaProduk = namaProduk;
        }
    }

    public void setHarga(double harga) {
        if (harga > 0) this.harga = harga;
    }

    public void setStok(int stok) {
        if (stok >= 0) this.stok = stok;
    }

    public void setKategori(Kategori kategori) {
        if (kategori != null) this.kategori = kategori;
    }

    public void setSupplier(Supplier supplier) {
        if (supplier != null) this.supplier = supplier;
    }

    public int getIdProduk() { return idProduk; }
    public String getNamaProduk() { return namaProduk; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public Kategori getKategori() { return kategori; }
    public Supplier getSupplier() { return supplier; }

    public String getInfo() {
        return "ID: " + idProduk + " | Nama: " + namaProduk;
    }

    public String getInfo(boolean detail) {
        if (detail) {
            return "ID: " + idProduk + " | Nama: " + namaProduk +
                    " | Harga: Rp " + formatHarga() +
                    " | Stok: " + stok;
        }
        return getInfo();
    }

    protected String formatHarga() {
        return String.format("Rp %, .2f", harga);
    }

    public String getInfo(String tipe) {
        if (tipe.equalsIgnoreCase("kategori")) {
            return namaProduk + " (" + kategori.getNamaKategori() + ")";
        } else if (tipe.equalsIgnoreCase("supplier")) {
            return namaProduk + " dari " + supplier.getNamaSupplier();
        }
        return getInfo();
    }

    protected boolean kurangiStok(int jumlah) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Stok berhasil dikurangi. Sisa: " + stok);
            return true;
        }
        System.out.println("[!] Stok tidak cukup!");
        return false;
    }

    protected boolean kurangiStok(int jumlah, String alasan) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Stok berkurang " + jumlah + " pcs | Alasan: " + alasan);
            System.out.println("    Sisa stok: " + stok);
            return true;
        }
        System.out.println("[!] Stok tidak cukup untuk: " + alasan);
        return false;
    }

    protected boolean kurangiStok(int jumlah, String alasan, String tanggal) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Pengurangan stok tercatat:");
            System.out.println("    Jumlah   : " + jumlah + " pcs");
            System.out.println("    Alasan   : " + alasan);
            System.out.println("    Tanggal  : " + tanggal);
            System.out.println("    Sisa     : " + stok + " pcs");
            return true;
        }
        System.out.println("[!] Gagal: Stok tidak cukup!");
        return false;
    }

    protected boolean cekStokCukup(int jumlah) {
        return stok >= jumlah;
    }
}