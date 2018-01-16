package example.com.serialization;

import java.io.Serializable;

public class ModelSerial implements Serializable {
    private int idata;
    private String sdata;

    public ModelSerial() {
    }

    public ModelSerial(int idata, String sdata) {
        this.idata = idata;
        this.sdata = sdata;
    }

    public int getIdata() {
        return idata;
    }

    public void setIdata(int idata) {
        this.idata = idata;
    }

    public String getSdata() {
        return sdata;
    }

    public void setSdata(String sdata) {
        this.sdata = sdata;
    }
}
