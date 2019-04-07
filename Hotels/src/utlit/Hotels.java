/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utlit;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vinnsla.SearchPageController;
/**
 *
 * @author Valur Páll Stefán Valsson <vpv1@hi.is>
 * Háskóli Íslands
 */
public class Hotels extends Application {
   
    
    @FXML
    private DatePicker arrDate;
    @FXML
    private DatePicker depDate;
    @FXML
    private MenuButton Cities;
    @FXML
    private CheckBox breakfastButton;
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
    
    public boolean breakfast;

    @FXML
    public ListView<String> results;
    

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
     * Controller fyrir interface-ið
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * TODO:
     * Fá niðurstöður frá SearchPageController og birta í results ListView-inu
     *
     */
    

    @FXML
    private void searchHandler(ActionEvent event) {
        
    }

    @FXML
    private void arrDateHandler(ActionEvent event) {
        
    }

    @FXML
    private void depDateHandler(ActionEvent event) {
        
    }

    @FXML
    private void akSelect(ActionEvent event) {
        Cities.setText("Akureyri");
    }

    @FXML
    private void rvkSelect(ActionEvent event) {
        Cities.setText("Reykjavík");
    }

    @FXML
    private void kefSelect(ActionEvent event) {
        Cities.setText("Keflavík");
    }

    @FXML
    private void egSelect(ActionEvent event) {
        Cities.setText("Egilsstaðir");
    }

    @FXML
    private void breakfastButtonHandler(ActionEvent event) {
        breakfast = breakfastButton.isSelected();
    }
    
    
    }

