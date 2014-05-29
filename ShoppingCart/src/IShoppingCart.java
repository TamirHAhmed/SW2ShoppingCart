import java.util.ArrayList;
import java.util.Date;


//import int;

public interface IShoppingCart {

	/**
	 * gets id of this shoppingCart.
	 * 
	 * @return the id of this shoppingCart.
	 */
  public int getId();

	/**
	 * gets session id of this shoppingCart.
	 * 
	 * @return the session id of this shoppingCart.
	 */
  public int getSessionId();

	/**
	 * gets customer id of this shoppingCart.
	 * 
	 * @return the customer id of this shoppingCart.
	 */
  public int getCustomerId();

	/**
	 * Adds ICartItem to the list of ICartItems inside this shopping cart
	 * @param item   the ICartItem to be added to the list itemsArray.
	 */
  public void addItem(ICartItem item);

	/**
	 * Updates the quantity of a certain ICartItem in list itemsArray of this specified ID
	 * 
	 * @param cartItemId   the id of the item to be updated.
	 * @param newQuantity  the new amount by which quantity should be changed to.
	 * @throws CartItemNotFoundException if cart item is not found
	 * @throws IllegalQuantityException   If newQuantity is <= 0.
	 */
  public void updateQuantity(int cartItemId, int newQuantity);

	/**
	 * Removes cartItem from itemsArray if match found.
	 * 
	 * @param cartItemId   the item id of the item to be found.
	 * @throws CartItemNotFoundException if cart item is not found
	 */
  public void removeItem(int cartItemId);

	/**
	 * Returns an ICartItem object if found in itemsArray list, otherwise returns null
	 * 
	 * @param cartProductID   the product id of the item to be found.
	 * @return ICartItem object of the specified productId if found, null otherwise.
	 * @throws CartItemNotFoundException if cart item is not found
	 */
  public ICartItem getItem(int productId);

	/**
	 * Returns the current itemsArray list holding ICartItems
	 * 
	 * @return ArrayList of type ICartItem holding cartItems inside this shoppingCart.
	 */
  public ArrayList<ICartItem> getItems();

	/**
	 * Calculates the total number of cartItems.
	 * 
	 * @return the total number of cartItems inside this shoppingCart.
	 */
  public int countItems();

	/**
	 * gets the last access date of this shopping cart.
	 * 
	 * @return the date of last Access.
	 */
  public Date getLastAccessedDate();

}