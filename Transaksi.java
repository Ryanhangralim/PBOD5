public class Transaksi {
    private String nomor_transaksi;
    private String[] daftar_transaksi;
    private int total_harga;
    private String tanggal_transaksi;

    public void set_nomortransaksi(String nomor_transaksi){
        this.nomor_transaksi = nomor_transaksi;
    }
    public String get_nomortransaksi(){
        return this.nomor_transaksi;
    }

    public void set_daftartransaksi(String[] daftar_transaksi){
        this.daftar_transaksi = daftar_transaksi;
    }
    public String[] get_daftartransaksi(){
        return this.daftar_transaksi;
    }

    public void set_totalharga(int total_harga){
        this.total_harga = total_harga;
    }
    public int get_totalharga(){
        return this.total_harga;
    }

    public void set_tanggaltransaksi(String tanggal_transaksi){
        this.tanggal_transaksi = tanggal_transaksi;
    }
    public String get_tanggaltransaksi(){
        return this.tanggal_transaksi;
    }
}
