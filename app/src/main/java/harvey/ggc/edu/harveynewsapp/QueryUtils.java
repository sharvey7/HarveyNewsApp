package harvey.ggc.edu.harveynewsapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    private static final String LOGTAG = QueryUtils.class.getName();

    private static final String TAG = QueryUtils.class.getSimpleName(); //maybe

    private QueryUtils() {

    }

    public static List<News> fetchNewsData(String requestUrl){
        URL url = createUrl(requestUrl);

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        }catch (IOException e) {
            Log.e(LOGTAG, "Problem making the HTTP request", e);
        }
            List<News> news = extractFeatureFromJson(jsonResponse);
            return news;
    }

    private static URL createUrl(String stringUrl){
            URL url = null;
            try {
                url = new URL(stringUrl);
            }catch (MalformedURLException e){

            }
            return url;
        }

        public static String makeHttpRequest(URL url) throws IOException{
            String jsonResponse = "";
            if(url == null) {
                return jsonResponse;
            }

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(15000);
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOGTAG, "Error response code:" + urlConnection.getResponseCode());
                }
            }catch(IOException e) {
                Log.e(LOGTAG, "Problem retreiving the news JSON result!");
            }
            finally{
                if(urlConnection != null){
                    urlConnection.disconnect();
                }
                if(inputStream != null){
                    inputStream.close();
                }
            } return jsonResponse;
        }
     private static String readFromStream(InputStream inputStream) throws IOException{
            StringBuilder output = new StringBuilder();
            if(inputStream != null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while(line != null){
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }

        private static List<News> extractFeatureFromJson(String jsonResponse){
             String name;
             String author;
             String date;
             String url;

            if(TextUtils.isEmpty(jsonResponse)){
                return null;
            }
            List<News> news = new ArrayList<>();
            try{

                JSONObject baseJSONResponse = new JSONObject(jsonResponse);

                JSONObject baseJSONResponseResult = baseJSONResponse.getJSONObject("response");
                JSONArray newsArray = baseJSONResponseResult.getJSONArray("results");

                for(int i = 0; i< newsArray.length(); i++){
                    JSONObject currentNews = newsArray.getJSONObject(i);
                    JSONObject properties = currentNews.getJSONObject("properties");
                     name = properties.getString("Name of article");
                     author = properties.getString("Author's name");
                     date = properties.getString("Section of article");
                     url = properties.getString("url");

                    //String url = properties.getString("url");

                    News news1 = new News(name, author, date, url);
                    news.add(news1);
                }
            }catch(JSONException e){
                Log.e("QueryUtils", "Problem parsing the news JSON results", e);
            }
            return news;
        }

    }
