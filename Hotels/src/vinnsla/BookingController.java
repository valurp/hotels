/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author Bjartur
 */
public class BookingController {
    
    private API data;

    public BookingController() throws SQLException {
        this.data = new API();
    }
    
    public boolean book(Booking booking) {
        //þarf að útfæra
        return data.saveBooking(booking);
    }
    


    public static void main (String[] args) throws SQLException {
        LocalDate inDate = LocalDate.of(2019, Month.JUNE, 1);
        LocalDate outDate = LocalDate.of(2019, Month.JUNE, 5);
        Customer customer = new Customer("Nenni", "nenni@gmail.com");
        Hotelroom hotelroom = new Hotelroom();
        hotelroom.setHotelroomId(2);
        ArrayList <Hotelroom> hotelrooms = new ArrayList <Hotelroom> ();
        hotelrooms.add(hotelroom);
        Booking booking = new Booking(hotelrooms, 0, 2, inDate, outDate, customer);
        BookingController bk = new BookingController();
        bk.book(booking);
        System.out.println(booking.getHotelrooms());
        System.out.println(booking.getCheckInTime());
        System.out.println(booking.getCheckOutTime());
        System.out.println(booking.getCustomer());
        System.out.println(booking.getBookingNumber());
        System.out.println(booking.getNumberOfGuests());
    }
}
