//package ShoppingCart;

import java.util.Vector;
//import int;
//import double;

public interface ICartItem {

    /**
   * 
   * @element-type ShoppingCart
   */
 // public Vector  myShoppingCart;

  public int getId();

  public int getProductId();

  public int getQuantity();

  public double getUnitPrice();

  public double getTotalCost();

  public void setId(int id);

  public void setProductId(int id);

  public void setQuantity(int id);

  public void setUnitPrice(double price);

}