package vinnsla;

import java.sql.*;
/**
 *
 * @author thorgeir93
 */
public class API {
    
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        String user = "user";
        String pass = "user";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelsearch", user, pass);

            statement = connection.createStatement();

            result = statement.executeQuery("select * from hotels");

            while (result.next()) {
                System.out.println(result.getString("name"));
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
}
