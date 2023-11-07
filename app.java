public class app {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pelanggan _pelanggan = new Pelanggan();

        _pelanggan.set_pelanggan("Budi", "08123456789", "Jl. Jalan No. 1");

        System.out.println(_pelanggan.getNama());
        System.out.println("Nomor Telepon: " + _pelanggan.getNomorTelepon());
        System.out.println("Alamat: " + _pelanggan.getAlamat());
    }
} 