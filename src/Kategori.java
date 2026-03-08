public class Kategori {

    public int idKategori;
    public String namaKategori;
    public String deskripsi;

    Kategori(int idKategori, String namaKategori, String deskripsi) {
        this.idKategori   = idKategori;
        this.namaKategori = namaKategori;
        this.deskripsi    = deskripsi;
    }

    void tampilInfo() {
        System.out.println("  ID        : " + idKategori);
        System.out.println("  Kategori  : " + namaKategori);
        System.out.println("  Deskripsi : " + deskripsi);
    }
}
