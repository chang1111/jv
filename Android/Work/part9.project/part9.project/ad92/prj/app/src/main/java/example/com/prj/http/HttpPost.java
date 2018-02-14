package example.com.prj.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;

import example.com.prj.AppConstants;
import example.com.prj.inf.IPost;
import example.com.prj.model.ModelAttachImage;
import example.com.prj.model.ModelComments;
import example.com.prj.model.ModelPost;

import org.apache.commons.lang3.NotImplementedException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpPost implements IPost {

    private final static String HTTP_URL_GETPOSTLIST = AppConstants.HTT_URL_BASE + "/rest/getpostlist";
    private final static String HTTP_URL_GETPOSTONE = AppConstants.HTT_URL_BASE + "/rest/getpostone";

    private HttpRequest request = null;
    private int         httpCode = 0;

    @Override
    public List<ModelPost> getPostList(int start, int end) {
        JSONArray response = null;
        List<ModelPost> result = null;

        try {
            request = new HttpRequest(HTTP_URL_GETPOSTLIST);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("start"     , start + "");
            request.addBody("end"       , end + "");

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONArrayResponse();
            }
            // JSONArray(json string) -> List<ModelBoard> 객체(java object)
            String jsonString = response.toString();
            result = new Gson().fromJson(jsonString, new TypeToken<List<ModelPost>>(){}.getType() );
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
    public ModelPost getPostOne(int postno) {
        JSONObject response = null;
        ModelPost result = null;

        try {
            request = new HttpRequest(HTTP_URL_GETPOSTONE);
            request.configPostType(HttpRequest.MineType.VALUES);
            request.addBody("postno"     , postno + "");

            httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                //접속에 성공하면 정보를 JSONObject로 받아온다.
                response = request.getJSONObjectResponse();
            }
            // JSONArray(json string) -> List<ModelBoard> 객체(java object)
            String jsonString = response.toString();
            result = new Gson().fromJson(jsonString, ModelPost.class );
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
    public int insertPost(ModelPost post) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int deletePost(ModelPost post) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public ModelAttachImage getAttachImage(Integer postno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int insertAttachImage(ModelAttachImage image) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int deleteAttachImage(ModelAttachImage image) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public ModelComments getComment(int commentno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public List<ModelComments> getCommentList(int postno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int insertComment(ModelComments comment) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int deleteComment(ModelComments comment) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int addCountGood(int postno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }

    @Override
    public int addCountBad(int postno) {
        throw new NotImplementedException(AppConstants.MSG_NOT_IMPLEMENTED);
    }
}
