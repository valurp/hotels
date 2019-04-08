/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinnsla;

import java.util.ArrayList;

/**
 *
 * @author Bjartur
 */
public class SearchController {
    
    private API data;
    private ArrayList<Hotel> hotelsFound = new ArrayList<Hotel>();
    private ArrayList<Hotelroom> hotelroomsFound = new ArrayList<Hotelroom>();
    private String currentName = null;
    private Hotel hotel;
    
    public ArrayList <Hotel> search(SearchQuery searchQuery) {
        // þarf að útfæra
        
        hotelroomsFound = data.getHotelRooms(searchQuery);
        
        for (Hotelroom i : hotelroomsFound) {
            String name = i.getHotel();
            if (!currentName.equals(name)) {
                hotel = new Hotel(name);
                hotelsFound.add(hotel);
                hotel.getHotelrooms().add(i);
            }
            else {
                hotel.getHotelrooms().add(i);
            }
            currentName = name;
        }
        return hotelsFound;
    }
}
