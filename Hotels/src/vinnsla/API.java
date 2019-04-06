package vinnsla;

import java.sql.*;
import java.util.ArrayList;

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
    
    /*Drög að getAvailableHotels, tekur núna bara við streng sem fyrirspurnin og nafn dálksins sem á að  skila og skilar ArrayList af strengjum */
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
    
    public void post(int id, String date, boolean ava, int tala) {
        try
        {
            String myUrl = "jdbc:mysql://localhost/hotelsearch";

            Connection conn = DriverManager.getConnection(myUrl, user, pass);
    

            // mysql insert statement
            String query = " insert into dates (roomID, date, avilable, bookingRef)" + " values (?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, id);
            preparedStmt.setString (2, date);
            preparedStmt.setBoolean   (3, ava);
            preparedStmt.setInt(4, tala);
            
            // execute the preparedstatement
            preparedStmt.execute();
      
            conn.close();
        }catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    //Tímabundið main fall
    public static void main(String[] args) throws SQLException {
        API api = new API();
        
    }
}
