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
class Customer {
    private String name;
    private String email;
    private int bookingRef;
    
    /**
     * Smiður fyrir Customer sem tekur inn String name og String email.
     * @param name
     * @param email 
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(int bookingRef) {
        this.bookingRef = bookingRef;
    }
    
}
