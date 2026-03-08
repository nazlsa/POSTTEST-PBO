public class Supplier {

    public int idSupplier;
    public String namaSupplier;
    public String noTelepon;
    public String alamat;

    Supplier(int idSupplier, String namaSupplier, String noTelepon, String alamat) {
        this.idSupplier   = idSupplier;
        this.namaSupplier = namaSupplier;
        this.noTelepon    = noTelepon;
        this.alamat       = alamat;
    }

    void tampilInfo() {
        System.out.println("  ID       : " + idSupplier);
        System.out.println("  Nama     : " + namaSupplier);
        System.out.println("  No. Telp : " + noTelepon);
        System.out.println("  Alamat   : " + alamat);
    }
}

