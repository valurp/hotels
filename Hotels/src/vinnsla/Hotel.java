/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vinnsla;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
/**
 *
 * @author Valur Páll Stefán Valsson <vpv1@hi.is>
 * Háskóli Íslands
 */
public class Hotel extends Application {

    private Hotelroom[] hotelrooms;
    private String name;
    private String city;
    private String email;
    private String phoneNumber;
    private boolean breakfastBool;
    


    public Hotelroom[] getHotelrooms() {
        return hotelrooms;
    }

    public void setHotelrooms(Hotelroom[] hotelrooms) {
        this.hotelrooms = hotelrooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isBreakfastBool() {
        return breakfastBool;
    }

    public void setBreakfastBoolean(boolean breakfastBool) {
        this.breakfastBool = breakfastBool;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    private int rating;
    
    
    @FXML
    private DatePicker arrDate;
    @FXML
    private DatePicker depDate;
    @FXML
    private MenuButton Cities;
    @FXML
    private RadioButton breakfast;
    @FXML
    private Button searchbutton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hotelinterface.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

