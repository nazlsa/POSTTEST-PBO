public class Baju extends Produk {

    private String motif;
    private String ukuran;

    public Baju(int idBaju, String namaBaju, String motif, String ukuran,
                double harga, int stok, Kategori kategori, Supplier supplier) {
        super(idBaju, namaBaju, harga, stok, kategori, supplier);
        this.motif = motif;
        this.ukuran = ukuran;
    }

    public String getMotif() { return motif; }
    public String getUkuran() { return ukuran; }

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

    @Override
    public void tampilInfo() {
        System.out.println("  ID Baju   : " + idProduk);
        System.out.println("  Nama      : " + namaProduk);
        System.out.println("  Motif     : " + motif);
        System.out.println("  Ukuran    : " + ukuran);
        System.out.printf("  Harga     : Rp %,.0f%n", harga);
        System.out.println("  Stok      : " + stok + " pcs");
        System.out.println("  Kategori  : " + kategori.getNamaKategori());
        System.out.println("  Supplier  : " + supplier.getNamaSupplier());
    }
}