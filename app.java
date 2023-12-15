import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import models.Cart;
import models.CartItem;
import models.ManagerInventori;
import models.Obat;
import view.Inventaris;

public class app {
  public static void main(String[] args) {
    // System.out.println("Hello World!");
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

    // managerSteven.set_nama("Steven Belva");
    // managerSteven.set_nomortelepon("081339683882");
    // managerSteven.set_alamat("Jalan Mertasari Indah");
    // managerSteven.set_username("stevenbelva");
    // managerSteven.set_password("stevenbelva123");

    // managerSteven.save();

    // ManagerInventori.delete(2);

    // Tes cart
    Cart.addProduct(1, 3, 2, 10000, 101);
    Cart.addProduct(1, 1, 1, 100000, 102);

    // Print cart item
    List<CartItem> cartItemList = Cart.seeCart();
    for (CartItem cartItem : cartItemList) {
      System.out.println(cartItem.getName());
      System.out.println(cartItem.getQty());
      System.out.println(cartItem.getTotal());
    }

    // Inventaris inventaris = new Inventaris();
    // inventaris.setVisible(true);
  }
}
