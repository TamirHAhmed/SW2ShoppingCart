import static org.junit.Assert.*;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ShoppingCartTest {

	public ShoppingCart cart;
	
	@Before
	public void setUp() throws Exception {
		cart = new ShoppingCart(1,1, 1);
		CartItem item  = new CartItem(2, 2, 2, 10);
		CartItem item2  = new CartItem(3, 3, 3, 13);
		cart.addItem(item);
		cart.addItem(item2);
	}

	@After
	public void tearDown() throws Exception {
		cart = null;
	}

	@Test
	public void testGetId() {
		assertEquals(1,cart.getId());	
	}

	@Test
	public void testGetSessionId() {
		assertEquals(1,cart.getSessionId());
	}

	@Test
	public void testGetCustomerId() {
		assertEquals(1,cart.getCustomerId());
	}

	@Test
	public void testAddItem() {
		ICartItem item3  = new CartItem(4, 4, 5, 15);
		cart.addItem(item3);
		assertEquals(3, cart.countItems());
	}

	@Test
	public void testUpdateQuantity() {

		cart.updateQuantity(2, 7);
		assertEquals(7, cart.getItem(2).getQuantity());
	}



	@Test
	public void testRemoveItem() {
		cart.removeItem(2);
		assertEquals(1, cart.countItems());
	}

	@Test
	public void testGetItem() {
		ICartItem item3  = new CartItem(4, 4, 5, 15);
		cart.addItem(item3);
		assertEquals(item3, cart.getItem(4));
	}

	@Test
	public void testGetItems() {
		assertEquals(cart.countItems(), cart.getItems().size());
	}

	@Test
	public void testCountItems() {
		assertEquals(cart.getItems().size(), cart.countItems());
	}

	@Test
	public void testGetLastAccessedDate() {
		
		assertEquals(new Date(), cart.getLastAccessedDate());
	}

	@Test
	public void testShoppingCart() {
		ShoppingCart shopCart = new ShoppingCart(5, 5, 5);
		assertEquals(5,shopCart.getId());
		assertEquals(5,shopCart.getSessionId());
		assertEquals(5,shopCart.getCustomerId());
	}

}
