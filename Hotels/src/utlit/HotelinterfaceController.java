/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlit;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import vinnsla.Booking;
import vinnsla.BookingController;
import vinnsla.Customer;
import vinnsla.Hotel;
import vinnsla.SearchController;
import vinnsla.SearchQuery;

/**
 * FXML Controller class
 *
 * @author Valur Páll Stefán Valsson <vpv1@hi.is>
 */
public class HotelinterfaceController implements Initializable {

    @FXML
    private DatePicker arrDate;
    @FXML
    private DatePicker depDate;
    @FXML
    private MenuButton Cities;
    @FXML
    private Button searchbutton;
    @FXML
    private MenuItem akureyri;
    @FXML
    private MenuItem reykjavik;
    @FXML
    private MenuItem keflavik;
    @FXML
    private MenuItem egilsstadir;
    @FXML
    private ListView<String> results;
    @FXML
    private CheckBox breakfastButton;
    @FXML
    private TextField noOfGuests;
    
    @FXML
    private MenuButton minRating;
    @FXML
    private MenuItem rating1;
    @FXML
    private MenuItem rating2;
    @FXML
    private MenuItem rating3;
    @FXML
    private MenuItem rating4;
    @FXML
    private MenuItem rating5;
    
    public boolean breakfast;
    LocalDate arrival;
    LocalDate departure;
    String city;

    int numberOfGuests;
    int minimumRating;
    SearchController searchController;
    private ArrayList <Hotel> hotelsFound;
    private ObservableList<String> hotelsFoundObservable;
    private ObservableList<String> birtaValidHotel;
    private int numerHotels;
    @FXML
    private ListView<String> validHotel;
    @FXML
    private Label uppl;
    @FXML
    private Label nafn;
    @FXML
    private Label email;
    @FXML
    private TextField nafnInput;
    @FXML
    private TextField emailInput;
    
    String customerNafn;
    String customerEmail;
    @FXML
    private Button bokaTakki;
    @FXML
    private TextArea skilabod;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void arrDateHandler(ActionEvent event) {
        arrival = arrDate.getValue();
    }

    @FXML
    private void depDateHandler(ActionEvent event) {
        departure = depDate.getValue();
    }

    @FXML
    private void akSelect(ActionEvent event) {
        city = "Akureyri";
        Cities.setText("Akureyri");
    }

    @FXML
    private void rvkSelect(ActionEvent event) {
        city = "Reykjavík";
        Cities.setText("Reykjavík");
    }

    @FXML
    private void kefSelect(ActionEvent event) {
        city = "Keflavík";
        Cities.setText("Keflavík");
    }

    @FXML
    private void egSelect(ActionEvent event) {
        city = "Egilsstaðir";
        Cities.setText("Egilsstaðir");
    }
    
    private void getNumberOfGuests(){
        numberOfGuests = Integer.parseInt(noOfGuests.getText());
    }
    
    @FXML
    private void breakfastButtonHandler(ActionEvent event) {
        breakfast = breakfastButton.isSelected();
    }

    @FXML
    private void selectRating1(ActionEvent event) {
        minRating.setText("1");
        minimumRating = 1;
    }

    @FXML
    private void selectRating2(ActionEvent event) {
        minRating.setText("2");
        minimumRating = 2;
    }

    @FXML
    private void selectRating3(ActionEvent event) {
        minRating.setText("3");
        minimumRating = 3;
    }

    @FXML
    private void selectRating4(ActionEvent event) {
        minRating.setText("4");
        minimumRating = 4;
    }

    @FXML
    private void selectRating5(ActionEvent event) {
        minRating.setText("5");
        minimumRating = 5;
    }
    
    @FXML
    private void searchHandler(ActionEvent event) throws SQLException {
        searchController = new SearchController();
        SearchQuery searchQuery = new SearchQuery(arrival, departure, city, numberOfGuests, breakfast, minimumRating);
        hotelsFound = searchController.search(searchQuery);
  
        hotelsFoundObservable = FXCollections.observableArrayList();
        
        //hotelsFound sett í ObservableList
        for (int i=0; i<hotelsFound.size(); i++) {
            hotelsFoundObservable.add(i, hotelsFound.get(i).getName());
            System.out.println(hotelsFound.get(i).getName());
        }
 
        results.setItems(hotelsFoundObservable);
        
        //Prófun á að bæta hlutum inn í results gluggann - virkar
        //ObservableList<String> list = FXCollections.observableArrayList("test", "test2");
        //results.setItems(list);
        
    }

    @FXML
    private void resultsHandler(MouseEvent event) {
        numerHotels = results.getSelectionModel().getSelectedIndex();
        System.out.println(numerHotels);
        birtaValidHotel = FXCollections.observableArrayList();
        birtaValidHotel.add(0, hotelsFoundObservable.get(numerHotels));
        validHotel.setItems(birtaValidHotel);
        uppl.setVisible(true);
        nafn.setVisible(true);
        email.setVisible(true);
        nafnInput.setVisible(true);
        emailInput.setVisible(true);
        bokaTakki.setVisible(true);
        //hotelsFoundObservable.get(numerHotels);
    }

    @FXML
    private void bokaTakkiHandler(ActionEvent event) throws SQLException {
        BookingController bookingController = new BookingController();
        Customer customer = new Customer(nafnInput.getText(), emailInput.getText());
        Booking booking = new Booking(hotelsFound.get(numerHotels).getHotelrooms(), numberOfGuests, arrival, departure, customer);
        bookingController.book(booking);
        skilabod.setVisible(true);
        skilabod.setText("Til hanmingju þú hefur bókað hjá " + hotelsFoundObservable.get(numerHotels));
    }
    
    
    
}
