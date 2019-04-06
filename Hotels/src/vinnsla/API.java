package vinnsla;

import java.sql.*;
import java.util.ArrayList;
/**
 * 
 * INSERT INTO dates (roomID, date, avilable, bookingRef)
VALUES
(1,"19-04-01",1,null);
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
    
    public void post(int id, String date, boolean ava, int tala) {
        try
        {
        // create a mysql database connection
            //String myDriver = "com.mysql.jdbc.driver ";
            String myUrl = "jdbc:mysql://localhost/hotelsearch";
            //Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, user, pass);
    
            // create a sql date object so we can use it in our INSERT statement
            //Calendar calendar = Calendar.getInstance();
            //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            // the mysql insert statement
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
    
    public static void main(String[] args) throws SQLException {
        API api = new API();
        //Dæmi um fyrirspurn
        //ArrayList<String> bla = api.getAvailableHotels("SELECT * FROM hotels", "name");
        //System.out.println(bla.get(9));
        //api.post(10,"19-03-05", true, 0);
        System.out.println("hoshsadfasfdsfdao");
        for (int i = 419; i <= 494; i++) {
            api.post(i, "19-04-01", true, 0);
            api.post(i, "19-04-02", true, 0);
            api.post(i, "19-04-03", true, 0);
            api.post(i, "19-04-04", true, 0);
            api.post(i, "19-04-05", true, 0);
            api.post(i, "19-04-06", true, 0);
            api.post(i, "19-04-07", true, 0);
            api.post(i, "19-04-08", true, 0);
            api.post(i, "19-04-09", true, 0);
            api.post(i, "19-04-10", true, 0);
            api.post(i, "19-04-11", true, 0);
            api.post(i, "19-04-12", true, 0);
            api.post(i, "19-04-13", true, 0);
            api.post(i, "19-04-14", true, 0);
            api.post(i, "19-04-15", true, 0);
            api.post(i, "19-04-16", true, 0);
            api.post(i, "19-04-17", true, 0);
            api.post(i, "19-04-18", true, 0);
            api.post(i, "19-04-19", true, 0);
            api.post(i, "19-04-20", true, 0);
            api.post(i, "19-04-21", true, 0);
            api.post(i, "19-04-22", true, 0);
            api.post(i, "19-04-23", true, 0);
            api.post(i, "19-04-24", true, 0);
            api.post(i, "19-04-25", true, 0);
            api.post(i, "19-04-26", true, 0);
            api.post(i, "19-04-27", true, 0);
            api.post(i, "19-04-28", true, 0);
            api.post(i, "19-04-29", true, 0);
            api.post(i, "19-04-30", true, 0);
            api.post(i, "19-05-01", true, 0);
            api.post(i, "19-05-02", true, 0);
            api.post(i, "19-05-03", true, 0);
            api.post(i, "19-05-04", true, 0);
            api.post(i, "19-05-05", true, 0);
            api.post(i, "19-05-06", true, 0);
            api.post(i, "19-05-07", true, 0);
            api.post(i, "19-05-08", true, 0);
            api.post(i, "19-05-09", true, 0);
            api.post(i, "19-05-10", true, 0);
            api.post(i, "19-05-11", true, 0);
            api.post(i, "19-05-12", true, 0);
            api.post(i, "19-05-13", true, 0);
            api.post(i, "19-05-14", true, 0);
            api.post(i, "19-05-15", true, 0);
            api.post(i, "19-05-16", true, 0);
            api.post(i, "19-05-17", true, 0);
            api.post(i, "19-05-18", true, 0);
            api.post(i, "19-05-19", true, 0);
            api.post(i, "19-05-20", true, 0);
            api.post(i, "19-05-21", true, 0);
            api.post(i, "19-05-22", true, 0);
            api.post(i, "19-05-23", true, 0);
            api.post(i, "19-05-24", true, 0);
            api.post(i, "19-05-25", true, 0);
            api.post(i, "19-05-26", true, 0);
            api.post(i, "19-05-27", true, 0);
            api.post(i, "19-05-28", true, 0);
            api.post(i, "19-05-29", true, 0);
            api.post(i, "19-05-30", true, 0);
            api.post(i, "19-05-31", true, 0);
            api.post(i, "19-06-01", true, 0);
            api.post(i, "19-06-02", true, 0);
            api.post(i, "19-06-03", true, 0);
            api.post(i, "19-06-04", true, 0);
            api.post(i, "19-06-05", true, 0);
            api.post(i, "19-06-06", true, 0);
            api.post(i, "19-06-07", true, 0);
            api.post(i, "19-06-08", true, 0);
            api.post(i, "19-06-09", true, 0);
            api.post(i, "19-06-10", true, 0);
            api.post(i, "19-06-11", true, 0);
            api.post(i, "19-06-12", true, 0);
            api.post(i, "19-06-13", true, 0);
            api.post(i, "19-06-14", true, 0);
            api.post(i, "19-06-15", true, 0);
            api.post(i, "19-06-16", true, 0);
            api.post(i, "19-06-17", true, 0);
            api.post(i, "19-06-18", true, 0);
            api.post(i, "19-06-19", true, 0);
            api.post(i, "19-06-20", true, 0);
            api.post(i, "19-06-21", true, 0);
            api.post(i, "19-06-22", true, 0);
            api.post(i, "19-06-23", true, 0);
            api.post(i, "19-06-24", true, 0);
            api.post(i, "19-06-25", true, 0);
            api.post(i, "19-06-26", true, 0);
            api.post(i, "19-06-27", true, 0);
            api.post(i, "19-06-28", true, 0);
            api.post(i, "19-06-29", true, 0);
            api.post(i, "19-06-30", true, 0);
            api.post(i, "19-07-01", true, 0);
            api.post(i, "19-07-02", true, 0);
            api.post(i, "19-07-03", true, 0);
            api.post(i, "19-07-04", true, 0);
            api.post(i, "19-07-05", true, 0);
            api.post(i, "19-07-06", true, 0);
            api.post(i, "19-07-07", true, 0);
            api.post(i, "19-07-08", true, 0);
            api.post(i, "19-07-09", true, 0);
            api.post(i, "19-07-10", true, 0);
            api.post(i, "19-07-11", true, 0);
            api.post(i, "19-07-12", true, 0);
            api.post(i, "19-07-13", true, 0);
            api.post(i, "19-07-14", true, 0);
            api.post(i, "19-07-15", true, 0);
            api.post(i, "19-07-16", true, 0);
            api.post(i, "19-07-17", true, 0);
            api.post(i, "19-07-18", true, 0);
            api.post(i, "19-07-19", true, 0);
            api.post(i, "19-07-20", true, 0);
            api.post(i, "19-07-21", true, 0);
            api.post(i, "19-07-22", true, 0);
            api.post(i, "19-07-23", true, 0);
            api.post(i, "19-07-24", true, 0);
            api.post(i, "19-07-25", true, 0);
            api.post(i, "19-07-26", true, 0);
            api.post(i, "19-07-27", true, 0);
            api.post(i, "19-07-28", true, 0);
            api.post(i, "19-07-29", true, 0);
            api.post(i, "19-07-30", true, 0);
            api.post(i, "19-07-31", true, 0);
            api.post(i, "19-08-01", true, 0);
            api.post(i, "19-08-02", true, 0);
            api.post(i, "19-08-03", true, 0);
            api.post(i, "19-08-04", true, 0);
            api.post(i, "19-08-05", true, 0);
            api.post(i, "19-08-06", true, 0);
            api.post(i, "19-08-07", true, 0);
            api.post(i, "19-08-08", true, 0);
            api.post(i, "19-08-09", true, 0);
            api.post(i, "19-08-10", true, 0);
            api.post(i, "19-08-11", true, 0);
            api.post(i, "19-08-12", true, 0);
            api.post(i, "19-08-13", true, 0);
            api.post(i, "19-08-14", true, 0);
            api.post(i, "19-08-15", true, 0);
            api.post(i, "19-08-16", true, 0);
            api.post(i, "19-08-17", true, 0);
            api.post(i, "19-08-18", true, 0);
            api.post(i, "19-08-19", true, 0);
            api.post(i, "19-08-20", true, 0);
            api.post(i, "19-08-21", true, 0);
            api.post(i, "19-08-22", true, 0);
            api.post(i, "19-08-23", true, 0);
            api.post(i, "19-08-24", true, 0);
            api.post(i, "19-08-25", true, 0);
            api.post(i, "19-08-26", true, 0);
            api.post(i, "19-08-27", true, 0);
            api.post(i, "19-08-28", true, 0);
            api.post(i, "19-08-29", true, 0);
            api.post(i, "19-08-30", true, 0);
            api.post(i, "19-08-31", true, 0);
            api.post(i, "19-09-01", true, 0);
            api.post(i, "19-09-02", true, 0);
            api.post(i, "19-09-03", true, 0);
            api.post(i, "19-09-04", true, 0);
            api.post(i, "19-09-05", true, 0);
            api.post(i, "19-09-06", true, 0);
            api.post(i, "19-09-07", true, 0);
            api.post(i, "19-09-08", true, 0);
            api.post(i, "19-09-09", true, 0);
            api.post(i, "19-09-10", true, 0);
            api.post(i, "19-09-11", true, 0);
            api.post(i, "19-09-12", true, 0);
            api.post(i, "19-09-13", true, 0);
            api.post(i, "19-09-14", true, 0);
            api.post(i, "19-09-15", true, 0);
            api.post(i, "19-09-16", true, 0);
            api.post(i, "19-09-17", true, 0);
            api.post(i, "19-09-18", true, 0);
            api.post(i, "19-09-19", true, 0);
            api.post(i, "19-09-20", true, 0);
            api.post(i, "19-09-21", true, 0);
            api.post(i, "19-09-22", true, 0);
            api.post(i, "19-09-23", true, 0);
            api.post(i, "19-09-24", true, 0);
            api.post(i, "19-09-25", true, 0);
            api.post(i, "19-09-26", true, 0);
            api.post(i, "19-09-27", true, 0);
            api.post(i, "19-09-28", true, 0);
            api.post(i, "19-09-29", true, 0);
            api.post(i, "19-09-30", true, 0);
            api.post(i, "19-10-01", true, 0);
            api.post(i, "19-10-02", true, 0);
            api.post(i, "19-10-03", true, 0);
            api.post(i, "19-10-04", true, 0);
            api.post(i, "19-10-05", true, 0);
            api.post(i, "19-10-06", true, 0);
            api.post(i, "19-10-07", true, 0);
            api.post(i, "19-10-08", true, 0);
            api.post(i, "19-10-09", true, 0);
            api.post(i, "19-10-10", true, 0);
            api.post(i, "19-10-11", true, 0);
            api.post(i, "19-10-12", true, 0);
            api.post(i, "19-10-13", true, 0);
            api.post(i, "19-10-14", true, 0);
            api.post(i, "19-10-15", true, 0);
            api.post(i, "19-10-16", true, 0);
            api.post(i, "19-10-17", true, 0);
            api.post(i, "19-10-18", true, 0);
            api.post(i, "19-10-19", true, 0);
            api.post(i, "19-10-20", true, 0);
            api.post(i, "19-10-21", true, 0);
            api.post(i, "19-10-22", true, 0);
            api.post(i, "19-10-23", true, 0);
            api.post(i, "19-10-24", true, 0);
            api.post(i, "19-10-25", true, 0);
            api.post(i, "19-10-26", true, 0);
            api.post(i, "19-10-27", true, 0);
            api.post(i, "19-10-28", true, 0);
            api.post(i, "19-10-29", true, 0);
            api.post(i, "19-10-30", true, 0);
            api.post(i, "19-10-31", true, 0);
            api.post(i, "19-11-01", true, 0);
            api.post(i, "19-11-02", true, 0);
            api.post(i, "19-11-03", true, 0);
            api.post(i, "19-11-04", true, 0);
            api.post(i, "19-11-05", true, 0);
            api.post(i, "19-11-06", true, 0);
            api.post(i, "19-11-07", true, 0);
            api.post(i, "19-11-08", true, 0);
            api.post(i, "19-11-09", true, 0);
            api.post(i, "19-11-10", true, 0);
            api.post(i, "19-11-11", true, 0);
            api.post(i, "19-11-12", true, 0);
            api.post(i, "19-11-13", true, 0);
            api.post(i, "19-11-14", true, 0);
            api.post(i, "19-11-15", true, 0);
            api.post(i, "19-11-16", true, 0);
            api.post(i, "19-11-17", true, 0);
            api.post(i, "19-11-18", true, 0);
            api.post(i, "19-11-19", true, 0);
            api.post(i, "19-11-20", true, 0);
            api.post(i, "19-11-21", true, 0);
            api.post(i, "19-11-22", true, 0);
            api.post(i, "19-11-23", true, 0);
            api.post(i, "19-11-24", true, 0);
            api.post(i, "19-11-25", true, 0);
            api.post(i, "19-11-26", true, 0);
            api.post(i, "19-11-27", true, 0);
            api.post(i, "19-11-28", true, 0);
            api.post(i, "19-11-29", true, 0);
            api.post(i, "19-11-30", true, 0);
            api.post(i, "19-12-01", true, 0);
            api.post(i, "19-12-02", true, 0);
            api.post(i, "19-12-03", true, 0);
            api.post(i, "19-12-04", true, 0);
            api.post(i, "19-12-05", true, 0);
            api.post(i, "19-12-06", true, 0);
            api.post(i, "19-12-07", true, 0);
            api.post(i, "19-12-08", true, 0);
            api.post(i, "19-12-09", true, 0);
            api.post(i, "19-12-10", true, 0);
            api.post(i, "19-12-11", true, 0);
            api.post(i, "19-12-12", true, 0);
            api.post(i, "19-12-13", true, 0);
            api.post(i, "19-12-14", true, 0);
            api.post(i, "19-12-15", true, 0);
            api.post(i, "19-12-16", true, 0);
            api.post(i, "19-12-17", true, 0);
            api.post(i, "19-12-18", true, 0);
            api.post(i, "19-12-19", true, 0);
            api.post(i, "19-12-20", true, 0);
            api.post(i, "19-12-21", true, 0);
            api.post(i, "19-12-22", true, 0);
            api.post(i, "19-12-23", true, 0);
            api.post(i, "19-12-24", true, 0);
            api.post(i, "19-12-25", true, 0);
            api.post(i, "19-12-26", true, 0);
            api.post(i, "19-12-27", true, 0);
            api.post(i, "19-12-28", true, 0);
            api.post(i, "19-12-29", true, 0);
            api.post(i, "19-12-30", true, 0);
            api.post(i, "19-12-31", true, 0);
            
            System.out.println("stada" + i);
        }
    }
}
