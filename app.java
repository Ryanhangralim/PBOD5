public class app {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Obat obat = new Obat();

        obat.set_id("1");
        obat.set_nama("Paracetamol");
        obat.set_merek("Paramex");
        obat.set_produsen("Kalbe");
        obat.set_tanggalproduksi("12-12-2019");
        obat.set_harga(10000);
        obat.set_stok(100);
        obat.set_jenis("Pil");
        obat.set_tanggalkadaluwarsa("12-12-2020");
        obat.set_efeksamping("Mual, pusing");
        obat.set_dosis("3x1");

        System.out.println("ID: " + obat.get_id());
        System.out.println("Nama: " + obat.get_nama());
        System.out.println("Merek: " + obat.get_merek());
        System.out.println("Produsen: " + obat.get_produsen());
        System.out.println("Tanggal Produksi: " + obat.get_tanggalproduksi());
        System.out.println("Harga: " + obat.get_harga());
        System.out.println("Stok: " + obat.get_stok());
        System.out.println("Jenis: " + obat.get_jenis());
        System.out.println("Tanggal Kadaluwarsa: " + obat.get_tanggalkadaluwarsa());
        System.out.println("Efek Samping: " + obat.get_efeksamping());
        System.out.println("Dosis: " + obat.get_dosis());
    }
} 