package com.spring61.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring61.rest.model.ModelPerson;

@Service
public final class DataStorePerson {
    
    private static final Logger logger = Logger.getLogger(DataStorePerson.class.getName());

    private static List<ModelPerson> lists = null;

    public DataStorePerson() {
        lists = DataStorePerson.makePersonData(1, 100);
    }

    public static int loginperson(String id, String pw) {
        logger.info("loginperson " );
        synchronized (lists) {

            List<ModelPerson> result = lists.stream()
                                            .filter( e-> e.getId().equals(id) && e.getPw().equals(pw) )
                                            .collect( Collectors.toList() );
            
            return result != null ? result.size() : 0;
        }
    }

    public static List<ModelPerson> select(ModelPerson person) {
        logger.info("select " + person);
        synchronized (lists) {
            return new ArrayList<ModelPerson>(lists);
        }
    }

    public static boolean insert(ModelPerson person) {
        logger.info("insert " + person);
        synchronized (lists) {
            return lists.add(person);
        }
    }

    public static boolean insert( List<ModelPerson> persons) {
        logger.info("insert " + persons);
        synchronized (lists) {
            return lists.addAll(lists.size(), persons);
        }
    }

    public static boolean update(ModelPerson oldp, ModelPerson newp) {
        logger.info("update " + oldp + " to " + newp);
        
        synchronized (lists) {
            lists.remove(oldp);
            lists.add(newp);
            return true;
        }
    }

    public static boolean delete(ModelPerson person) {
        logger.info("delete " + person);
        synchronized (lists) {
            return lists.remove(person);
        }
    }
    

    public static String getRandString() {
        String str = "";
        
        for (int i = 1; i <= (int) (Math.random() * 10000); i++) {
            str += String.valueOf((char) ((Math.random() * 26) + 97));
        }
        
        return str;
    }

    public static List<ModelPerson> makePersonData(Integer start, Integer end ) {
        List<ModelPerson> result = new ArrayList<>(); 
        for(int i = start ; i<= end; i++) {
            ModelPerson person = new ModelPerson();
            
            person.setId   ( "id"    + String.valueOf(i) );
            person.setPw   ( "pw"    + String.valueOf(i) );   
            person.setName ( "name"  + String.valueOf(i) );  
            person.setEmail( "email" + String.valueOf(i) );  
            
            result.add(person);    
        }
        
        return result;
    }
}
