package Model;

public class Meter {

    private int meterID;
    private String meterSerial;
    private int customerID;

    public Meter(int meterID, String meterSerial, int customerID){
        this.meterID = meterID;
        this.meterSerial = meterSerial;
        this.customerID = customerID;
    }
    public String getMeterSerial(){
        return meterSerial;
    }

    public int getMeterID() {
        return meterID;
    }

    public void setMeterID(int meterID) {
        this.meterID = meterID;
    }

    public void setMeterSerial(String meterSerial) {
        this.meterSerial = meterSerial;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}