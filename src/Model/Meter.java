package Model;

import DAO.CustomerDaoImpl;
import java.sql.SQLException;

public class Meter {
    //<editor-fold defaultstate="collapsed" desc="db variables">

    private int meterID;
    private String meterSerial;
    private int customerID;

    //</editor-fold>

    private Customer customerObj; // Customer Object related to Meter Object via CustomerID

    public Meter(int meterID, String meterSerial, int customerID){
        this.meterID = meterID;
        this.meterSerial = meterSerial;
        this.customerID = customerID;
    }

    //<editor-fold defaultstate="collapsed" desc="db variable setters and getters">

    public int getMeterID(){
        return meterID;
    }

    public void setMeterID(int meterID){
        this.meterID = meterID;
    }

    public String getMeterSerial(){
        return meterSerial;
    }

    public void setMeterSerial(String meterSerial){
        this.meterSerial = meterSerial;
    }

    public int getCustomerID(){
        return customerID;
    }

    public void setCustomerID(int customerID){
        this.customerID = customerID;
    }

    // </editor-fold>

    public Customer getCustomerObj(){
        return this.customerObj;
    }

    public void setCityObj() throws SQLException {
        this.customerObj = CustomerDaoImpl.getCustomer(customerID);
    }
}