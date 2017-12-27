package di02;

public class Type {
    
    private String name;
    private String desc;
    private String extension;
    
    public Type() {
        super();
    }

    public Type(String name, String desc, String extension) {
        super();
        this.name = name;
        this.desc = desc;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "Type [name=" + name + ", desc=" + desc + ", extension="
                + extension + "]";
    }
    
}
