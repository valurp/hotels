/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Bjartur
 */
public class SearchPageController implements Comparator<Hotel> {
    
    private SearchController searchController;
    //private ArrayList <Hotelroom> hotelroomsFound;
    private ArrayList <Hotel> hotelsFound;
    private Hotel hotelToBook;
    //private String currentName = null;
    //private Hotel hotel;
    
    public void searchHandler(SearchQuery searchQuery) {
        //Þarf að útfæra
        
        //hotelsFound = searchController.search(searchQuery);
    }
    
    private void sortByRating() {
        /* 
        Veit ekki alveg með þessa aðferð
        Gerir það að verkum að klasinn þarf að implementa Collections.
        Spurning hvort það sé þægilegra að búa til nýjan klasa til að
        útfæra þetta (t.d. RatingSort).
        Sjá: https://www.geeksforgeeks.org/collections-sort-java-examples/
        */
        
        Collections.sort(hotelsFound, new SearchPageController());
    }

    @Override
    public int compare(Hotel a, Hotel b) {
        return a.getRating() - b.getRating();
    }
}
