public class Alat_kesehatan extends Produk{
    private String jenis_alat;
    private int berat;

    public void set_jenisalat(String jenis_alat){
        this.jenis_alat = jenis_alat;
    }
    public String get_jenisalat(){
        return this.jenis_alat;
    }

    public void set_berat(int berat){
        this.berat = berat;
    }
    public int get_berat(){
        return this.berat;
    }
}
