/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlit;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

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
    private ListView<?> results;
    @FXML
    private CheckBox breakfastButton;
    
    public boolean breakfast;
    LocalDate arrival;
    LocalDate departure;
    String city;

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

    @FXML
    private void searchHandler(ActionEvent event) {
    }

    @FXML
    private void breakfastButtonHandler(ActionEvent event) {
        breakfast = breakfastButton.isSelected();
    }
    
}
