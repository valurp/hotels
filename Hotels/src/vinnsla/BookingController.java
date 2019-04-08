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
    
    /**
     * Aðferðin tekur inn Booking hlut og kallar á aðferð sem vistar bókunina í 
     * gagnagrunninn. Skilar svo boolean gildi hvort það hafi tekist að bóka eða
     * ekki.
     * @param booking
     * @return
     */    
    public boolean book(Booking booking) {
        boolean successful = false;
        successful = data.saveBooking(booking);
        if (successful) {
            booking.setCustomerBookingRef();
            data.saveCustomer(booking.getCustomer());
        }
        return successful;
    }
}
