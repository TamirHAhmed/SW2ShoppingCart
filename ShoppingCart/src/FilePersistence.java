//package PersistenceLayer;

import java.io.File;
import java.util.Vector;
//import ShoppingCart.IShoppingCart;
//import int;
//import File;

public class FilePersistence implements IPersistenceMechanism {

  public File file;

  public IPersistenceMechanism instance;

    //public Vector  throw;

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

  FilePersistence() {
  }

@Override
public IShoppingCart loadCart(int sessionID, int customerID) {
	// TODO Auto-generated method stub
	return null;
}

}