package com.spring.exam09;

public class ModelPhone {
    
    private String  phname    = ""  ;  // `phname` VARCHAR(20) NOT NULL,
    private String  phfactory = ""  ;  // `phfactory` VARCHAR(40) NOT NULL,
    private Integer phprice   = null;  // `phprice` INT(11) NOT NULL DEFAULT '0'
    
    public ModelPhone() {
        super();
    }

    public String getPhname() {
        return phname;
    }

    public void setPhname(String phname) {
        this.phname = phname;
    }

    public String getPhfactory() {
        return phfactory;
    }

    public void setPhfactory(String phfactory) {
        this.phfactory = phfactory;
    }

    public Integer getPhprice() {
        return phprice;
    }

    public void setPhprice(Integer phprice) {
        this.phprice = phprice;
    }

    @Override
    public String toString() {
        return "ModelPhone [phname=" + phname + ", phfactory=" + phfactory
                + ", phprice=" + phprice + "]";
    }
    
    
}
