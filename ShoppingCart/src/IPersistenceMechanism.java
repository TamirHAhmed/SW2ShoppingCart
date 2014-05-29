//package PersistenceLayer;

//import ShoppingCart.IShoppingCart;
//import int;

/*
 */
public interface IPersistenceMechanism {

	/**
	 * Saves an object of type IShoppingCart
	 * 
	 * @param cart   the shopping cart to be saved.
	 */
  public void save(IShoppingCart cart);

	/**
	 * Returns an IShoppingCart object of the specified cartId, otherwise returns null
	 * 
	 * @param cartId   the product id of the item to be found.
	 * @return IShoppingCart object of the specified cartId if found, null otherwise.
	 */
  public IShoppingCart loadCart(int cartID);

	/**
	 * Creates IShoppingCart object from given sessionId and customerId 
	 * 
	 * @param sessionId   the session id of the shopping cart to be created.
	 * @param customerId   the customer id of the shopping cart to be created.
	 * @return IShoppingCart object after creation.
	 * @throws IllegalArgumentException if sessionId or customerId < 0
	 */
  public IShoppingCart createCart(int sessionID, int customerID);

	/**
	 * Returns an IShoppingCart object of the specified sessionId and customerId
	 * if found , otherwise returns null
	 * 
	 * @param sessionId   the session id of the shopping cart to be found.
	 * @param customerId  the customer id of the shopping cart to be found.
	 * @return IShoppingCart object of the specified cartId if found, null otherwise.
	 */
  public IShoppingCart loadCart(int sessionID, int customerID);

	/**
	 *Removes an object of type IShoppingCart by given cart information
	 * 
	 * @param cart   the shopping cart to be removed.
	 */
  public void removeCart(IShoppingCart cart);

	/**
	 *Return an instance of this object to be used in {@link:PersistenceFactory} class
	 */
 // public IPersistenceMechanism getInstance();

}