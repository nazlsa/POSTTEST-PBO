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

    @Override
    public void tampilInfo() {
        System.out.println("  ID Aksesori : " + idProduk);
        System.out.println("  Nama        : " + namaProduk);
        System.out.println("  Jenis       : " + jenis);
        System.out.println("  Bahan       : " + bahan);
        System.out.println("  Warna       : " + warna);
        System.out.println("  Harga       : " + Main.formatHarga(harga));
        System.out.println("  Stok        : " + stok + " pcs");
        System.out.println("  Kategori    : " + kategori.getNamaKategori());
        System.out.println("  Supplier    : " + supplier.getNamaSupplier());
    }

    @Override
    public double hitungDiskon(int jumlah) {
        if (bahan.equalsIgnoreCase("kulit") || bahan.equalsIgnoreCase("suede")) {
            return harga * 0.15;
        } else if (bahan.equalsIgnoreCase("kain") || bahan.equalsIgnoreCase("katun")) {
            return harga * 0.05;
        }
        return 0;
    }

    public double hitungDiskon(int jumlah, String warnaLimitedEdition) {
        double diskon = hitungDiskon(jumlah);
        if (this.warna.equalsIgnoreCase(warnaLimitedEdition)) {
            diskon += (harga * 0.20);
            System.out.println("[!] Bonus: Warna limited edition '" + warnaLimitedEdition +
                    "' mendapat diskon ekstra!");
        }
        return diskon;
    }

    public double hitungDiskon(int jumlah, String warnaLimitedEdition, boolean isBundle) {
        double diskon = hitungDiskon(jumlah, warnaLimitedEdition);
        if (isBundle) {
            diskon += (harga * 0.10);
        }
        return diskon;
    }

    @Override
    public String getInfo() {
        return "Aksesori | ID: " + idProduk + " | Nama: " + namaProduk +
                " | Jenis: " + jenis + " | Warna: " + warna;
    }

    public String getInfoAksesori() {
        return "ID: " + idProduk + " | " + namaProduk +
                " | Jenis: " + jenis + " | Bahan: " + bahan + " | Warna: " + warna +
                " | Harga: Rp " + String.format("%,.0f", harga);
    }

    public String getInfoAksesori(String filter) {
        if (filter.equalsIgnoreCase("bahan")) {
            return "Aksesori " + namaProduk + " terbuat dari " + bahan;
        } else if (filter.equalsIgnoreCase("warna")) {
            return "Aksesori " + namaProduk + " tersedia dalam warna " + warna;
        } else if (filter.equalsIgnoreCase("jenis")) {
            return "Jenis " + jenis + ": " + namaProduk + " (" + bahan + ") - Rp " +
                    String.format("%,.0f", harga);
        } else if (filter.equalsIgnoreCase("premium")) {
            if (bahan.equalsIgnoreCase("kulit") || bahan.equalsIgnoreCase("suede")) {
                return "★ PREMIUM ★ " + namaProduk + " dari bahan " + bahan;
            }
        }
        return getInfoAksesori();
    }

    public boolean cekKeserasian(String warnaYangDiinginkan) {
        return this.warna.equalsIgnoreCase(warnaYangDiinginkan);
    }

    public String cekKeserasian(String warnaYangDiinginkan, String jenisYangDiinginkan) {
        if (cekKeserasian(warnaYangDiinginkan) && this.jenis.equalsIgnoreCase(jenisYangDiinginkan)) {
            return "✓ Perfect! Aksesori ini cocok: " + jenis + " warna " + warna;
        } else if (cekKeserasian(warnaYangDiinginkan)) {
            return "~ Warna cocok tapi jenis berbeda: " + jenis + " (bukan " + jenisYangDiinginkan + ")";
        }
        return "✗ Aksesori ini tidak cocok dengan pilihan Anda";
    }
}