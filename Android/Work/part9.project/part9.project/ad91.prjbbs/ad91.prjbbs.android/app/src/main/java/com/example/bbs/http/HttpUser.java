package com.example.bbs.http;

import com.example.bbs.*;
import com.example.bbs.inf.IUser;
import com.example.bbs.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.*;


public class HttpUser implements IUser {

    private static final String HTTP_URL_LOGIN          = AppConstants.HTT_URL_BASE + "/rest/login";
    private static final String HTTP_URL_LOGOUT         = AppConstants.HTT_URL_BASE + "/rest/logout";

    private static final String HTTP_URL_CHECKUSERID    = AppConstants.HTT_URL_BASE + "/rest/checkuserid";
    private static final String HTTP_URL_CHECKPASSWORD  = AppConstants.HTT_URL_BASE + "/rest/checkpassword";

    private static final String HTTP_URL_SELECTUSERONE  = AppConstants.HTT_URL_BASE + "/rest/selectuserone";
    private static final String HTTP_URL_SELECTUSERLIST = AppConstants.HTT_URL_BASE + "/rest/selectuserlist";

    private static final String HTTP_URL_INSERTUSER     = AppConstants.HTT_URL_BASE + "/rest/insertuser";

    private static final String HTTP_URL_UPDATEPASSWD   = AppConstants.HTT_URL_BASE + "/rest/updatepasswd";
    private static final String HTTP_URL_UPDATEUSERINFO = AppConstants.HTT_URL_BASE + "/rest/updateuserinfo";
    private static final String HTTP_URL_UPDATERETIRE   = AppConstants.HTT_URL_BASE + "/rest/updateretire";

    private HttpRequest request = null;
    private int         httpCode = 0;

    @Override
    public ModelUser login(String userid, String passwd) {
        ModelUser   result = null;
        JSONObject  response = null;

        try {
            request = new HttpRequest(HTTP_URL_LOGIN);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("userid", userid);
            request.addBody("passwd", passwd);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }
            //JSONObject(json string) -> ModelUser객체(java object)
            Gson gson = new Gson();
            result = gson.fromJson(String.valueOf(response), ModelUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int logout(String userid) {
        int   result = -1;
        String  response = null;

        try {
            request = new HttpRequest(HTTP_URL_LOGOUT);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("userid", userid);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }
            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int checkuserid(String userid) {
        int   result = -1;
        String  response = null;

        try {
            request = new HttpRequest(HTTP_URL_CHECKUSERID);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("userid", userid);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }
            //JSONObject(json string) -> ModelUser객체(java object)
            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int checkpassword(String id, String pw) {
        int   result = -1;
        String  response = null;

        try {
            request = new HttpRequest(HTTP_URL_CHECKPASSWORD);
            request.configPostType(HttpRequest.MineType.VALUES);

            request.addBody("userid", id);
            request.addBody("passwd", pw);
            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }
            //JSONObject(json string) -> ModelUser객체(java object)
            result = Integer.valueOf(response);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public ModelUser selectUserOne(ModelUser user) {
        ModelUser   result = null;
        JSONObject  response = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTUSERONE);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(user);

            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }

            //JSONObject(json string) -> ModelUser객체(java object)
            Gson gson = new Gson();
            result = gson.fromJson(String.valueOf(response), ModelUser.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelUser> selectUserList(ModelUser user) {
       
        JSONArray response = null;
        List<ModelUser> result = null;

        try {
            request = new HttpRequest(HTTP_URL_SELECTUSERLIST);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(user);

            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONArrayResponse();
            }
            // JSONArray(json string) -> List<ModelUser> 객체(java object)
            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelUser>>(){}.getType() );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result; 
    }

    @Override
    public int insertUser(ModelUser user) {
        int   result = -1;
        String  response = "";

        try {
            request = new HttpRequest(HTTP_URL_INSERTUSER);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(user);

            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }

            result = Integer.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updatePasswd(String userid, String currentPasswd, String newPasswd) {

        int   result = -1;
        String  response = "";

        try {
            request = new HttpRequest(HTTP_URL_UPDATEPASSWD);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("userid"       , userid);
            request.addBody("currentPasswd", currentPasswd);
            request.addBody("newPasswd"    , newPasswd);

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }

            result = Integer.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateUserInfo(ModelUser setValue, ModelUser whereValue) {

        int   result = -1;
        String  response = "";

        try {
            request = new HttpRequest(HTTP_URL_UPDATEUSERINFO);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson ::: ModelUser 인스턴스 --> json으로 변경
            Map<String, Object> map = new HashMap<>();
            map.put("setValue"  ,  setValue    );
            map.put("whereValue",  whereValue  );

            String jsonString = new Gson().toJson(map);
            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }

            result = Integer.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int updateRetire(ModelUser user) {

        int   result = -1;
        String  response = "";

        try {
            request = new HttpRequest(HTTP_URL_UPDATERETIRE);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSONObject :: ModelUser 인스턴스 --> json으로 변경
            String jsonString = new Gson().toJson(user);
            httpCode = request.post(jsonString);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }

            result = Integer.valueOf( response );

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
