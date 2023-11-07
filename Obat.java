public class Obat extends Produk {
    private String jenis;
    private String tanggal_kadaluwarsa;
    private String efek_samping;
    private String dosis;

    public void set_jenis(String jenis){
        this.jenis = jenis;
    }
    public String get_jenis(){
        return this.jenis;
    }

    public void set_tanggalkadaluwarsa(String tanggal_kadaluwarsa){
        this.tanggal_kadaluwarsa = tanggal_kadaluwarsa;
    }
    public String get_tanggalkadaluwarsa(){
        return this.tanggal_kadaluwarsa;
    }

    public void set_efeksamping(String efek_samping){
        this.efek_samping = efek_samping;
    }
    public String get_efeksamping(){
        return this.efek_samping;
    }

    public void set_dosis(String dosis){
        this.dosis = dosis;
    }
    public String get_dosis(){
        return this.dosis;
    }
    
}
