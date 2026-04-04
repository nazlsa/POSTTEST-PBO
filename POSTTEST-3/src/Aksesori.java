public class Aksesori extends Produk {

    private String jenis;
    private String bahan;
    private String warna;

    public Aksesori(int idAksesori, String namaAksesori, String jenis, String bahan,
                    String warna, double harga, int stok, Kategori kategori, Supplier supplier) {
        super(idAksesori, namaAksesori, harga, stok, kategori, supplier);
        this.jenis = jenis;
        this.bahan = bahan;
        this.warna = warna;
    }

    public String getJenis() { return jenis; }
    public String getBahan() { return bahan; }
    public String getWarna() { return warna; }

    public void setJenis(String jenis) {
        if (jenis != null && !jenis.trim().isEmpty()) {
            this.jenis = jenis;
        }
    }

    public void setBahan(String bahan) {
        if (bahan != null && !bahan.trim().isEmpty()) {
            this.bahan = bahan;
        }
    }

    public void setWarna(String warna) {
        if (warna != null && !warna.trim().isEmpty()) {
            this.warna = warna;
        }
    }

    public void tampilInfo() {
        System.out.println("  ID Aksesori : " + idProduk);
        System.out.println("  Nama        : " + namaProduk);
        System.out.println("  Jenis       : " + jenis);
        System.out.println("  Bahan       : " + bahan);
        System.out.println("  Warna       : " + warna);
        System.out.printf("  Harga       : Rp %,.0f%n", harga);
        System.out.println("  Stok        : " + stok + " pcs");
        System.out.println("  Kategori    : " + kategori.getNamaKategori());
        System.out.println("  Supplier    : " + supplier.getNamaSupplier());
    }
}