public class app {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pelanggan _pelanggan = new Pelanggan();

        _pelanggan.setNama("Rizky Khapidsyah");
        _pelanggan.setNomorTelepon("081234567890");
        _pelanggan.setAlamat("Jl. Raya Bogor KM. 30");

        System.out.println(_pelanggan.getNama());
        System.out.println("Nomor Telepon: " + _pelanggan.getNomorTelepon());
        System.out.println("Alamat: " + _pelanggan.getAlamat());
    }
} 