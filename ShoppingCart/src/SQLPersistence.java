import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.sql.DataSource;

public class SQLPersistence implements IPersistenceMechanism {

    
    private static IPersistenceMechanism instance;
    
    public DataSource connection;
    public static String host = "jdbc:mysql://127.0.0.1:3306/mysql_e";
    public static String dbName = "mysql_e";
    public static String username = "root";
    public static String password = "";
    public static Connection con = null;
    public static Statement st = null;
    public static Statement sts = null, stmt = null;
    public static ResultSet rs = null;
    public static ResultSet resul = null;
    public static PreparedStatement prep = null;
    public static int counter = 1000;
    // public Vector throw;

    /**
     * Saves an object of type IShoppingCart to database via SQL
     *
     * @param cart the shopping cart to be saved.
     * @throws SQLException if there's problem connecting to database
     */
    public void save(IShoppingCart cart) {


        try {
        	
            con = DriverManager.getConnection(host, username, password);

            prep = con.prepareStatement("INSERT INTO `mysql_e`.`shopping_cart` (`Shopping_cart_id`, `Customer_id`, `session_id`, `last_access`)  VALUES(?, ?, ?, CURRENT_DATE())");
            prep.setString(1, String.valueOf(cart.getId()));
            prep.setString(2, String.valueOf(cart.getCustomerId()));
            prep.setString(3, String.valueOf(cart.getSessionId()));


            prep.executeUpdate();

            ArrayList<ICartItem> item = new ArrayList<ICartItem>();
            item = cart.getItems();

            for(int i=0; i < item.size(); i++){
              prep = con.prepareStatement("INSERT INTO mysql_e.cartitem (`CartItem_Id`, `Product_id`, quantity_count, price, `Shopping_cart_id`) VALUES (?, ?, ?, ?, ?)");

              prep.setString(1, String.valueOf(item.get(i).getId()));
              prep.setString(2, String.valueOf(item.get(i).getProductId()));
              prep.setString(3, String.valueOf(item.get(i).getQuantity()));
              prep.setString(4, String.valueOf(item.get(i).getUnitPrice()));
              prep.setString(5, String.valueOf(cart.getId()));

              prep.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SQLPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    /**
     * Returns an IShoppingCart object of the specified cartId from database via
     * SQL otherwise returns null
     *
     * @param cartId the product id of the item to be found.
     * @return IShoppingCart object of the specified cartId if found, null
     * otherwise.
     * @throws SQLException if there's problem connecting to database
     */
    public IShoppingCart loadCart(int cartId) {
        

        int id = 0, prId = 0, quantity = 0;
        double price = 0;

        String CartId = "", quantity_ = "", id_ = "", productId_ = "", price_ = "";

        CartId += cartId;

        try {
            con = DriverManager.getConnection(host, username, password);
   
            st = con.createStatement();
            stmt = con.createStatement();
            

            String query = "select * from `mysql_e`.`shopping_cart`";
            
            
        
            rs = st.executeQuery(query);
            
            while (rs.next()) {

            	//found matching shopping cart id from database
                if (CartId.equals(rs.getString(1))) {       
                	
                	//create object of shoppingCart and initialize it
                	ShoppingCart cart = new ShoppingCart(cartId, Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)));
                	
                    PreparedStatement pstmt;

                    ResultSet rss;

                    pstmt = con.prepareStatement(
                            "select * from `mysql_e`.`cartitem` where `Shopping_cart_id`= (select `Shopping_cart_id` from `mysql_e`.`shopping_cart` where `Shopping_cart_id` = ? )");
                    // Create a PreparedStatement object    1 
                    pstmt.setString(1, rs.getString(1));      // Assign value to input parameter      2 

                    resul = pstmt.executeQuery();

                    while (resul.next()) {
                    	
                    	
                    	
                        System.out.println("CartItem_Id - " + resul.getString(1) + " Product_id -" + resul.getString(2));

                        System.out.println("quantity_count  - " + resul.getString(3) + " price -" + resul.getString(4));

                        System.out.println("Shopping_cart_id  - " + resul.getString(5));

                        id_ = (resul.getString(1));

                        productId_ = (resul.getString(2));

                        quantity_ = (resul.getString(3));

                        price_ = (resul.getString(4));
                        
                        //add cart item from database to list of cart items
                        cart.addItem(new CartItem(Integer.parseInt(id_), Integer.parseInt(productId_), 
                        		Integer.parseInt(quantity_), Double.parseDouble(price_)));
                    }
                    
                    //return cart
                    return cart;
                }                                                    
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }


        //in case nothing is found
        return null;
      
    }

    /**
     * Creates IShoppingCart object from given sessionId and customerId while
     * getting id from SQL
     *
     * @param sessionId the session id of the shopping cart to be created.
     * @param customerId the customer id of the shopping cart to be created.
     * @return IShoppingCart object after creation.
     * @throws IllegalArgumentException if sessionId or customerId < 0
     * @throws SQLException if there's problem connecting to database
     */
    public IShoppingCart createCart(int sessionId, int customerId, int shopp) {

        if (sessionId < 0 || customerId < 0) {
            throw new IllegalArgumentException("invalid input ID entered, 0 or less");
        }
        
        IShoppingCart cart = new ShoppingCart(shopp, customerId, sessionId);
        
        try {
            con = DriverManager.getConnection(host, username, password);

            prep = con.prepareStatement("INSERT INTO mysql_e.shopping_cart (`Shopping_cart_id`, `Customer_id`, session_id, total_price, last_access, total_item_number) VALUES (?, ?, ?, 1, '2014-05-13', ?)");

            prep.setString(1, String.valueOf(cart.getId()));

            prep.setString(2, String.valueOf(cart.getCustomerId()));

            prep.setString(3, String.valueOf(cart.getSessionId()));

            prep.setString(4, String.valueOf(0));

            prep.executeUpdate();

            prep = con.prepareStatement("INSERT INTO mysql_e.cartitem (`CartItem_Id`, `Product_id`, quantity_count, price, `Shopping_cart_id`) VALUES (?, 1,1, 1, 1)");

            prep.setString(1, String.valueOf(cart.getId()));

            prep.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(SQLPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }

       

        return cart;
    }

    /**
     * Removes an object of type IShoppingCart from database via SQL by given
     * cart information
     *
     * @param cart the shopping cart to be removed.
     * @throws SQLException if there's problem connecting to database
     */
    public void removeCart(IShoppingCart cart) {

        try {
            con = DriverManager.getConnection(host, username, password);

            st = con.createStatement();

        String query = "select * from `mysql_e`.`shopping_cart`";


            System.out.println("-----");
            rs = st.executeQuery(query);

            while (rs.next()) {


                if (String.valueOf(cart.getId()).equals(rs.getString(1))) {

                    PreparedStatement pstmt;
                    ResultSet rss;
                    pstmt = con.prepareStatement(
                            "select * from `mysql_e`.`cartitem` where `Shopping_cart_id`= (select `Shopping_cart_id` from `mysql_e`.`shopping_cart` where `Shopping_cart_id` = ? )");
                    // Create a PreparedStatement object    1                     
                    
                    pstmt.setString(1, rs.getString(1));      // Assign value to input parameter      2                    
                    
                    String sql1 = "DELETE FROM `cartitem` "
                            + " WHERE Shopping_cart_id = ? ";            
                    
                    PreparedStatement preparedStmt = con.prepareStatement(sql1);
                                        
                    resul = pstmt.executeQuery();
                    
                    preparedStmt.setString(1, rs.getString(1));

                    preparedStmt.execute();

                    String sql = "DELETE FROM `shopping_cart` "
                            + " WHERE Shopping_cart_id = ? ";

                    preparedStmt = con.prepareStatement(sql);
                    preparedStmt.setInt(1, cart.getId());

                    preparedStmt.execute();
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Return an instance of this object to be used in
     * {@link:PersistenceFactory} class
     */
    public static IPersistenceMechanism getInstance() {

    	 if(instance == null) {
             instance = new SQLPersistence();
          }
          return instance;
    }

    /**
     * Constructor for this class
     */
    SQLPersistence() {
    }

    /**
     * Returns an IShoppingCart object of the specified sessionId and customerId
     * from database via SQL if found , otherwise returns null
     *
     * @param sessionId the session id of the shopping cart to be found.
     * @param customerId the customer id of the shopping cart to be found.
     * @return IShoppingCart object of the specified cartId if found, null
     * otherwise.
     * @throws SQLException if there's problem connecting to database
     */
    @Override
    public IShoppingCart loadCart(int sessionID, int customerID) {

        int id = 0, productId = 0, quantity = 0;
        double price = 0;

        String CartId = "", quantity_ = "", id_ = "", productId_ = "", price_ = "";

        String SessionID = "", CustomerID = "";
        SessionID += sessionID;
        CustomerID += customerID;
                
        try {
            con = DriverManager.getConnection(host, username, password);

            st = con.createStatement();

        String query = "select * from `mysql_e`.`shopping_cart`";

            rs = st.executeQuery(query);
            
            while (rs.next()) {
                
                if (SessionID.equals(rs.getString(3)) && CustomerID.equals(rs.getString(2))) {
                	
                	//create object of shoppingCart and initialize it
                	ShoppingCart cart = new ShoppingCart(Integer.parseInt(rs.getString(1)), sessionID, customerID);
                	
                     
                    PreparedStatement pstmt;
                    ResultSet rss;
                    pstmt = con.prepareStatement(
                            "select * from `mysql_e`.`cartitem` where `Shopping_cart_id`= (select `Shopping_cart_id` from `mysql_e`.`shopping_cart` where `Shopping_cart_id` = ? )");
                    // Create a PreparedStatement object    1 
                    pstmt.setString(1, rs.getString(1));      // Assign value to input parameter      2                                           
                    
                    resul = pstmt.executeQuery();
                   
                    if(resul.equals("")){
                        System.out.println("not there is in");
                    }
                    
                    while (resul.next()) {
                        
                        System.out.println("CartItem_Id - " + resul.getString(1) + " Product_id -" + resul.getString(2));

                        System.out.println("quantity_count  - " + resul.getString(3) + " price -" + resul.getString(4));

                        System.out.println("Shopping_cart_id  - " + resul.getString(5));

                        id_ = (resul.getString(1));

                        productId_ = (resul.getString(2));

                        quantity_ = (resul.getString(3));

                        price_ = (resul.getString(4));
                        
                        //add cart item from database to list of cart items
                        cart.addItem(new CartItem(Integer.parseInt(id_), Integer.parseInt(productId_), 
                        		Integer.parseInt(quantity_), Double.parseDouble(price_)));
                    }
                    
                    //return cart
                    return cart;
                }                
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }

        //not found
        return null;
    }

	@Override
	public IShoppingCart createCart(int sessionID, int customerID) {
		// TODO Auto-generated method stub
		return null;
	}
}