public class Supplier {

    private int idSupplier;
    private String namaSupplier;
    private String noTelepon;
    private String alamat;

    public Supplier(int idSupplier, String namaSupplier, String noTelepon, String alamat) {
        this.idSupplier   = idSupplier;
        this.namaSupplier = namaSupplier;
        this.noTelepon    = noTelepon;
        this.alamat       = alamat;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNamaSupplier() {
        return namaSupplier;
    }

    public void setNamaSupplier(String namaSupplier) {
        if (namaSupplier != null && !namaSupplier.trim().isEmpty()) {
            this.namaSupplier = namaSupplier;
        }
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        if (noTelepon != null && noTelepon.replaceAll("[^0-9]", "").length() >= 10) {
            this.noTelepon = noTelepon;
        }
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        if (alamat != null && !alamat.trim().isEmpty()) {
            this.alamat = alamat;
        }
    }

    void tampilInfo() {
        System.out.println("  ID       : " + idSupplier);
        System.out.println("  Nama     : " + namaSupplier);
        System.out.println("  No. Telp : " + noTelepon);
        System.out.println("  Alamat   : " + alamat);
    }

    protected void validasiData() {
        if (namaSupplier == null || namaSupplier.isEmpty()) {
            System.out.println("[!] Error: Nama supplier tidak boleh kosong!");
        }
    }
}
