package vinnsla;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
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
    
    /**
     * Vistar viðskiptavin ásamt bókunar reference í gagnagrunn.
     * @param name
     * @param email
     * @param bookingRef 
     */
    public void saveCustomer(Customer customer) {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            
            statement = connection.prepareStatement("INSERT INTO customer VALUES (?, ?, ?)");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getEmail());
            statement.setInt(3, customer.getBookingRef());
            
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
    
    
    /**
     * Vistar bókun í gagnagrunninn og skilar boolean gildi sem segir til um 
     * hvort það hafi tekist að vista bókunina eða ekki.
     * @param booking
     * @return 
     */
    public boolean saveBooking(Booking booking) {
        try {

            connection = DriverManager.getConnection(url, user, pass);

            ArrayList<Hotelroom> hotelrooms = booking.getHotelrooms();
            
            for(Hotelroom hotelroom : hotelrooms) {
                statement = connection.prepareStatement("UPDATE dates SET avilable = false, bookingRef = ? WHERE roomID = ? AND date >= ? AND date <= ?");
                statement.setInt(1, booking.getBookingNumber());
                statement.setInt(2, hotelroom.getHotelroomNumber());
                statement.setString(3, booking.getCheckInTime());
                statement.setString(4, booking.getCheckOutTime());
            
                statement.executeUpdate();
            }

        }catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        } finally {
            try {
                connection.close();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(API.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }
    
    /**
     * Finnur öll hótelherbergi sem eru laus fyrir viðmiðin í searchQuery og
     * skilar ArrayList <Hotelroom>.
     * @param searchQuery
     * @return 
     */
    public ArrayList<Hotelroom> getHotelRooms(SearchQuery searchQuery) {
        ArrayList<Hotelroom> rooms = new ArrayList<>();
        
        try {
            connection = DriverManager.getConnection(url, user, pass);

            statement = connection.prepareStatement("SELECT * FROM hotelroom WHERE hotel IN (SELECT name FROM hotels WHERE city LIKE ? AND breakfast = ? AND rating > ?) AND roomID IN (SELECT roomID FROM dates WHERE avilable = true AND date >= ? AND date <= ?)");
            statement.setString(1, searchQuery.getCity());
            statement.setBoolean(2, searchQuery.isBreakfast());
            statement.setInt(3, searchQuery.getMinRating());
            statement.setString(4, searchQuery.getCheckInDate());
            statement.setString(5, searchQuery.getCheckOutDate());
            
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
            resultSet.next();
            
            System.out.println(resultSet.getString(1));
            
            
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
}
