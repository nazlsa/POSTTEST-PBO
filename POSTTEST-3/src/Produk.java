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

    public void tampilInfo() {
        System.out.println("  ID Produk : " + idProduk);
        System.out.println("  Nama      : " + namaProduk);
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