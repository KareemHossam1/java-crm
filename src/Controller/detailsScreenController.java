package Controller;

import Model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class detailsScreenController extends GeneralController implements Initializable {

    @FXML
    private Button detailsButton;
    @FXML
    private Label detailsScreenTitle;
    @FXML
    private ListView list;
    @FXML
    private TableView readingsTable;
    @FXML
    private TableColumn readingColumn;
    @FXML
    private TableColumn timeColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> y = FXCollections.observableArrayList("Asparagus", "Beans");
        list.setItems(y);



        // Pre-populate fields
        /*customer = Customer.getCurrentCustomer();
        customerNameTxt.setText(customer.getCustomerName());
        addressTxt.setText(customer.getAddress());
        address2Txt.setText(customer.getAddress2());
        postalCodeTxt.setText(customer.getPostalCode());
        cityTxt.setText(customer.getCity());
        countryTxt.setText(customer.getCountry());
        phoneTxt.setText(customer.getPhone());*/

    }





}
