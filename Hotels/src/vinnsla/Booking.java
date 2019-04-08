/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Bjartur
 */
public class Booking {
    private ArrayList <Hotelroom> hotelrooms;
    private int bookingId;
    private int numberOfGuests;
    private String checkInTime;
    private String checkOutTime;
    private Customer customer;
    

    /**
     * Smiður fyrir Booking, tekur inn ArrayList <Hotelroom> hotelrooms,
     * int numberOfGuests, LocalDate checkInTime, LocalDate checkOutTime og
     * Customer customer og býr til bookingId fyrir bókunina. LocalDate breytum
     * hérna er breytt í String.
     * @param hotelrooms
     * @param bookingId
     * @param numberOfGuests
     * @param checkInTime
     * @param checkOutTime
     * @param customer 
     */
    public Booking(ArrayList <Hotelroom> hotelrooms, int numberOfGuests, LocalDate checkInTime, LocalDate checkOutTime, Customer customer) {
        this.hotelrooms = hotelrooms;
        this.numberOfGuests = numberOfGuests;
        this.checkInTime = checkInTime.toString().substring(2);
        this.checkOutTime = checkOutTime.toString().substring(2);
        this.customer = customer;
        this.bookingId = createBookingID();
    }
    private int createBookingID() {
        String string = hotelrooms.get(0).getHotelroomNumber() + checkInTime.substring(3, 5).concat(checkInTime.substring(6, 8));
        return Integer.parseInt(string);

    }

    public ArrayList<Hotelroom> getHotelrooms() {
        return hotelrooms;
    }

    public void setHotelrooms(ArrayList<Hotelroom> hotelrooms) {
        this.hotelrooms = hotelrooms;
    }

    public int getBookingNumber() {
        return bookingId;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingId = bookingId;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDate checkInTime) {
        this.checkInTime = checkInTime.toString().substring(2);
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDate checkOutTime) {
        this.checkOutTime = checkOutTime.toString().substring(2);
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public void setCustomerBookingRef() {
        this.customer.setBookingRef(bookingId);
    }
}
