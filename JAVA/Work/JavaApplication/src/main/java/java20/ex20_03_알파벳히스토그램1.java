package java20;

import java.util.HashMap;
import java.util.Map;

public class ex20_03_알파벳히스토그램1 {
    
    public static void main(String[] args) {
        
        String text = "This was a great help. I applied this method to similiar problem and rather than concat a SELECT statement I created an event scheduled every couple hours to rebuild a view that pivots n amount of rows from one table into n columns on the other. It's a big help because before I was rebuilding the query using PHP on every execution of the SELECT. Even though views can't leverage Indexes, I'm thinking filtering performance won't be an issue as the pivoted rows->columns represent types of training employees at a franchise have so the view won't ever break a few thousand rows.";
        text = text.toUpperCase();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch = 'A';ch <= 'Z';ch++) {
            map.put(ch, 0);
        }
        for (int i = 0;i < text.length();i++) {
            char key = text.charAt(i);
            
            if (key >= 'A' && key <= 'Z') {
                map.put(key, map.get(key)+1);
            }
        }
        for (char ch = 'A';ch <= 'Z';ch++) {
            if (map.get(ch) != 0) {
                System.out.print(ch);
                for (int i = 0;i < map.get(ch);i++) {
                    System.out.print('-');
                }
                System.out.println();
            }
        }
    }
}
