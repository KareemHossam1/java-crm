package DAO;

import Model.Meter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static DAO.DBQuery.setPreparedStatement;
import static Model.User.getCurrentUser;
import static Utilities.TimeFiles.dbStrNow;

public class MeterDaoImpl extends GeneralDaoImpl{

    //<editor-fold defaultstate="collapsed" desc="data retrieval">

    // Retrieve meter from DB using meterID
    public static Meter getMeter(int meterID) throws SQLException {

        Meter meterResult;
        String sqlStatement = "SELECT * FROM meter WHERE meterID = ?";
        PreparedStatement ps = setPreparedStatement(sqlStatement);
        ps.setInt(1, meterID);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while(rs.next()){
            String meterSerial = rs.getString("meterSerial");
            int customerID = rs.getInt("customerID");
            getMetadata(rs);
            meterResult = new Meter(meterID, meterSerial, customerID);
            return meterResult;
        }
        return null;
    }

    // Retrieve meterSerial from DB using all fields except addressId
    public static Meter getMeter(String meterSerial, int customerID) throws SQLException  {
        
        Meter meterResult;
        String sqlStatement = "SELECT * FROM meter WHERE LOWER(meterSerial) = LOWER(?) AND customerID = ?";
        PreparedStatement ps = setPreparedStatement(sqlStatement);
        ps.setString(1, meterSerial);
        ps.setInt(2, customerID);
        ps.execute();
        ResultSet rs = ps.getResultSet();

        while(rs.next()){
            int meterID = rs.getInt("meterID");
            getMetadata(rs);
            meterResult = new Meter(meterID, meterSerial, customerID);
            return meterResult;
        }
        return null;
    }

    //</editor-fold>

    // Insert address into DB
    /*public static Meter insertAddress(String address, String address2, int cityId, String postalCode, String phone) throws SQLException {

        String createStatement = "INSERT INTO address (addressName, address2Name, cityId, postalCode, phone, createDate, createdBy, lastUpdate, lastUpdateBy) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = setPreparedStatement(createStatement);

        String userName = getCurrentUser().getUserName();
        String time = dbStrNow();

        ps.setString(1, address);
        ps.setString(2, address2);
        ps.setInt(3, cityId);
        ps.setString(4,postalCode);
        ps.setString(5,phone);
        ps.setString(6, time);
        ps.setString(7, userName);
        ps.setString(8, time);
        ps.setString(9, userName);
        ps.execute();

        return getMeter(address, address2, cityId, postalCode, phone);
    }*/

}
