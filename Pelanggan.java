public class Pelanggan {
    private String _nama;
    private String nomor_telepon;
    private String alamat;

    public void set_pelanggan(String nama, String nomor_telepon, String alamat) {
        this._nama = nama;
        this.nomor_telepon = nomor_telepon;
        this.alamat = alamat;
    }

    public String getNama() {
        String nama = "Nama anda adalah: " + this._nama;
        return nama;
    }

    public String getNomorTelepon() {
        return this.nomor_telepon;
    }

    public String getAlamat() {
        return this.alamat;
    }
}
