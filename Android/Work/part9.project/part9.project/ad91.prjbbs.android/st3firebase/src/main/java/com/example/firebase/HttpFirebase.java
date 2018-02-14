package com.example.firebase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;


public class HttpFirebase  {

    private static final String FIREBASE_SERVER_KEY = "AAAAWI3mmp4:APA91bFh_syDBIhnX89hqvC0FR31cZxpnOml2gScJqic81DNThz3fBxAzkq0NtuuHBdiTOLuhEIVaS6BKRouL-HTj--amgjI8lMTxaRRkBGLXYf3XSPui_Hv61RhBqJ4ArZlpSqIsqe9";

    private static final String HTTP_URL_FCM = "https://fcm.googleapis.com/fcm/send";

    private HttpRequest request = null;
    private int         httpCode = 0;

    public Boolean sendData(String regId, String message) {

        Boolean result = null;
        JSONObject response = null;

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {

            /*
              {
                    "priority" : "high"
                    , "data" : {"contents" : "?????" }
                    , "registration_ids" : [ "regID" ]
              }
             */
            JSONObject requestData = new JSONObject();
            requestData.put("priority", "high");

            JSONObject dataObj = new JSONObject();
            dataObj.put("contents", message);
            requestData.put("data", dataObj);

            JSONArray idArray = new JSONArray();
            idArray.put(0, regId);
            requestData.put("registration_ids", idArray);

            request = new HttpRequest(HTTP_URL_FCM);
            request.configPostType(HttpRequest.MineType.JSONObject);
            request.addHeader("Authorization" , "key=" + FIREBASE_SERVER_KEY );

            // Convert Java object to JSON : toJson
            //String jsonString = new Gson().toJson(article);
            httpCode = request.post(requestData.toString());

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }

            // 반환형태: {"multicast_id":8924580865925777608,"success":1,"failure":0,"canonical_ids":0,"results":[{"message_id":"0:1517978264048193%43383ed8f9fd7ecd"}]}
            result = Boolean.valueOf(  response.get("success").toString() );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
