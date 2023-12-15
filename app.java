// import java.sql.ResultSet;
// import java.time.LocalDate;

import models.Kosmetik;
import models.ManagerInventori;
import models.Obat;
import models.Supplier;
import view.Inventaris;
import view.Login;

public class app {
  public static void main(String[] args) {
    System.out.println("Hello World!");
    // Obat obat = new Obat();

    // obat.set_id(null);
    // obat.set_nama("Paracetamol");
    // obat.set_merek("Paramex");
    // obat.set_produsen("Kalbe");
    // obat.set_tanggalproduksi(LocalDate.of(2021, 6, 16));
    // obat.set_harga(10000);
    // obat.set_stok(100);
    // obat.set_jenis("Pil");
    // obat.set_tanggalkadaluwarsa(LocalDate.of(2025, 6, 16));
    // obat.set_efeksamping("Mual, pusing");
    // obat.set_dosis("3x1");

    // obat.save();

    // try {
    // ResultSet obat = Obat.getByID(3);
    // while (obat.next()) {
    // System.out.println(obat.getString("name"));
    // System.out.println(obat.getString("brand"));
    // System.out.println();
    // }
    // } catch (Exception e) {
    // System.out.println(e);
    // }

    // ManagerInventori managerSteven = new ManagerInventori();
    // ResultSet hasil = ManagerInventori.getByID(2);
    // int idPengguna;
    // try{
    //   if(hasil.next()){
    //     idPengguna = hasil.getInt("username");
    //     System.out.println(idPengguna);
    //   }
    // } catch (Exception e) {
    //   System.out.println(e);
    // }
      // String idPengguna;
      // try{
      //   if(hasil.next()){
      //     idPengguna = hasil.getString("username");
      //     System.out.println(idPengguna);
      //   }
      // } catch (Exception e) {
      //   System.out.println(e);
      // }

    // managerSteven.set_nama("Steven Belva");
    // managerSteven.set_nomortelepon("081339683882");
    // managerSteven.set_alamat("Jalan Mertasari Indah");
    // managerSteven.set_username("stevenbelva");
    // managerSteven.set_password("stevenbelva123");

    // managerSteven.save();

    // ManagerInventori.delete(2);

    // Inventaris inventaris = new Inventaris();
    // inventaris.setVisible(true);

    // Kosmetik kosmetik = new Kosmetik();
    // kosmetik.set_id(null);
    // kosmetik.set_nama("Pembesar ********");
    // kosmetik.set_merek("Pasti besar");
    // kosmetik.set_produsen("Besar");
    // kosmetik.set_tanggalproduksi(LocalDate.of(2022, 5, 19));
    // kosmetik.set_harga(192168);
    // kosmetik.set_stok(89);
    // kosmetik.set_tanggalkadaluwarsa(LocalDate.of(2025, 12, 9));
    // kosmetik.set_jeniskosmetik("Bodycare");
    // kosmetik.set_beratbersih(50);

    // kosmetik.save();

    // Supplier supplier = new Supplier();
    // supplier.set_id(null);
    // supplier.set_nama("ChawNiMaLe");
    // supplier.set_nomortelepon("08188818181818");
    // supplier.set_alamat("Jalan udayana");

    // supplier.save();
    Login login = new Login();
    login.setVisible(true);
  }
}
