import java.util.Date;


//import int;

public interface IShoppingCart {

  public int getId();

  public int getSessionID();

  public int getCustomerID();

  public void addItem(ICartItem item);

  public void updateQuantity(int cartItemID, int newQuantity);

  public void removeItem(int cartItemId);

  public ICartItem getItem(int productID);

  public ICartItem[] getItems();

  public int countItems();

  public Date getLastAccessedDate();

}