package vinnsla;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class API {
    
    private String url;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private String user;
    private String pass;
    
    public API() throws SQLException {
        url = "jdbc:mysql://localhost/hotelsearch";
        user = "user";
        pass = "user";
    }
    
    public void saveCustomer(String name, String email, int bookingRef) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            
            statement = connection.prepareStatement("INSERT INTO customer VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, email);
            statement.setInt(3, bookingRef);
            
            statement.executeUpdate();
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void saveBooking(int roomID, String bDate, String eDate, int bookingRef) {
        try {

            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.prepareStatement("UPDATE dates SET avilable = false, bookingRef = ? WHERE roomID = ? AND date >= ? AND date <= ?");
            statement.setInt(1, bookingRef);
            statement.setInt(2, roomID);
            statement.setString(3, bDate);
            statement.setString(4, eDate);
            
            statement.executeUpdate();

        }catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<Hotelroom> getHotelRooms(String city, boolean breakfast, int rating, String bDate, String eDate) {
        ArrayList<Hotelroom> rooms = new ArrayList<>();
        
        try {
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.prepareStatement("SELECT * FROM hotelroom WHERE hotel IN (SELECT name FROM hotels WHERE city LIKE ? AND breakfast = ? AND rating > ?) AND roomID IN (SELECT roomID FROM dates WHERE avilable = true AND date >= ? AND date <= ?)");
            statement.setString(1,city);
            statement.setBoolean(2, breakfast);
            statement.setInt(3, rating);
            statement.setString(4, bDate);
            statement.setString(5, eDate);
            
            resultSet = statement.executeQuery();
            
            Hotelroom room;
            
            while(resultSet.next()){
                room = new Hotelroom();
                room.setHotel(resultSet.getString(1));
                room.setOneNightPrice(resultSet.getInt(3));
                room.setHotelroomId(resultSet.getInt(4));
                rooms.add(room);
            }

        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rooms;
        }
    }
    
    public Hotel getHotelInfo(String hotelName) {
        Hotel hotel = new Hotel(hotelName);
        try {
            connection = DriverManager.getConnection(url, user, pass);
            
            statement = connection.prepareStatement("SELECT * FROM hotels WHERE name LIKE ?");
            statement.setString(1, hotelName);
            
            resultSet = statement.executeQuery();
            
            
            hotel.setCity(resultSet.getString(2));
            hotel.setEmail(resultSet.getString(3));
            hotel.setPhoneNumber(resultSet.getString(4));
            hotel.setRating(resultSet.getInt(5));
            hotel.setBreakfastBoolean(resultSet.getBoolean(6));
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
            }
            return hotel;
        }
    }
    
    
    //Tímabundið main fall
    public static void main(String[] args) throws SQLException {
        API api = new API();
        ArrayList<Hotelroom> rooms;
        rooms = api.getHotelRooms("Reykjavik", true, 0, "19-04-09", "19-05-01");
        System.out.println(rooms);
        //api.saveBooking(23, "19-04-18", "19-05-18");
        //api.saveBooking(45, "19-12-03", "19-12-12", 12);
        
    }
}
