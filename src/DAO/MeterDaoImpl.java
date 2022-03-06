package DAO;

import Model.Meter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static DAO.DBQuery.setPreparedStatement;

public class MeterDaoImpl {

    //<editor-fold defaultstate="collapsed" desc="data retrieval">
    // Get a list of all meters of selected customer
    public static ObservableList<Meter> getMeters(int customerID) throws SQLException{
        ObservableList<Meter> allMeters= FXCollections.observableArrayList();
        String query = "SELECT * FROM meter WHERE customerID = ? ORDER by customerID";
        PreparedStatement ps = setPreparedStatement(query);
        ps.setInt (1, customerID);
        ps.execute();
        ResultSet result = ps.getResultSet();

        while(result.next()){
            int meterID = result.getInt("meterID");
            String meterSerial = result.getString("meterSerial");
            int customersID = result.getInt("customerID");
            Meter meterResult = new Meter(meterID, meterSerial, customersID);
            allMeters.add(meterResult);
        }

        return allMeters;
    }
}