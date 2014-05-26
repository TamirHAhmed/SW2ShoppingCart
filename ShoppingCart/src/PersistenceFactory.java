public class PersistenceFactory {

	
	/**
	 * Chooses type of loading mechanism based on paramater type and returns
	 * the correct object type to be used
	 * 
	 * @param type   string containing the type to be used in loading mechanism.
	 * @return IPersistenceMechanism of subclass used in loading mechanism otherwise 
	 * returns null.
	 */
	public IPersistenceMechanism loadMechanism(String type) {
		
		if (type == null){
			return null;
		}
		
		if (type.equalsIgnoreCase("SQL")){
		
			return (new SQLPersistence());
		
		} else if (type.equalsIgnoreCase("File")){
			
			return new FilePersistence();
		}
		
		return null;
	}

}