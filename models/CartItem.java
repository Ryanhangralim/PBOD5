package models;

public class CartItem {
  private String name;
  private int qty;
  private int total;

  // Constructor
  public CartItem(String name, int qty, int total) {
    this.name = name;
    this.qty = qty;
    this.total = total;
  }

  // Getter
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
