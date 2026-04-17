public class Aksesori extends Produk {

    private String bahan;
    private String jenis;
    private String warna;

    public Aksesori(int idAksesori, String namaAksesori, String jenis, String bahan,
                    String warna, double harga, int stok, Kategori kategori, Supplier supplier) {
        super(idAksesori, namaAksesori, harga, stok, kategori, supplier);
        this.jenis = jenis;
        this.bahan = bahan;
        this.warna = warna;
    }

    @Override
    public String getTipeProduk() {
        return "Aksesori";
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

    @Override
    public String getInfoDiskon() {
        String level;
        double persen;
        if (bahan.equalsIgnoreCase("kulit") || bahan.equalsIgnoreCase("suede")) {
            level = "PREMIUM (kulit/suede)";
            persen = 0.15;
        } else if (bahan.equalsIgnoreCase("kain") || bahan.equalsIgnoreCase("katun")) {
            level = "STANDAR (kain/katun)";
            persen = 0.05;
        } else {
            level = "TANPA DISKON";
            persen = 0.0;
        }
        return "Kebijakan Diskon Aksesori [" + namaProduk + "]:\n" +
                "  - Bahan : " + bahan + " → " + level + "\n" +
                "  - Diskon bahan : " + (int)(persen * 100) + "% = " +
                Main.formatHarga(harga * persen) + "/pcs\n" +
                "  - Bonus warna LE : +20% | Bundle: +10%";
    }

    // Overload hitungDiskon
    public double hitungDiskon(int jumlah, String warnaLimitedEdition) {
        double diskon = hitungDiskon(jumlah);
        if (this.warna.equalsIgnoreCase(warnaLimitedEdition)) {
            diskon += (harga * 0.20);
            System.out.println("[!] Bonus: Warna limited edition '" + warnaLimitedEdition + "' mendapat diskon ekstra!");
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

    public String getBahan() { return bahan; }
    public String getJenis() { return jenis; }
    public String getWarna() { return warna; }

    public void setBahan(String bahan) { this.bahan = bahan; }
    public void setJenis(String jenis) { this.jenis = jenis; }
    public void setWarna(String warna) { this.warna = warna; }
}