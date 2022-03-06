package DAO;

import Model.Meter;
import Model.Reading;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBQuery.setPreparedStatement;

public class ReadingDaoImpl {

    public static ObservableList<Float> getReadings(int meterID) throws SQLException {
        ObservableList<Float> allReadings = FXCollections.observableArrayList();
        String query = "SELECT * FROM reading WHERE meterID = ? ORDER by meterID";
        PreparedStatement ps = setPreparedStatement(query);
        ps.setInt(1, meterID);
        ps.execute();
        ResultSet result = ps.getResultSet();

        while (result.next()) {
            int readingID = result.getInt("readingID");
            Float reading = result.getFloat("reading");
            int metersID = result.getInt("meterID");
            String timestamp = result.getString("time_stamp");

            Reading readingResult = new Reading(readingID, reading, metersID, timestamp);
            allReadings.add(readingResult.getReading());
        }
        return allReadings;
    }
}