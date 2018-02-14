package com.example.bbs.http;

import com.example.bbs.AppConstants;
import com.example.bbs.inf.IBoard;
import com.example.bbs.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.NotImplementedException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.*;

public class HttpBoard implements IBoard {

    private final static String HTTP_URL_GETBOARDONE           = AppConstants.HTT_URL_BASE + "/rest/getboardone";
    private final static String HTTP_URL_GETBOARDNAME          = AppConstants.HTT_URL_BASE + "/rest/getboardname";
    private final static String HTTP_URL_GETBOARDTOTALRECORD   = AppConstants.HTT_URL_BASE + "/rest/getboardtotalrecord";
    private final static String HTTP_URL_GETBOARDPAGING        = AppConstants.HTT_URL_BASE + "/rest/getboardpaging";
    private final static String HTTP_URL_GETBOARDLIST          = AppConstants.HTT_URL_BASE + "/rest/getboardlist";
    private final static String HTTP_URL_INSERTBOARD           = AppConstants.HTT_URL_BASE + "/rest/insertboard";
    private final static String HTTP_URL_UPDATEBOARD           = AppConstants.HTT_URL_BASE + "/rest/updateboard";
    private final static String HTTP_URL_DELETEBOARD           = AppConstants.HTT_URL_BASE + "/rest/deleteboard";
    private final static String HTTP_URL_INSERTBOARDLIST       = AppConstants.HTT_URL_BASE + "/rest/insertboardlist";
    private final static String HTTP_URL_GETARTICLETOTALRECORD = AppConstants.HTT_URL_BASE + "/rest/getarticletotalrecord";
    private final static String HTTP_URL_GETARTICLELIST        = AppConstants.HTT_URL_BASE + "/rest/getarticlelist";
    private final static String HTTP_URL_GETARTICLE            = AppConstants.HTT_URL_BASE + "/rest/getarticle";
    private final static String HTTP_URL_INSERTARTICLE         = AppConstants.HTT_URL_BASE + "/rest/insertarticle";
    private final static String HTTP_URL_UPDATEARTICLE         = AppConstants.HTT_URL_BASE + "/rest/updatearticle";
    private final static String HTTP_URL_DELETEARTICLE         = AppConstants.HTT_URL_BASE + "/rest/deletearticle";
    private final static String HTTP_URL_INCREASEHIT           = AppConstants.HTT_URL_BASE + "/rest/increasehit";
    private final static String HTTP_URL_GETNEXTARTICLE        = AppConstants.HTT_URL_BASE + "/rest/getnextarticle";
    private final static String HTTP_URL_GETPREVARTICLE        = AppConstants.HTT_URL_BASE + "/rest/getprevarticle";
    private final static String HTTP_URL_GETATTACHFILE         = AppConstants.HTT_URL_BASE + "/rest/getattachfile";
    private final static String HTTP_URL_GETATTACHFILELIST     = AppConstants.HTT_URL_BASE + "/rest/getattachfilelist";
    private final static String HTTP_URL_INSERTATTACHFILE      = AppConstants.HTT_URL_BASE + "/rest/insertattachfile";
    private final static String HTTP_URL_DELETEATTACHFILE      = AppConstants.HTT_URL_BASE + "/rest/deleteattachfile";
    private final static String HTTP_URL_GETCOMMENT            = AppConstants.HTT_URL_BASE + "/rest/getcomment";
    private final static String HTTP_URL_GETCOMMENTLIST        = AppConstants.HTT_URL_BASE + "/rest/getcommentlist";
    private final static String HTTP_URL_INSERTCOMMENT         = AppConstants.HTT_URL_BASE + "/rest/insertcomment";
    private final static String HTTP_URL_UPDATECOMMENT         = AppConstants.HTT_URL_BASE + "/rest/updatecomment";
    private final static String HTTP_URL_DELETECOMMENT         = AppConstants.HTT_URL_BASE + "/rest/deletecomment";


    private HttpRequest request = null;
    private int         httpCode = 0;


    @Override
    public String getBoardName(String boardcd) {
        int   result = -1;
        String  response = null;

        try {
            request = new HttpRequest(HTTP_URL_GETBOARDNAME);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("boardcd", boardcd);

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getStringResponse();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int getBoardTotalRecord(String searchWord) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public List<ModelBoard> getBoardPaging(String searchWord, int start, int end) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public List<ModelBoard> getBoardList(String searchWord) {
        JSONArray response = null;
        List<ModelBoard> result = null;

        try {
            request = new HttpRequest(HTTP_URL_GETBOARDLIST);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("searchWord", searchWord);

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONArrayResponse();
            }
            // JSONArray(json string) -> List<ModelBoard> 객체(java object)
            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelBoard>>(){}.getType() );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insertBoard(ModelBoard board) {int   result = -1;
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int updateBoard(ModelBoard setValue, ModelBoard whereValue) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, int start, int end) {

        JSONArray response = null;
        List<ModelArticle> result = null;

        try {
            request = new HttpRequest(HTTP_URL_GETARTICLELIST);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("boardcd"   , boardcd);
            request.addBody("searchWord", searchWord);
            request.addBody("start"     , start + "");
            request.addBody("end"       , end + "");

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONArrayResponse();
            }
            // JSONArray(json string) -> List<ModelBoard> 객체(java object)
            String jsonString = response.toString();
            result = new Gson().fromJson(jsonString, new TypeToken<List<ModelArticle>>(){}.getType() );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ModelArticle getArticle(int articleno) {
        JSONObject response = null;
        ModelArticle result = null;

        try {
            request = new HttpRequest(HTTP_URL_GETARTICLE);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("articleno"   , articleno+"");

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }
            // JSONObject(json string) -> ModelArticle객체(java object)
            result = new Gson().fromJson(response.toString(), ModelArticle.class );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        int   result = -1;
        String  response = "";

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_INSERTARTICLE);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(article);

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
    public int updateArticle(ModelArticle setValue, ModelArticle whereValue) {
        int   result = -1;
        String  response = "";

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_UPDATEARTICLE);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // ModelUser 인스턴스 --> json으로 변경


            // Convert Java object to JSON : toJson
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
    public int deleteArticle(ModelArticle article) {

        int   result = -1;
        String  response = "";

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_DELETEARTICLE);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSONObject :: ModelUser 인스턴스 --> json으로 변경
            String jsonString = new Gson().toJson(article);
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
    public int increaseHit(int articleno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public ModelArticle getNextArticle(int articleno, String boardcd, String searchWord) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public ModelArticle getPrevArticle(int articleno, String boardcd, String searchWord) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public ModelAttachFile getAttachFile(int attachFileNo) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int insertAttachFile(ModelAttachFile attachFile) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int deleteAttachFile(ModelAttachFile attachFile) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments   result = null;
        JSONObject  response = null;

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_GETCOMMENT);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("commentNo", commentNo + "");

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }

            //JSONObject(json string) -> ModelUser객체(java object)
            Gson gson = new Gson();
            result = gson.fromJson(String.valueOf(response), ModelComments.class);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<ModelComments> getCommentList(int articleno) {

        JSONArray response = null;
        List<ModelComments> result = null;

        try {
            request = new HttpRequest(HTTP_URL_GETCOMMENTLIST);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("articleno", articleno + "");

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONArray로 받아온다.
                response = request.getJSONArrayResponse();
            }
            // JSONArray(json string) -> List<ModelComments> 객체(java object)
            result = new Gson().fromJson(response.toString(), new TypeToken<List<ModelComments>>(){}.getType() );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int insertComment(ModelComments comment) {
        int   result = -1;
        String  response = "";

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_INSERTCOMMENT);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(comment);

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
    public int updateComment(ModelComments setValue, ModelComments whereValue) {

        int   result = -1;
        String  response = "";

        //입력받은 id와 pw를 서버에 입력한다. (---> mapper)
        try {
            request = new HttpRequest(HTTP_URL_UPDATECOMMENT);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson ::: ModelComments 인스턴스 --> json으로 변경
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
    public int deleteComment(ModelComments comment) {
        int   result = -1;
        String  response = "";

        try {
            request = new HttpRequest(HTTP_URL_DELETECOMMENT);
            request.configPostType(HttpRequest.MineType.JSONObject);

            // Convert Java object to JSON : toJson
            String jsonString = new Gson().toJson(comment);

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
