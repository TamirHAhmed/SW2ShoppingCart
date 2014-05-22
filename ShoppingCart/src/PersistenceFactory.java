public class PersistenceFactory {

	public IPersistenceMechanism loadMechanism(String type) {
		
		if (type == null){
			return null;
		}
		
		if (type.equalsIgnoreCase("SQL")){
		
			return new SQLPersistence();
		
		} else if (type.equalsIgnoreCase("File")){
			
			return new FilePersistence();
		}
		
		return null;
	}

}