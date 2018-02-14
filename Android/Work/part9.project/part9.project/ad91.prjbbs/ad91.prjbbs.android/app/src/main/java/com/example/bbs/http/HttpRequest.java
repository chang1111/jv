package com.example.bbs.http;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class HttpRequest {

    public static enum Method {
        POST, PUT, DELETE, GET;
    }

    public static enum MineType {
        VALUES, JSONObject, JSONArray,
    }

    private URL url = null;
    private HttpURLConnection connection = null;
    private OutputStream outputStream = null;
    private Map<String, String> params = new HashMap<String, String>();

    public HttpRequest() {
    }

    public HttpRequest(String url) throws IOException {
        this.url = new URL(url);
        connection = (HttpURLConnection) this.url.openConnection();

        connection.setRequestProperty("charset", "utf-8");
    }

    public int get() throws IOException {
        connection.setUseCaches(false);
        return this.send();
    }

    public int post() throws IOException {
        connection.setDoInput(true);
        connection.setRequestMethod(Method.POST.toString());
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        outputStream = connection.getOutputStream();
        return this.send();
    }

    public int post(String data) throws IOException {
        connection.setDoInput(true);
        connection.setRequestMethod(Method.POST.toString());
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        outputStream = connection.getOutputStream();
        this.sendData(data);
        return this.send();
    }

    public int put(String data) throws IOException {
        connection.setDoInput(true);
        connection.setRequestMethod(Method.PUT.toString());
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        outputStream = connection.getOutputStream();
        this.sendData(data);
        return this.send();
    }

    public int put() throws IOException {
        connection.setDoInput(true);
        connection.setRequestMethod(Method.PUT.toString());
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        outputStream = connection.getOutputStream();
        return this.send();
    }


    public void configPostType(MineType mineType ) {

        switch (mineType) {
            case JSONArray:
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept"      , "application/json");
                break;
            case JSONObject:
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("Accept"      , "application/json");
                break;
            case VALUES:
                break;
            default:
                break;
        }
    }

    public HttpRequest addHeader(String key, String value) {
        connection.setRequestProperty(key, value);
        return this;
    }

    public HttpRequest addBody(String key, String value) {
        this.params.put(key, value);
        return this;
    }

    public JSONObject getJSONObjectResponse() throws JSONException, IOException {
        return new JSONObject(getStringResponse());
    }

    public JSONArray getJSONArrayResponse() throws JSONException, IOException {
        return new JSONArray(getStringResponse());
    }

    public String getStringResponse() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();

        for (String line; (line = br.readLine()) != null; )
            response.append(line + "\n");

        String string= response.toString();

        return string.substring(0, string.length() - 1);
    }

    public byte[] getBytesResponse() throws IOException {
        byte[] buffer = new byte[8192];
        InputStream is = connection.getInputStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        for (int bytesRead; (bytesRead = is.read(buffer)) >= 0; )
            output.write(buffer, 0, bytesRead);
        return output.toByteArray();
    }

    public void close() {
        if (null != connection)
            connection.disconnect();
    }

    private int send() throws IOException {
        int httpStatusCode = HttpURLConnection.HTTP_BAD_REQUEST;

        if (!this.params.isEmpty()) {
            this.sendData();
        }
        httpStatusCode = connection.getResponseCode();

        return httpStatusCode;
    }

    private void sendData() throws IOException {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append((result.length() > 0 ? "&" : "") + entry.getKey() + "=" + entry.getValue());//appends: key=value (for first param) OR &key=value(second and more)
        }
        sendData(result.toString());
    }

    private HttpRequest sendData(String query) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
        writer.write(query);
        writer.close();
        return this;
    }
}
