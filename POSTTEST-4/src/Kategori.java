public class Kategori {

    private int idKategori;
    private String namaKategori;
    private String deskripsi;

    public Kategori(int idKategori, String namaKategori, String deskripsi) {
        this.idKategori   = idKategori;
        this.namaKategori = namaKategori;
        this.deskripsi    = deskripsi;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setNamaKategori(String namaKategori) {
        if (namaKategori != null && !namaKategori.trim().isEmpty()) {
            this.namaKategori = namaKategori;
        }
    }

    public void setDeskripsi(String deskripsi) {
        if (deskripsi != null && !deskripsi.trim().isEmpty()) {
            this.deskripsi = deskripsi;
        }
    }

    void tampilInfo() {
        System.out.println("  ID        : " + idKategori);
        System.out.println("  Kategori  : " + namaKategori);
        System.out.println("  Deskripsi : " + deskripsi);
    }

    protected void displayFormat() {
        System.out.println("═══════════════════════════════");
        tampilInfo();
        System.out.println("═══════════════════════════════");
    }
}

