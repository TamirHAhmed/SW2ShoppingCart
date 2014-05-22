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

	public void setProductId(int id) {
		this.productId = id;
	}

	public void setQuantity(int id) {
		this.quantity = id;
	}

	public void setUnitPrice(double price) {
		this.price = price;
	}

	CartItem(int id, int productId, int quantity, double price) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

}