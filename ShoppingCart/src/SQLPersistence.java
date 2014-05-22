//package PersistenceLayer;

import java.util.Vector;

import javax.sql.DataSource;
//import ShoppingCart.IShoppingCart;
//import int;

public class SQLPersistence implements IPersistenceMechanism {

  public DataSource connection;

  public IPersistenceMechanism instance;

   // public Vector  throw;

  public void save(IShoppingCart cart) {
  }

  public IShoppingCart loadCart(int cartID) {
  return null;
  }

  public IShoppingCart createCart(int sessionID, int customerID) {
  return null;
  }

  public void removeCart(IShoppingCart cart) {
  }

  public IPersistenceMechanism getInstance() {
  return null;
  }

  private SQLPersistence() {
  }

@Override
public IShoppingCart loadCart(int sessionID, int customerID) {
	// TODO Auto-generated method stub
	return null;
}

}