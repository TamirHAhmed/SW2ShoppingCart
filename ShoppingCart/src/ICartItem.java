//package ShoppingCart;

import java.util.Vector;
//import int;
//import double;

public interface ICartItem {

    /**
   * 
   * @element-type ShoppingCart
   */
 // public Vector  myShoppingCart;

	/**
	 * gets id of this CartItem.
	 * 
	 * @return the id of this CartItem.
	 */
  public int getId();

	/**
	 * gets productId of this CartItem.
	 * 
	 * @return the productId of this CartItem.
	 */
  public int getProductId();

	/**
	 * gets the quantity amount of this CartItem.
	 * 
	 * @return the quantity of this CartItem.
	 */
  public int getQuantity();

	/**
	 * gets the unit price of this CartItem.
	 * 
	 * @return the the unit price of this CartItem.
	 */
  public double getUnitPrice();

	/**
	 * gets the total price of this CartItem by multiplying the unit price by quantity.
	 * 
	 * @return the total price of this CartItem.
	 */
  public double getTotalCost();

	/**
	 * sets id of this CartItem.
	 * 
	 * @param id   the id of this cartItem.
	 */
  public void setId(int id);

	/**
	 * sets productId of this CartItem.
	 * 
	 * @param productId   the productId of this cartItem.
	 */
  public void setProductId(int id);

	/**
	 * sets quantity of this CartItem.
	 * 
	 * @param quantity   the quantity of this cartItem.
	 */
  public void setQuantity(int id);

	/**
	 * sets the unit price of this CartItem.
	 * 
	 * @param price   the price of this cartItem.
	 */
  public void setUnitPrice(double price);

}