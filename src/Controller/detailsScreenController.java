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
import java.util.logging.Level;
import java.util.logging.Logger;

public class detailsScreenController extends GeneralController implements Initializable {

    @FXML
    private ListView<String> metersList;
    @FXML
    private TableView readingsTable;
    @FXML
    private TableColumn readingCol;
    @FXML
    private TableColumn timestampCol;

    private Customer customer;


    private final ObservableList<Meter> meters = FXCollections.observableArrayList();
    private final ObservableList<Reading> readings = FXCollections.observableArrayList();
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
            metersList.getItems().add(meter.getMeterSerial());
        });
        // Filling table
        readingCol.setCellValueFactory(new PropertyValueFactory<Reading, Float>("reading"));
        timestampCol.setCellValueFactory(new PropertyValueFactory<Reading, String>("timestamp"));
        metersList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Your action here
                // Query
                refreshTable(meters.get(metersList.getSelectionModel().getSelectedIndex()).getMeterID());
            }
        });
    }

    private void refreshTable(int meterID){
        readings.clear();
        try{
            readings.addAll(ReadingDaoImpl.getReadings(meterID));
        }
        catch(SQLException e){
            Logger.getLogger("errorlog.txt").log(Level.WARNING,null,e);
            displayErrorAlert("Error retrieving customers from database");
        }
        readingsTable.setItems(readings);
        System.out.println(readings);
    }

    @FXML
    void onActionBack(ActionEvent event) {
        displayScreen(event, "/View/ViewCustomerScreen.fxml");
    }
}