package com.spring63.mvc.model;

public class ModelLogin {
    private String id;
    private String pw;
    public ModelLogin() {
        super();
    }
    public ModelLogin(String id, String pw) {
        super();
        this.id = id;
        this.pw = pw;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    
    
}
