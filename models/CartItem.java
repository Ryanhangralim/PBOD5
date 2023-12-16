package models;

public class CartItem {
  private int id;
  private String name;
  private int qty;
  private int total;

  // Constructor
  public CartItem(int id, String name, int qty, int total) {
    this.id = id;
    this.name = name;
    this.qty = qty;
    this.total = total;
  }

  // Getter
  public int getIE() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public int getQty() {
    return this.qty;
  }

  public int getTotal() {
    return this.total;
  }
}
