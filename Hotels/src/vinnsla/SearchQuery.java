/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Bjartur
 */
public class SearchQuery {
    
    private String checkInDate;
    private String checkOutDate;
    private String city;
    private int numberOfGuests;
    private boolean breakfast;
    private int minRating;
    
    /**
     * Smiður fyrir SearchQuery sem tekur inn String checkInDate, String
     * checkOutDate, String city, int numberOfGuests, boolean breakfast og int
     * minRating.
     * @param checkInDate
     * @param checkOutDate
     * @param city
     * @param numberOfGuests
     * @param breakfast
     * @param minRating 
     */
    public SearchQuery(LocalDate checkInDate, LocalDate checkOutDate, String city, int numberOfGuests, boolean breakfast, int minRating) {
        this.checkInDate = checkInDate.toString().substring(2);
        this.checkOutDate = checkOutDate.toString().substring(2);
        this.city = city;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.minRating = minRating;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkOutDate.toString().substring(2);
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate.toString().substring(2);
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
