package java23.jdbc;

public class ModelAuth {
    private Integer authid = null; // authid INT(11)     NOT NULL,
    private String  name   = ""  ; // name   VARCHAR(50) NULL DEFAULT NULL,
    private String  birth  = ""  ; // birth  VARCHAR(10) NULL DEFAULT NULL,
    
    public ModelAuth() {
        super();
    }

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "ModelAuth [authid=" + authid + ", name=" + name + ", birth="
                + birth + "]";
    }
    
    
}
