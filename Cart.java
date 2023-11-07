public class Cart {
    private String produk_ID;
    private int jumlah;

    public void set_produkID(String produk_ID){
        this.produk_ID = produk_ID;
    }
    public String get_produkID(){
        return this.produk_ID;
    }

    public void set_jumlah(int jumlah){
        this.jumlah = jumlah;
    }
    public int get_jumlah(){
        return this.jumlah;
    }
}
