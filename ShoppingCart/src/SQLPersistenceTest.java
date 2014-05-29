import static org.junit.Assert.*;

import org.junit.Test;


public class SQLPersistenceTest {

	@Test
	public void testCreateCart() {
		SQLPersistence sql=new SQLPersistence();
		
        int sessionId=3,customerId=5 ,shopp=6;
        
        sql.createCart(sessionId, customerId, shopp);
        
        IShoppingCart cart = new ShoppingCart(shopp, customerId, sessionId);

        assertEquals(cart,sql.createCart(sessionId, customerId, shopp));
	}

}
