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
    private static final String SAMPLE_JSON_RESPONSE = "\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":2062826,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":206283,\"orderBy\":\"newest\",\"results\":[{\"id\":\"media/2018/sep/24/michelle-guthrie-considering-legal-options-after-being-sacked-by-abc-board\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2018-09-24T03:00:37Z\",\"webTitle\":\"Michelle Guthrie 'considering legal options' after being sacked by ABC board\",\"webUrl\":\"https://www.theguardian.com/media/2018/sep/24/michelle-guthrie-considering-legal-options-after-being-sacked-by-abc-board\",\"apiUrl\":\"https://content.guardianapis.com/media/2018/sep/24/michelle-guthrie-considering-legal-options-after-being-sacked-by-abc-board\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"culture/2018/sep/24/why-i-refused-to-judge-the-horne-prize\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-09-24T02:15:57Z\",\"webTitle\":\"Why I refused to judge the Horne prize over 'restrictive' rule change | David Marr\",\"webUrl\":\"https://www.theguardian.com/culture/2018/sep/24/why-i-refused-to-judge-the-horne-prize\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/sep/24/why-i-refused-to-judge-the-horne-prize\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"us-news/2018/sep/23/michelle-obama-las-vegas-midterms-when-we-all-vote-registration\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2018-09-24T02:06:00Z\",\"webTitle\":\"'I am frustrated too': Michelle Obama urges voters to register ahead of midterms\",\"webUrl\":\"https://www.theguardian.com/us-news/2018/sep/23/michelle-obama-las-vegas-midterms-when-we-all-vote-registration\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2018/sep/23/michelle-obama-las-vegas-midterms-when-we-all-vote-registration\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"australia-news/2018/sep/24/whitsundays-shark-attacks-occurred-in-swimming-no-go-zone-conservationists-say\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-09-24T02:04:31Z\",\"webTitle\":\"Whitsundays shark attacks occurred in swimming 'no-go zone', conservationists say\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/sep/24/whitsundays-shark-attacks-occurred-in-swimming-no-go-zone-conservationists-say\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/sep/24/whitsundays-shark-attacks-occurred-in-swimming-no-go-zone-conservationists-say\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"us-news/2018/sep/24/brett-kavanaugh-second-allegation-sexual-misconduct-deborah-ramirez\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2018-09-24T01:28:39Z\",\"webTitle\":\"Brett Kavanaugh faces second allegation of sexual misconduct\",\"webUrl\":\"https://www.theguardian.com/us-news/2018/sep/24/brett-kavanaugh-second-allegation-sexual-misconduct-deborah-ramirez\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2018/sep/24/brett-kavanaugh-second-allegation-sexual-misconduct-deborah-ramirez\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"media/2018/sep/24/michelle-guthrie-abc-managing-director-board\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2018-09-24T00:35:21Z\",\"webTitle\":\"Michelle Guthrie: ABC managing director sacked by board\",\"webUrl\":\"https://www.theguardian.com/media/2018/sep/24/michelle-guthrie-abc-managing-director-board\",\"apiUrl\":\"https://content.guardianapis.com/media/2018/sep/24/michelle-guthrie-abc-managing-director-board\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/sep/24/pollution-pushes-mongolias-herders-to-reconsider-city-life\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-09-24T00:29:59Z\",\"webTitle\":\"Pollution pushes Mongolia's herders to reconsider city life\",\"webUrl\":\"https://www.theguardian.com/world/2018/sep/24/pollution-pushes-mongolias-herders-to-reconsider-city-life\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/sep/24/pollution-pushes-mongolias-herders-to-reconsider-city-life\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/sep/23/brexit-corbyn-under-pressure-from-all-sides-over-peoples-vote\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-09-23T23:50:06Z\",\"webTitle\":\"Corbyn under pressure over people's vote as party agrees to keep option on table\",\"webUrl\":\"https://www.theguardian.com/politics/2018/sep/23/brexit-corbyn-under-pressure-from-all-sides-over-peoples-vote\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/sep/23/brexit-corbyn-under-pressure-from-all-sides-over-peoples-vote\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"fashion/2018/sep/24/green-carpet-awards-sprinkle-stardust-on-milan-fashion-week\",\"type\":\"article\",\"sectionId\":\"fashion\",\"sectionName\":\"Fashion\",\"webPublicationDate\":\"2018-09-23T23:37:37Z\",\"webTitle\":\"Green Carpet awards sprinkle stardust on Milan fashion week\",\"webUrl\":\"https://www.theguardian.com/fashion/2018/sep/24/green-carpet-awards-sprinkle-stardust-on-milan-fashion-week\",\"apiUrl\":\"https://content.guardianapis.com/fashion/2018/sep/24/green-carpet-awards-sprinkle-stardust-on-milan-fashion-week\",\"isHosted\":false,\"pillarId\":\"pillar/lifestyle\",\"pillarName\":\"Lifestyle\"},{\"id\":\"sport/2018/sep/23/tiger-woods-tears-tour-championship\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2018-09-23T23:09:40Z\",\"webTitle\":\"Tiger Woods holds back tears before claiming Tour Championship\",\"webUrl\":\"https://www.theguardian.com/sport/2018/sep/23/tiger-woods-tears-tour-championship\",\"apiUrl\":\"https://content.guardianapis.com/sport/2018/sep/23/tiger-woods-tears-tour-championship\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"}]}}";



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

        private static List<News> extractFeatureFromJson(String newsJSON){
            if(TextUtils.isEmpty(newsJSON)){
                return null;
            }
            List<News> news = new ArrayList<>();
            try{

                JSONObject baseJasonResponse = new JSONObject(SAMPLE_JSON_RESPONSE);
                JSONArray newsArray = baseJasonResponse.getJSONArray("up to date");

                for(int i = 0; i< newsArray.length(); i++){
                    JSONObject currentNews = newsArray.getJSONObject(i);
                    JSONObject properties = currentNews.getJSONObject("properties");
                    String name = properties.getString("Name of article");
                    String author = properties.getString("Author's name");
                    String section = properties.getString("Section of article");
                    String url = properties.getString("url");

                    //String url = properties.getString("url");

                    News news1 = new News(name, url, section, author);
                    news.add(news1);
                }
            }catch(JSONException e){
                Log.e("QueryUtils", "Problem parsing the news JSON results", e);
            }
            return news;
        }

    }



//private class EarthquakeAsyncTask extends Asynctask<String, Void, Event>{
//protected Event doInBackground(String...urls){
//if(urls.length <1 || urls[0] == null){
//return null;
//}
//Event result = Utils.fetchEarthquakeDate(urls[0]);
//return result;

//protected void onPostExecute(Event result){
//if(result == null){
//return;
//}
//updateUi(result);
//}