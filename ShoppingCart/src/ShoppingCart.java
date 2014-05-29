
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
		lastAccessed = new Date();
	}


	public void updateQuantity(int cartItemId, int newQuantity) {
		
				try {
					
					//checks quantity and throws exception if quantity is <= 0
					if(newQuantity <=0){
						IlegalQuantityException ex = new IlegalQuantityException();
						ex.setMessage("invalid quanitity amount entered, 0 or less");
						throw ex;
					}
					
					for (int i = 0; i < itemsArray.size(); i++) {

						if (itemsArray.get(i).getId() == cartItemId) {
							itemsArray.get(i).setQuantity(newQuantity);
							lastAccessed = new Date();	
							return;
						}
					}
					
					//throws exception if no cart item of this ID is found
					CartItemNotFoundException ex = new CartItemNotFoundException();
					ex.setMessage("cart ID not found in list of cart items");
					throw ex;
				} catch (IlegalQuantityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CartItemNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

	public void removeItem(int cartItemId){
		
		try {
			for (int i = 0; i < itemsArray.size(); i++) {

				if (itemsArray.get(i).getId() == cartItemId) {
					itemsArray.remove(i);
					return;
				}
			}
			
			//throws exception if no cart item of this ID is found
			CartItemNotFoundException ex = new CartItemNotFoundException();
			ex.setMessage("cart ID not found in list of cart items");
			throw ex;
		} catch (CartItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public ICartItem getItem(int productId) {

			try {
				for (int i = 0; i < itemsArray.size(); i++) {

					if (itemsArray.get(i).getProductId() == productId) {
						return itemsArray.get(i);
					}
				}
				
				//throws exception if no cart item of this ID is found
				CartItemNotFoundException ex = new CartItemNotFoundException();
				ex.setMessage("cart ID not found in list of cart items");
				throw ex;
			} catch (CartItemNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
