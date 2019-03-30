package vinnsla;

import java.sql.*;
/**
 *
 * @author thorgeir93
 */
public class API {
    
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    private String user;
    private String pass;
    
    public API() {
        connection = null;
        statement = null;
        result = null;

        user = "user";
        pass = "user";
    }
    
    /*Drög að getAvailableHotels, tekur núna bara við streng sem fyrirspurnin og nafn dálksins sem á að  prenta og prentar svo út í output*/
    public void getAvailableHotels(String query, String queryResult) throws SQLException {
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsearch", user, pass);

            statement = connection.createStatement();

            result = statement.executeQuery(query);

            while (result.next()) {
                System.out.println(result.getString(queryResult));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (result != null) {
                result.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
    
    //tímabundið main fall hér, bara til að prófa
    public static void main(String[] args) throws SQLException {
        API api = new API();
        //Dæmi um fyrirspurn
        api.getAvailableHotels("SELECT * FROM hotels", "name");
        
    }    
}
