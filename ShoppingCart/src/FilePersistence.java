//package PersistenceLayer;

import java.io.File;
import java.util.Vector;
//import ShoppingCart.IShoppingCart;
//import int;
//import File;

public class FilePersistence implements IPersistenceMechanism {

	public File file;

	public IPersistenceMechanism instance;

	// public Vector throw;
	/**
	 * Saves an object of type IShoppingCart to file
	 * 
	 * @param cart   the shopping cart to be saved.
	 * @throws FileException if there's problem connecting to file
	 */
	public void save(IShoppingCart cart) {
	}

	/**
	 * Returns an IShoppingCart object of the specified cartId from file
	 * otherwise returns null
	 * 
	 * @param cartId   the product id of the item to be found.
	 * @return IShoppingCart object of the specified cartId if found, null otherwise.
	 * @throws FileException if there's problem connecting to file
	 */
	public IShoppingCart loadCart(int cartID) {
		return null;
	}

	/**
	 * Creates IShoppingCart object from given sessionId and customerId 
	 * while getting id from file
	 * 
	 * @param sessionId   the session id of the shopping cart to be created.
	 * @param customerId   the customer id of the shopping cart to be created.
	 * @return IShoppingCart object after creation.
	 * @throws IllegalArgumentException if sessionId or customerId < 0
	 * @throws FileException if there's problem connecting to file
	 */
	public IShoppingCart createCart(int sessionID, int customerID) {
		return null;
	}

	/**
	 *Removes an object of type IShoppingCart from file by given cart information
	 * 
	 * @param cart   the shopping cart to be removed.
	 * @throws FileException if there's problem connecting to file
	 */
	public void removeCart(IShoppingCart cart) {
	}

	/**
	 *Return an instance of this object to be used in {@link:PersistenceFactory} class
	 */
	public IPersistenceMechanism getInstance() {
		return null;
	}

	/**
	 *Constructor for this class
	 */
	FilePersistence() {
	}

	/**
	 * Returns an IShoppingCart object of the specified sessionId and customerId
	 *  from database via file if found , otherwise returns null
	 * 
	 * @param sessionId   the session id of the shopping cart to be found.
	 * @param customerId  the customer id of the shopping cart to be found.
	 * @return IShoppingCart object of the specified cartId if found, null otherwise.
	 * @throws FileException if there's problem connecting to file
	 */
	@Override
	public IShoppingCart loadCart(int sessionID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}