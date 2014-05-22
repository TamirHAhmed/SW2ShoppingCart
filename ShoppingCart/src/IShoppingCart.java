import java.util.ArrayList;
import java.util.Date;


//import int;

public interface IShoppingCart {

  public int getId();

  public int getSessionId();

  public int getCustomerId();

  public void addItem(ICartItem item);

  public void updateQuantity(int cartItemId, int newQuantity);

  public void removeItem(int cartItemId);

  public ICartItem getItem(int productId);

  public ArrayList<ICartItem> getItems();

  public int countItems();

  public Date getLastAccessedDate();

}