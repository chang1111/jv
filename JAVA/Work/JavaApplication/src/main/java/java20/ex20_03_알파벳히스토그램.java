package java20;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ex20_03_알파벳히스토그램 {
    
    public static void main(String[] args) {
        
        String text = "This was a great help. I applied this method to similiar problem and rather than concat a SELECT statement I created an event scheduled every couple hours to rebuild a view that pivots n amount of rows from one table into n columns on the other. It's a big help because before I was rebuilding the query using PHP on every execution of the SELECT. Even though views can't leverage Indexes, I'm thinking filtering performance won't be an issue as the pivoted rows->columns represent types of training employees at a franchise have so the view won't ever break a few thousand rows.";
        text = text.toUpperCase();
        
        Map<String, String> map = new HashMap<String, String>();
        
        for (int i = 0; i < text.length();i++) {
            String key = text.substring(i, i + 1);
            String val = "";
            if (key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') {
                if (map.containsKey(key)) {
                    val = map.get(key);
                    map.put(key, val + "-");
                }
                else {
                    map.put(key, "-");
                }
            }
        }
        Map<String, String> treeMap = new TreeMap<String, String>();
        treeMap.putAll(map);
        for (Map.Entry<String, String> elem : treeMap.entrySet()) {
            System.out.println(elem.getKey() + elem.getValue());
        }
    }
}
