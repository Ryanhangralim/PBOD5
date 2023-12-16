package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.MySQLConn;

public class Cart {

  private static int getCartQty(int ID) {
    // Get MySQL connection
    Connection conn = MySQLConn.getConnection();
    // Query
    String sql = "SELECT total_qty FROM carts WHERE id = ?";
    // Select total_qty
    try (PreparedStatement selectCartQty = conn.prepareStatement(sql)) {
      selectCartQty.setInt(1, ID);

      ResultSet cart = selectCartQty.executeQuery();

      if (cart.next()) {
        return cart.getInt("total_qty");
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed get cart total qty" + e);
    }
    return 0;
  }

  private static int getCartPrice(int ID) {
    // Get MySQL connection
    Connection conn = MySQLConn.getConnection();
    // Query
    String sql = "SELECT total_price FROM carts WHERE id = ?";
    // Select total_price
    try (PreparedStatement selectCartQty = conn.prepareStatement(sql)) {
      selectCartQty.setInt(1, ID);

      ResultSet cart = selectCartQty.executeQuery();

      if (cart.next()) {
        return cart.getInt("total_price");
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed get cart total price" + e);
    }
    return 0;
  }

  public static void addProduct(int cartID, int productID, int qty, int price, int productCategory) {
    // Get MySQL connection
    Connection conn = MySQLConn.getConnection();
    // Query
    String sql = "INSERT INTO cart_items(cartId, productId, qty, product_code) VALUES(?, ?, ?, ?)";
    // Insert to cart items
    try (PreparedStatement insertCartItems = conn.prepareStatement(sql)) {
      insertCartItems.setInt(1, cartID);
      insertCartItems.setInt(2, productID);
      insertCartItems.setInt(3, qty);
      insertCartItems.setInt(4, productCategory);

      insertCartItems.executeUpdate();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed adding cart items" + e);
    }

    // Update cart
    int curr_qty = getCartQty(cartID);
    int curr_price = getCartPrice(cartID);

    int updated_qty = curr_qty + qty;
    int updated_price = curr_price + qty * price;

    String sql2 = "UPDATE carts SET total_qty = ?, total_price = ? WHERE id = ?";

    try (PreparedStatement updateCart = conn.prepareStatement(sql2)) {
      updateCart.setInt(1, updated_qty);
      updateCart.setInt(2, updated_price);
      updateCart.setInt(3, cartID);

      updateCart.executeUpdate();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed adding cart items" + e);
    }
  }

  public static List<CartItem> seeCart() {
    // Get MySQL connection
    Connection conn = MySQLConn.getConnection();
    // List of cart items
    List<CartItem> cartItemList = new ArrayList<>();
    // Query
    String sql1 = "SELECT m.id, m.name, SUM(qty) AS qty, m.price*SUM(qty) AS total FROM cart_items ci JOIN medicines m ON ci.productId = m.id AND ci.product_code = m.product_code WHERE cartId = ? GROUP BY m.id";
    String sql2 = "SELECT sup.id, sup.name, SUM(qty) AS qty, sup.price*SUM(qty) AS total FROM cart_items ci JOIN supplements sup ON ci.productId = sup.id AND ci.product_code = sup.product_code WHERE cartId = ? GROUP BY sup.id";
    String sql3 = "SELECT medeq.id, medeq.name, SUM(qty) AS qty, medeq.price*SUM(qty) AS total FROM cart_items ci JOIN medical_equipments medeq ON ci.productId = medeq.id AND ci.product_code = medeq.product_code WHERE cartId = ? GROUP BY medeq.id";
    String sql4 = "SELECT cos.id, cos.name, SUM(qty) AS qty, cos.price*SUM(qty) AS total FROM cart_items ci JOIN cosmetic cos ON ci.productId = cos.id AND ci.product_code = cos.product_code WHERE cartId = ? GROUP BY cos.id";
    try {
      ResultSet cartItems;

      PreparedStatement seeCartMedicine = conn.prepareStatement(sql1);
      seeCartMedicine.setInt(1, 1);
      cartItems = seeCartMedicine.executeQuery();

      while (cartItems.next()) {
        int id = cartItems.getInt("m.id");
        String name = cartItems.getString("m.name");
        int qty = cartItems.getInt("qty");
        int total = cartItems.getInt("total");

        CartItem newCartItem = new CartItem(id, name, qty, total);
        cartItemList.add(newCartItem);
      }

      PreparedStatement seeCartSupplement = conn.prepareStatement(sql2);
      seeCartSupplement.setInt(1, 1);
      cartItems = seeCartSupplement.executeQuery();

      while (cartItems.next()) {
        int id = cartItems.getInt("sup.id");
        String name = cartItems.getString("sup.name");
        int qty = cartItems.getInt("qty");
        int total = cartItems.getInt("total");

        CartItem newCartItem = new CartItem(id, name, qty, total);
        cartItemList.add(newCartItem);
      }

      PreparedStatement seeCartMedeq = conn.prepareStatement(sql3);
      seeCartMedeq.setInt(1, 1);
      cartItems = seeCartMedeq.executeQuery();

      while (cartItems.next()) {
        int id = cartItems.getInt("medeq.id");
        String name = cartItems.getString("medeq.name");
        int qty = cartItems.getInt("qty");
        int total = cartItems.getInt("total");

        CartItem newCartItem = new CartItem(id, name, qty, total);
        cartItemList.add(newCartItem);
      }

      PreparedStatement seeCartCosmetic = conn.prepareStatement(sql4);
      seeCartCosmetic.setInt(1, 1);
      cartItems = seeCartCosmetic.executeQuery();

      while (cartItems.next()) {
        int id = cartItems.getInt("cos.id");
        String name = cartItems.getString("cos.name");
        int qty = cartItems.getInt("qty");
        int total = cartItems.getInt("total");

        CartItem newCartItem = new CartItem(id, name, qty, total);
        cartItemList.add(newCartItem);
      }

    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Failed see cart" + e);
    }

    return cartItemList;
  }
}
