public class Kosmetik extends Produk {
    private String jenis_kosmetik;
    private String tanggal_kadaluwarsa;
    private int berat_bersih;

    public void set_kosmetik(String jenis_kosmetik, String tanggal_kadaluwarsa, int berat_bersih){
        this.jenis_kosmetik = jenis_kosmetik;
        this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
        this.berat_bersih = berat_bersih;
    }

    public String get_jeniskosmetik(){
        return this.jenis_kosmetik;
    }

    public String get_tanggalkadaluwarsa(){
        return this.tanggal_kadaluwarsa;
    }

    public int get_beratbersih(){
        return this.berat_bersih;
    }
}
