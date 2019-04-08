/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.time.LocalDate;

/**
 *
 * @author Bjartur
 */
class SearchQuery {
    
    private String checkInDate;
    private String checkOutDate;
    private String city;
    private int numberOfGuests;
    private boolean breakfast;
    private int minRating;

    public SearchQuery(String checkInDate, String checkOutDate, String city, int numberOfGuests, boolean breakfast, int minRating) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.city = city;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.minRating = minRating;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public int getMinRating() {
        return minRating;
    }

    public void setMinRating(int minRating) {
        this.minRating = minRating;
    }
    
    
    
}
