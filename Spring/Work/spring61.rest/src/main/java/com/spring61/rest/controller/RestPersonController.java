package com.spring61.rest.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;
import com.spring61.rest.model.*;

@Controller
@RequestMapping(value = "/rest")
public class RestPersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestPersonController.class);
	
    @RequestMapping(value = "/curtime", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public long curtime() {
        logger.info("/rest/curtime");
        
        return new Date().getTime();
    }
    
    @RequestMapping(value = "/loginperson", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public long loginperson( @RequestParam String id
                           , @RequestParam String pw) {
        logger.info("/rest/loginperson");
    
        return DataStorePerson.loginperson( id, pw );
    }    
    
    // /rest/selectparam?name=id1 :: Query String으로 클라이언트의 데이터를 서버로 전송
    @RequestMapping(value = "/selectparam", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectparam( @RequestParam String name ) {
        logger.info("/rest/selectparam");
       
        ModelPerson person = new ModelPerson();
        person.setName(name);
        
        return DataStorePerson.select(person); 
    }    
    
    // /rest/selectmodel :: form 태그를 이용하여 클라이언트의 데이터를 서버로 전송
    // <form action="/rest/selectmodel" method="post">
    //     <input type="text"     name="id"    />
    //     <input type="password" name="pw"    />
    //     <input type="text"     name="name"  />
    //     <input type="text"     name="email" />
    //     <input type="button"   value="send" />
    // </form>
    @RequestMapping(value = "/selectmodel", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectmodel(@ModelAttribute ModelPerson person ) {
        logger.info("/rest/selectmodel");
        
        return DataStorePerson.select(person); 
    }
    
    // /rest/selectjson :: ajax를 이용하여 json 데이터를 클라이언트의 데이터를 서버로 전송.
    // var model = { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
    @RequestMapping(value = "/selectjson", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectjson(@RequestBody ModelPerson person ) {
        logger.info("/rest/selectjson");
    
        return DataStorePerson.select(person); 
    }
    
    /**
     * 클라이언트(android) ---전송(json:JSONObject)---> 서버(spring) --- 반환(json:JSONArray)--->클라이언트(andorid)
     *
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 스프링에서 안드로이드로 값을 1개 반환한다.
     * 
     * var map = {
     *                'searchvalue' : { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
     *              , 'orderby'     : 'desc'
     *           };
     */
    @RequestMapping(value = "/selectmap", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectmap(Model model
            , @RequestBody Map<String, Object> map) {
        logger.info("/rest/selectmap");
        
        // gson 을 이용하여 json을 model로 변환.
        ModelPerson person = new Gson().fromJson(map.get("searchvalue").toString(), ModelPerson.class);
        String      name   = (String) map.get("orderby");
    
        return DataStorePerson.makePersonData(100, 110);
    }
    
    //rest/selectpaging?start=100&end=200
    @RequestMapping(value = "/selectpaging", method =  {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public List<ModelPerson> selectpaging( Model model
          , @RequestParam(value="start", required = false, defaultValue = "0" ) Integer start
          , @RequestParam(value="end"  , required = false, defaultValue = "10") Integer end) {
        logger.info("/rest/selectpaging");
        
        List<ModelPerson> result = DataStorePerson.makePersonData(start, end);
    
        return result ;
    }
    
    
    
    
    @RequestMapping(value = "/insertparam", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertparam(@RequestParam(value="name", defaultValue="") String name) {
        logger.info("/rest/insertparam");
        
        ModelPerson person = new ModelPerson();
        person.setName(name);
    
        return DataStorePerson.insert(person); 
    }
    
    /**
     * /rest/insertmodel :: form 태그를 이용하여 클라이언트의 데이터를 서버로 전송
     * 
     * <form action="/rest/insertmodel" method="post">
     *     <input type="text"     name="id"    />
     *     <input type="password" name="pw"    />
     *     <input type="text"     name="name"  />
     *     <input type="text"     name="email" />
     *     <input type="button"   value="send" />
     * </form>
     */
    @RequestMapping(value = "/insertmodel", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertmodel(@ModelAttribute ModelPerson person) {
        logger.info("/rest/insertmodel");
       
        return DataStorePerson.insert(person);
    }
    
    /**
     *  ajax를 이용하여 json 데이터를 클라이언트에서 서버로 전송.  
     *  
     * 클라이언트(android) ---전송(json:JSONObject)---> 서버(spring) --- 반환(json:boolean)--->클라이언트(andorid)
     *                            
     *  var model = {'id': '???', 'pw':'???', 'name':'???', 'email':'???' }   
     *                          
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 스프링에서 안드로이드로 값을 1개 반환한다.
     */
    @RequestMapping(value = "/insertjsonobject", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertjsonobject(Model model, @RequestBody ModelPerson person) {
        logger.info("/rest/insertjsonobject");
            
        return DataStorePerson.insert(person);
    }
       
    /**
     * ajax를 이용하여 json 데이터를 클라이언트의 데이터를 서버로 전송.
     * 
     * 클라이언트(android) ---전송(json:JSONArray)---> 서버(spring) --- 반환(json:boolean)--->클라이언트(andorid)
     * 
     * var persons = [ {'id': '???', 'pw':'???', 'name':'???', 'email':'???'}
     *               , {'id': '???', 'pw':'???', 'name':'???', 'email':'???'}
     *               , {'id': '???', 'pw':'???', 'name':'???', 'email':'???'}
     *               ];
     */
    @RequestMapping(value = "/insertjsonarray", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public boolean insertjsonarray(Model model, @RequestBody List<ModelPerson> persons) {
        logger.info("/rest/insertjsonarray");        
    
        return DataStorePerson.insert(persons); 
    }

}
