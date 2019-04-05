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
    
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String city;
    private int numberOfGuests;
    private boolean breakfast;
    private int minRating;

    public SearchQuery(LocalDate checkInDate, LocalDate checkOutDate, String city, int numberOfGuests, boolean breakfast, int minRating) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.city = city;
        this.numberOfGuests = numberOfGuests;
        this.breakfast = breakfast;
        this.minRating = minRating;
    }
    
    
    
}
