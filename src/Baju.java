public class Baju {

    public int idBaju;
    public String namaBaju;
    public String motif;
    public String ukuran;
    public double harga;
    public int stok;
    public Kategori kategori;  // relasi ke object Kategori
    public Supplier supplier;  // relasi ke object Supplier

    Baju(int idBaju, String namaBaju, String motif, String ukuran,
         double harga, int stok, Kategori kategori, Supplier supplier) {
        this.idBaju   = idBaju;
        this.namaBaju = namaBaju;
        this.motif    = motif;
        this.ukuran   = ukuran;
        this.harga    = harga;
        this.stok     = stok;
        this.kategori = kategori;
        this.supplier = supplier;
    }

    void tampilInfo() {
        System.out.println("  ID Baju   : " + idBaju);
        System.out.println("  Nama      : " + namaBaju);
        System.out.println("  Motif     : " + motif);
        System.out.println("  Ukuran    : " + ukuran);
        System.out.printf( "  Harga     : Rp %,.0f%n", harga);
        System.out.println("  Stok      : " + stok + " pcs");
        System.out.println("  Kategori  : " + kategori.namaKategori);
        System.out.println("  Supplier  : " + supplier.namaSupplier);
    }
}

