public class Baju {

    private int idBaju;
    private String namaBaju;
    private String motif;
    private String ukuran;
    private double harga;
    private int stok;
    private Kategori kategori;
    private Supplier supplier;

    public Baju(int idBaju, String namaBaju, String motif, String ukuran,
                double harga, int stok, Kategori kategori, Supplier supplier) {
        this.idBaju = idBaju;
        this.namaBaju = namaBaju;
        this.motif = motif;
        this.ukuran = ukuran;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
        this.supplier = supplier;
    }

    public int getIdBaju() {
        return idBaju;
    }

    public String getNamaBaju() {
        return namaBaju;
    }

    public String getMotif() {
        return motif;
    }

    public String getUkuran() {
        return ukuran;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setNamaBaju(String namaBaju) {
        if (namaBaju != null && !namaBaju.trim().isEmpty()) {
            this.namaBaju = namaBaju;
        }
    }

    public void setMotif(String motif) {
        if (motif != null && !motif.trim().isEmpty()) {
            this.motif = motif;
        }
    }

    public void setUkuran(String ukuran) {
        if (ukuran != null && !ukuran.trim().isEmpty()) {
            this.ukuran = ukuran;
        }
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        }
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

    public void setKategori(Kategori kategori) {
        if (kategori != null) {
            this.kategori = kategori;
        }
    }

    public void setSupplier(Supplier supplier) {
        if (supplier != null) {
            this.supplier = supplier;
        }
    }

    void tampilInfo() {
        System.out.println("  ID Baju   : " + idBaju);
        System.out.println("  Nama      : " + namaBaju);
        System.out.println("  Motif     : " + motif);
        System.out.println("  Ukuran    : " + ukuran);
        System.out.printf("  Harga     : Rp %,.0f%n", harga);
        System.out.println("  Stok      : " + stok + " pcs");
        System.out.println("  Kategori  : " + kategori.getNamaKategori());
        System.out.println("  Supplier  : " + supplier.getNamaSupplier());
    }

    protected boolean cekStokCukup(int jumlah) {
        return stok >= jumlah;
    }

    protected void kurangiStok(int jumlah) {
        if (cekStokCukup(jumlah)) {
            stok -= jumlah;
            System.out.println("[✓] Stok berhasil dikurangi. Sisa: " + stok);
        } else {
            System.out.println("[!] Stok tidak cukup!");
        }
    }
}