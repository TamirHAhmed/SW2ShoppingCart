import static org.junit.Assert.*;

import org.junit.Test;

public class PersistenceFactoryTest {

	@Test
	public void testLoadMechanism() {

		PersistenceFactory factory = new PersistenceFactory();
		
		assertEquals(new SQLPersistence().getClass(), factory.loadMechanism("SQL").getClass());
		assertEquals(new FilePersistence().getClass(), factory.loadMechanism("File").getClass());
		assertEquals(null, factory.loadMechanism("other"));

	}

}
