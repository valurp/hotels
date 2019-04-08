package vinnsla;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Bjartur
 */
public class SearchController {
    
    private API data;
    private ArrayList<Hotel> hotelsFound = new ArrayList<Hotel>();
    private ArrayList<Hotelroom> hotelroomsFound = new ArrayList<Hotelroom>();
    private String currentName = "name";
    private Hotel hotel;
    

    
    /**
     * Aðferðin tekur inn SearchQuery hlut sem er sendur áfram og er notaður til
     * að finna laus hótelherbergi með þessi leitarviðmið. Býr til ArrayList
     * af Hotel og skilar honum.
     * Setur jafnframt lausu hótelherbergin sem tilheyra hverju hóteli inn í
     * ArrayList af hotelroom sem tilheyrir hverjum hotel hlut.
     * @param searchQuery
     * @return 
     */

    public ArrayList<Hotel> search(SearchQuery searchQuery) throws SQLException {
        data = new API();
        
        hotelroomsFound = data.getHotelRooms(searchQuery);
        
        for (Hotelroom i : hotelroomsFound) {
            String name = i.getHotel();
            if (!currentName.equals(name)) {
                hotel = data.getHotelInfo(name);
                
                hotelsFound.add(hotel);
            }
            
            hotel.setHotelroom(i);
            currentName = name;
        }
        
        for (int j = 0; j < hotelsFound.size(); j++) {
            if (searchQuery.getNumberOfGuests() > hotelsFound.get(j).getHotelrooms().size()*2) {
                hotelsFound.remove(j);
            }
        }
        
        return hotelsFound;
    }
}

