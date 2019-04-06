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
class Hotelroom {
    private String hotel;
    private int hotelroomId;
    private int oneNightPrice;
    private boolean available;


    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public int getHotelroomNumber() {
        return hotelroomId;
    }

    public void setHotelroomId(int hotelRoomId) {
        this.hotelroomId = hotelRoomId;
    }

    public int getOneNightPrice() {
        return oneNightPrice;
    }

    public void setOneNightPrice(int oneNightPrice) {
        this.oneNightPrice = oneNightPrice;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
}
