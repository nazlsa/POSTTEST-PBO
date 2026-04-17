public class Baju extends Produk {

    private String motif;
    private String ukuran;

    public Baju(int idBaju, String namaBaju, String motif, String ukuran,
                double harga, int stok, Kategori kategori, Supplier supplier) {
        super(idBaju, namaBaju, harga, stok, kategori, supplier);
        this.motif = motif;
        this.ukuran = ukuran;
    }

    @Override
    public String getTipeProduk() {
        return "Pakaian/Baju";
    }

    @Override
    public void tampilInfo() {
        System.out.println("  ID Baju     : " + idProduk);
        System.out.println("  Nama        : " + namaProduk);
        System.out.println("  Motif       : " + motif);
        System.out.println("  Ukuran      : " + ukuran);
        System.out.println("  Harga       : " + Main.formatHarga(harga));
        System.out.println("  Stok        : " + stok + " pcs");
        System.out.println("  Kategori    : " + kategori.getNamaKategori());
        System.out.println("  Supplier    : " + supplier.getNamaSupplier());
    }

    @Override
    public double hitungDiskon(int jumlah) {
        if (jumlah >= 10) return harga * 0.10;
        else if (jumlah >= 5) return harga * 0.05;
        return 0;
    }

    @Override
    public String getInfoDiskon() {
        return "Kebijakan Diskon Baju [" + namaProduk + "]:\n" +
                "  - Beli 5-9 pcs  : diskon 5%  = " + Main.formatHarga(harga * 0.05) + "/pcs\n" +
                "  - Beli ≥ 10 pcs : diskon 10% = " + Main.formatHarga(harga * 0.10) + "/pcs\n" +
                "  - Tambahan member: +5% | VIP: +10%";
    }

    // Overload hitungDiskon
    public double hitungDiskon(int jumlah, String tipePelanggan) {
        double diskonBase = hitungDiskon(jumlah);
        if (tipePelanggan.equalsIgnoreCase("member")) {
            return diskonBase + (harga * 0.05);
        } else if (tipePelanggan.equalsIgnoreCase("vip")) {
            return diskonBase + (harga * 0.10);
        }
        return diskonBase;
    }

    public double hitungDiskon(int jumlah, String tipePelanggan, boolean promoMusiman) {
        double diskon = hitungDiskon(jumlah, tipePelanggan);
        if (promoMusiman) {
            diskon += (harga * 0.15);
        }
        return diskon;
    }

    public String getInfoBaju() {
        return "ID: " + idProduk + " | Nama: " + namaProduk +
                " | Motif: " + motif + " | Ukuran: " + ukuran +
                " | Harga: Rp " + String.format("%,.0f", harga);
    }

    public String getInfoBaju(String filter) {
        if (filter.equalsIgnoreCase("motif")) {
            return "Baju " + namaProduk + " dengan motif " + motif;
        } else if (filter.equalsIgnoreCase("ukuran")) {
            return "Baju " + namaProduk + " ukuran " + ukuran + " tersedia " + stok + " pcs";
        } else if (filter.equalsIgnoreCase("harga-diskon")) {
            double diskon = hitungDiskon(1);
            return namaProduk + " - Harga Normal: Rp " + String.format("%,.0f", harga) +
                    " | Diskon: Rp " + String.format("%,.0f", diskon);
        }
        return getInfoBaju();
    }

    public boolean cekKompatibilitas(String ukuranPelanggan) {
        return this.ukuran.equalsIgnoreCase(ukuranPelanggan);
    }

    public String cekKompatibilitas(String ukuranPelanggan, String tipePelanggan) {
        if (cekKompatibilitas(ukuranPelanggan)) {
            return "✓ Cocok! Baju ini tersedia ukuran " + ukuranPelanggan +
                    " dengan harga spesial untuk " + tipePelanggan;
        }
        return "✗ Maaf, baju ini tidak tersedia ukuran " + ukuranPelanggan;
    }
}