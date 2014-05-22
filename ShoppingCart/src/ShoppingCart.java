

import java.util.Date;
import java.util.Vector;
//import int;

public class ShoppingCart implements IShoppingCart {

  public int id;

  public int sessionId;

  public int customerId;

  public ICartItem itemsArray;

  public Date lastAccessed;

    public ICartItem myICartItem;
   // public Vector  throw;

  public int getId() {
  return 0;
  }

  public int getSessionID() {
  return 0;
  }

  public int getCustomerID() {
  return 0;
  }

  public void addItem(ICartItem item) {
  }

  public void updateQuantity(int cartItemID, int newQuantity) {
  }

  public void removeItem(int cartItemId) {
  }

  public ICartItem getItem(int productID) {
  return null;
  }

  public ICartItem[] getItems() {
  return null;
  }

  public int countItems() {
  return 0;
  }

  public Date getLastAccessedDate() {
  return null;
  }

  public ShoppingCart(int cartID, int customerID, int sessionID) {
  }

}