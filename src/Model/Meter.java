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
}