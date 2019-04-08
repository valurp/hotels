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

        // þarf að útfæra
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
        return hotelsFound;
    }
    public static void main(String[] args) throws SQLException {
        SearchController sq = new SearchController();
        LocalDate bDate = LocalDate.of(2019, 04, 05);
        LocalDate eDate = LocalDate.of(2019, 05, 05);
        ArrayList<Hotel> hotels = sq.search(new SearchQuery(bDate, eDate, "Reykjavik", 2, true, 2));
        System.out.println(hotels);
    }
}

