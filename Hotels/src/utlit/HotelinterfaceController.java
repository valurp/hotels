/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utlit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;

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
    private RadioButton breakfast;
    @FXML
    private MenuItem akureyri;
    @FXML
    private MenuItem reykjavik;
    @FXML
    private MenuItem borgarnes;
    @FXML
    private MenuItem husavik;
    @FXML
    private MenuItem keflavik;
    @FXML
    private MenuItem egilsstadir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
