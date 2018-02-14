package com.example.bbs.inf;

import com.example.bbs.model.ModelPerson;

import java.util.List;
import java.util.Map;

public interface IPerson {
    
    long curtime();
    
    long loginperson(String id, String pw);
    
    // /rest/selectparam?name=id1 :: Query String으로 클라이언트의 데이터를 서버로 전송
    List<ModelPerson> selectparam(String name);
    
    // /rest/selectmodel :: form 태그를 이용하여 클라이언트의 데이터를 서버로 전송
    // <form action="/rest/selectmodel" method="post">
    //     <input type="text"     name="id"    />
    //     <input type="password" name="pw"    />
    //     <input type="text"     name="name"  />
    //     <input type="text"     name="email" />
    //     <input type="button"   value="send" />
    // </form>
    List<ModelPerson> selectmodel(ModelPerson person);
    
    // /rest/selectjson :: ajax를 이용하여 json 데이터를 클라이언트의 데이터를 서버로 전송.
    // var model = { 'id': '???', 'pw':'???', 'name':'???', 'email':'???' }
    List<ModelPerson> selectjson(ModelPerson person);
    
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
    List<ModelPerson> selectmap( ModelPerson searchvalue, String orderby );
    
    //rest/selectpaging?start=100&end=200
    List<ModelPerson> selectpaging(Integer start, Integer end);
    
    boolean insertparam(String name);
    
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
    boolean insertmodel(ModelPerson person);
    
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
    boolean insertjsonobject(ModelPerson person);
    
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
    boolean insertjsonarray(List<ModelPerson> persons);
    
}
