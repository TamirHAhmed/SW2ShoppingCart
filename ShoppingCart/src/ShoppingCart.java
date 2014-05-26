
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart implements IShoppingCart {

	public int id;

	public int sessionId;

	public int customerId;

	public ArrayList<ICartItem> itemsArray;

	public Date lastAccessed;

	public ICartItem myICartItem;

	// public Vector throw;


	public int getId() {
		return id;
	}


	public int getSessionId() {
		return sessionId;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void addItem(ICartItem item) {
		itemsArray.add(item);
	}


	public void updateQuantity(int cartItemId, int newQuantity) {
		int index = findItemIdIndex(cartItemId);

		if (index >= 0) {
			itemsArray.get(index).setQuantity(newQuantity);
		}
	}

	/**
	 * Return index of the specified cart item id. If the item is not found, -1
	 * is returned.
	 * 
	 * @param cartItemID   the id of the item to be found.
	 * @return index of cartItem if found, -1 otherwise.
	 * @throws CartItemNotFoundException if cart item is not found
	 * @throws IllegalArgumentException   If cartItemID is < 0.
	 */
	public int findItemIdIndex(int cartItemId) {

		for (int i = 0; i < itemsArray.size(); i++) {

			if (itemsArray.get(i).getId() == cartItemId) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Return index of the specified cart product id. If the item is not found,
	 * -1 is returned.
	 * 
	 * @param cartProductID   the product id of the item to be found.
	 * @return index of cartProductId if found, -1 otherwise.
	 * @throws CartItemNotFoundException if cart item is not found
	 * @throws IllegalArgumentException   If cartProductId is < 0.
	 */
	public int findProductIdIndex(int cartProductId) {

		for (int i = 0; i < itemsArray.size(); i++) {

			if (itemsArray.get(i).getProductId() == cartProductId) {
				return i;
			}
		}

		return -1;
	}

	

	public void removeItem(int cartItemId) {
		int index = findItemIdIndex(cartItemId);

		if (index >= 0) {
			itemsArray.remove(index);
		}
	}
	
	

	public ICartItem getItem(int productId) {
		int index = findProductIdIndex(productId);

		if (index >= 0) {
			return itemsArray.get(index);
		}

		return null;
	}


	public ArrayList<ICartItem> getItems() {
		return itemsArray;
	}


	public int countItems() {
		return itemsArray.size();
	}


	public Date getLastAccessedDate() {
		return lastAccessed;
	}

	
	/**
	 * Constructor that initializes values of cartId, customerId, sessionId
	 * 
	 * @param cartId   the id of this shoppingCart.
	 * @param customerId   the id of the customer using this shoppingCart.
	 * @param sessionId   the session id in which this shoppingCart was created.
	 * @throws IllegalArgumentException   If cartId or customerId or sessionID is < 0.
	 */
	ShoppingCart(int cartId, int customerId, int sessionId) {
		this.id = cartId;
		this.customerId = customerId;
		this.sessionId = sessionId;
		itemsArray = new ArrayList<ICartItem>();
	}

}