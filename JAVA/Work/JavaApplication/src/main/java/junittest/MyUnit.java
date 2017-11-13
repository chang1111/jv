package junittest;

import java.util.*;

public class MyUnit {

    public String concate(String string, String string2) {        
        return string+string2;
    }

    public boolean getBoolean() {
        return false;
    }

    public Object getSameObject() {
        return null;
    }

    public Object getObject() {
        return null;
    }

    public String[] getStringArray() {
        return new String[]{"one", "two", "three"};
    }
    
    public double getException() throws ArithmeticException {
        throw new ArithmeticException("Not Implemented Exception"); 
    }
    
    public ArrayList<String> getEmptyList(){
        return new ArrayList<String>();
    }
}
