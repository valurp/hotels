package vinnsla;

import java.sql.*;
import java.util.ArrayList;
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
    
    /*Drög að getAvailableHotels, tekur núna bara við streng sem fyrirspurnin og nafn dálksins sem á að  skila og skilar ArrayList af strengjum*/
    public ArrayList<String> getAvailableHotels(String query, String queryResult) throws SQLException {
        ArrayList<String> resultAL = new ArrayList<String>();
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsearch", user, pass);

            statement = connection.createStatement();

            result = statement.executeQuery(query);

            while (result.next()) {
                //System.out.println(result.getString(queryResult));
                resultAL.add(result.getString(queryResult));
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
        return resultAL;
    }
    
    public void post() {
        try
        {
        // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost/test";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "user", "user");
    
            // create a sql date object so we can use it in our INSERT statement
            //Calendar calendar = Calendar.getInstance();
            //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
            String query = " insert into dates (roomID, date, avilable, bookingRef)" + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, 1);
            preparedStmt.setString (2, "19-04-01");
            preparedStmt.setBoolean   (3, true);
            preparedStmt.setInt(4, 10);
            
            // execute the preparedstatement
            preparedStmt.execute();
      
            conn.close();
        }catch (Exception e) {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) throws SQLException {
    API api = new API();
    //Dæmi um fyrirspurn
    //ArrayList<String> bla = api.getAvailableHotels("SELECT * FROM hotels", "name");
    //System.out.println(bla.get(9));
    api.post();
    System.out.println("sdfasfsda");
    }
}
