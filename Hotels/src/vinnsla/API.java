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
        LocalDate dateOne = LocalDate.of(2019, Month.APRIL, 9);
        LocalDate dateTwo = LocalDate.of(2019, Month.MAY, 1);
        SearchQuery searchQuery = new SearchQuery(dateOne, dateTwo, "Reykjavik", 2, true, 0);
        rooms = api.getHotelRooms(searchQuery);
        System.out.println(rooms);
        
        LocalDate inDate = LocalDate.of(2019, Month.JULY, 17);
        LocalDate outDate = LocalDate.of(2019, Month.JULY, 18);
        System.out.println(inDate);
        Customer customer = new Customer("Nenni", "nenni@gmail.com");
        Hotelroom hotelroom = new Hotelroom();
        hotelroom.setHotelroomId(2);
        Hotelroom hotelroomTwo = new Hotelroom();
        hotelroomTwo.setHotelroomId(3);
        Hotelroom hotelroomThree = new Hotelroom();
        hotelroomThree.setHotelroomId(4);
        ArrayList <Hotelroom> hotelrooms = new ArrayList <Hotelroom> ();
        hotelrooms.add(hotelroom);
        hotelrooms.add(hotelroomTwo);
        hotelrooms.add(hotelroomThree);
        Booking booking = new Booking(hotelrooms, 0, 2, inDate, outDate, customer);
        if(api.saveBooking(booking)) {
            System.out.println("virkar");
        }
        //api.saveBooking(23, "19-04-18", "19-05-18");
        //api.saveBooking(45, "19-12-03", "19-12-12", 12);
        
    }
}
