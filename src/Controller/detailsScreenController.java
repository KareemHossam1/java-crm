package Controller;

import DAO.MeterDaoImpl;
import DAO.ReadingDaoImpl;
import Model.Customer;
import Model.Meter;
import Model.Reading;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class detailsScreenController extends GeneralController implements Initializable {

    @FXML
    private ListView<String> list;
    @FXML
    private TableView readingsTable;
    @FXML
    private TableColumn IDCol;
    @FXML
    private TableColumn readingCol;
    @FXML
    private TableColumn timestampCol;
    @FXML
    private TableColumn meterIDCol;

    private Customer customer;


    private final ObservableList<Meter> meters = FXCollections.observableArrayList();
    private final ObservableList<String> readings = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Filling ListView
        meters.clear();
        customer = Customer.getCurrentCustomer();
        try{
            meters.addAll(MeterDaoImpl.getMeters(customer.getCustomerId()));
        }
        catch(SQLException e){
            System.out.println(e);
        }
        meters.forEach((meter) -> {
            list.getItems().add(meter.getMeterSerial());
        });
        // Filling table
        IDCol.setCellValueFactory(new PropertyValueFactory<>("readingID"));
        readingCol.setCellValueFactory(new PropertyValueFactory<>("reading"));
        timestampCol.setCellValueFactory(new PropertyValueFactory<>("meterID"));
        meterIDCol.setCellValueFactory(new PropertyValueFactory<>("time_stamp"));
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Your action here
                // Query

            }
        });
    }





    @FXML
    void onActionBack(ActionEvent event) {
        displayScreen(event, "/View/ViewCustomerScreen.fxml");
    }
}