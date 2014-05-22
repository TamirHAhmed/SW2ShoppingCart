//package PersistenceLayer;

//import ShoppingCart.IShoppingCart;
//import int;

/*
 */
public interface IPersistenceMechanism {

  public void save(IShoppingCart cart);

  public IShoppingCart loadCart(int cartID);

  public IShoppingCart createCart(int sessionID, int customerID);

  public IShoppingCart loadCart(int sessionID, int customerID);

  public void removeCart(IShoppingCart cart);

  public IPersistenceMechanism getInstance();

}