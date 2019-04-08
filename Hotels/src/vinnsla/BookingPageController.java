/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

/**
 *
 * @author Bjartur
 */
public class BookingPageController {
    
    public BookingController bookingController;
    
    public boolean tryToBook(Booking booking) {
        //þarf að útfæra
        
        boolean booked = bookingController.book(booking);
        return booked;
    }
}
