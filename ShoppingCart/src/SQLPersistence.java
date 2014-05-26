//package PersistenceLayer;

import java.util.Vector;

import javax.sql.DataSource;

public class SQLPersistence implements IPersistenceMechanism {

	public DataSource connection;

	public IPersistenceMechanism instance;

	// public Vector throw;
	
	/**
	 * Saves an object of type IShoppingCart to database via SQL
	 * 
	 * @param cart   the shopping cart to be saved.
	 * @throws SQLException if there's problem connecting to database
	 */
	public void save(IShoppingCart cart) {
	}

	/**
	 * Returns an IShoppingCart object of the specified cartId from database via SQL
	 * otherwise returns null
	 * 
	 * @param cartId   the product id of the item to be found.
	 * @return IShoppingCart object of the specified cartId if found, null otherwise.
	 * @throws SQLException if there's problem connecting to database
	 */
	public IShoppingCart loadCart(int cartId) {
		return null;
	}

	/**
	 * Creates IShoppingCart object from given sessionId and customerId 
	 * while getting id from SQL
	 * 
	 * @param sessionId   the session id of the shopping cart to be created.
	 * @param customerId   the customer id of the shopping cart to be created.
	 * @return IShoppingCart object after creation.
	 * @throws IllegalArgumentException if sessionId or customerId < 0
	 * @throws SQLException if there's problem connecting to database
	 */
	public IShoppingCart createCart(int sessionId, int customerId) {
		return null;
	}

	/**
	 *Removes an object of type IShoppingCart from database via SQL by given cart information
	 * 
	 * @param cart   the shopping cart to be removed.
	 * @throws SQLException if there's problem connecting to database
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
	SQLPersistence() {
	}

	/**
	 * Returns an IShoppingCart object of the specified sessionId and customerId
	 *  from database via SQL if found , otherwise returns null
	 * 
	 * @param sessionId   the session id of the shopping cart to be found.
	 * @param customerId  the customer id of the shopping cart to be found.
	 * @return IShoppingCart object of the specified cartId if found, null otherwise.
	 * @throws SQLException if there's problem connecting to database
	 */
	@Override
	public IShoppingCart loadCart(int sessionID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}