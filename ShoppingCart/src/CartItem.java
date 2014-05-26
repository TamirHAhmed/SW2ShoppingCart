public class CartItem implements ICartItem {

	public int id;

	public int productId;

	public int quantity;

	public double price;


	public int getId() {
		return id;
	}


	public int getProductId() {
		return productId;
	}


	public int getQuantity() {
		return quantity;
	}


	public double getUnitPrice() {
		return price;
	}


	public double getTotalCost() {
		return (price*quantity);
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setUnitPrice(double price) {
		this.price = price;
	}

	
	/**
	 * Constructor that initializes values of id, productId, quantity, price
	 * 
	 * @param id   the id of this CartItem.
	 * @param productId   the productId of this item.
	 * @param quantity    the quantity of item.
	 * @param price       the unit price of this item.
	 * @throws IllegalArgumentException   If id or productId or price is < 0.
	 * @throws IllegalQuantityException   If quantity is <= 0.
	 */
	CartItem(int id, int productId, int quantity, double price) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

}