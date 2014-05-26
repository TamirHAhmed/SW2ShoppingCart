import static org.junit.Assert.*;

import org.junit.Test;

public class PersistenceFactoryTest {

	@Test
	public void testLoadMechanism() {

		PersistenceFactory obj = new PersistenceFactory();
		SQLPersistence obj1 = new SQLPersistence();
		
		assertEquals(obj1, obj.loadMechanism("SQL"));

	}

}
