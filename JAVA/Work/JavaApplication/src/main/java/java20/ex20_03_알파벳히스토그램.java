package java20;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ex20_03_알파벳히스토그램 {
    
    public static void main(String[] args) {
        
        String text = "This was a great help. I applied this method to similiar problem and rather than concat a SELECT statement I created an event scheduled every couple hours to rebuild a view that pivots n amount of rows from one table into n columns on the other. It's a big help because before I was rebuilding the query using PHP on every execution of the SELECT. Even though views can't leverage Indexes, I'm thinking filtering performance won't be an issue as the pivoted rows->columns represent types of training employees at a franchise have so the view won't ever break a few thousand rows.";
        
        Map<String, String> map = new HashMap<>();
        
        for (int i = 0; i < text.length(); i++) {
            String key = text.substring(i, i + 1);
            key = key.toUpperCase();
            if (key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') {
                String val = map.get(key);
                if (val == null) {
                    map.put(key, "-");
                } else {
                    map.put(key, val + "-");
                }
            }
        }
        
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.putAll(map); // HashMap -> TreeMap으로 변환
        for (Map.Entry<String, String> elem : treeMap.entrySet()) {
            System.out.println(elem.getKey() + elem.getValue());
        }
    }
    
}
