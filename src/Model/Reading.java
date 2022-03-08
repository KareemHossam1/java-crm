package Model;

public class Reading {
    private int readingID;
    private float reading;
    private int meterID;
    private String timestamp;

    public Reading(int readingID, float reading, int meterID, String timestamp){
        this.readingID = readingID;
        this.reading = reading;
        this.meterID = meterID;
        this.timestamp = timestamp;
    }

    public int getReadingID(){
        return readingID;
    }
    public float getReading(){
        return reading;
    }
    public int getMeterID(){
        return meterID;
    }
    public String getTimestamp(){
        return timestamp;
    }

}
