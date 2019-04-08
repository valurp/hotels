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
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YY-MM-dd");

    public Booking(int bookingId, int numberOfGuests, LocalDate checkInTime, LocalDate checkOutTime, Customer customer) {
        this.bookingId = bookingId;
        this.numberOfGuests = numberOfGuests;
        this.checkInTime = formatter.format(checkInTime);
        this.checkOutTime = formatter.format(checkOutTime);
        this.customer = customer;
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
        this.checkInTime = formatter.format(checkInTime);
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDate checkOutTime) {
        this.checkOutTime = formatter.format(checkOutTime);
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
