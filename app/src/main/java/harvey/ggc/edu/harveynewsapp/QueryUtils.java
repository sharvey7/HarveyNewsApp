package harvey.ggc.edu.harveynewsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QueryUtils {

    private static final String SAMPLE_JSON_RESPONSE = "\"response\":{\"status\":\"ok\",\"userTier\":\"developer\",\"total\":2062826,\"startIndex\":1,\"pageSize\":10,\"currentPage\":1,\"pages\":206283,\"orderBy\":\"newest\",\"results\":[{\"id\":\"media/2018/sep/24/michelle-guthrie-considering-legal-options-after-being-sacked-by-abc-board\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2018-09-24T03:00:37Z\",\"webTitle\":\"Michelle Guthrie 'considering legal options' after being sacked by ABC board\",\"webUrl\":\"https://www.theguardian.com/media/2018/sep/24/michelle-guthrie-considering-legal-options-after-being-sacked-by-abc-board\",\"apiUrl\":\"https://content.guardianapis.com/media/2018/sep/24/michelle-guthrie-considering-legal-options-after-being-sacked-by-abc-board\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"culture/2018/sep/24/why-i-refused-to-judge-the-horne-prize\",\"type\":\"article\",\"sectionId\":\"culture\",\"sectionName\":\"Culture\",\"webPublicationDate\":\"2018-09-24T02:15:57Z\",\"webTitle\":\"Why I refused to judge the Horne prize over 'restrictive' rule change | David Marr\",\"webUrl\":\"https://www.theguardian.com/culture/2018/sep/24/why-i-refused-to-judge-the-horne-prize\",\"apiUrl\":\"https://content.guardianapis.com/culture/2018/sep/24/why-i-refused-to-judge-the-horne-prize\",\"isHosted\":false,\"pillarId\":\"pillar/arts\",\"pillarName\":\"Arts\"},{\"id\":\"us-news/2018/sep/23/michelle-obama-las-vegas-midterms-when-we-all-vote-registration\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2018-09-24T02:06:00Z\",\"webTitle\":\"'I am frustrated too': Michelle Obama urges voters to register ahead of midterms\",\"webUrl\":\"https://www.theguardian.com/us-news/2018/sep/23/michelle-obama-las-vegas-midterms-when-we-all-vote-registration\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2018/sep/23/michelle-obama-las-vegas-midterms-when-we-all-vote-registration\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"australia-news/2018/sep/24/whitsundays-shark-attacks-occurred-in-swimming-no-go-zone-conservationists-say\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-09-24T02:04:31Z\",\"webTitle\":\"Whitsundays shark attacks occurred in swimming 'no-go zone', conservationists say\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/sep/24/whitsundays-shark-attacks-occurred-in-swimming-no-go-zone-conservationists-say\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/sep/24/whitsundays-shark-attacks-occurred-in-swimming-no-go-zone-conservationists-say\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"us-news/2018/sep/24/brett-kavanaugh-second-allegation-sexual-misconduct-deborah-ramirez\",\"type\":\"article\",\"sectionId\":\"us-news\",\"sectionName\":\"US news\",\"webPublicationDate\":\"2018-09-24T01:28:39Z\",\"webTitle\":\"Brett Kavanaugh faces second allegation of sexual misconduct\",\"webUrl\":\"https://www.theguardian.com/us-news/2018/sep/24/brett-kavanaugh-second-allegation-sexual-misconduct-deborah-ramirez\",\"apiUrl\":\"https://content.guardianapis.com/us-news/2018/sep/24/brett-kavanaugh-second-allegation-sexual-misconduct-deborah-ramirez\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"media/2018/sep/24/michelle-guthrie-abc-managing-director-board\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2018-09-24T00:35:21Z\",\"webTitle\":\"Michelle Guthrie: ABC managing director sacked by board\",\"webUrl\":\"https://www.theguardian.com/media/2018/sep/24/michelle-guthrie-abc-managing-director-board\",\"apiUrl\":\"https://content.guardianapis.com/media/2018/sep/24/michelle-guthrie-abc-managing-director-board\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/sep/24/pollution-pushes-mongolias-herders-to-reconsider-city-life\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-09-24T00:29:59Z\",\"webTitle\":\"Pollution pushes Mongolia's herders to reconsider city life\",\"webUrl\":\"https://www.theguardian.com/world/2018/sep/24/pollution-pushes-mongolias-herders-to-reconsider-city-life\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/sep/24/pollution-pushes-mongolias-herders-to-reconsider-city-life\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/sep/23/brexit-corbyn-under-pressure-from-all-sides-over-peoples-vote\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-09-23T23:50:06Z\",\"webTitle\":\"Corbyn under pressure over people's vote as party agrees to keep option on table\",\"webUrl\":\"https://www.theguardian.com/politics/2018/sep/23/brexit-corbyn-under-pressure-from-all-sides-over-peoples-vote\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/sep/23/brexit-corbyn-under-pressure-from-all-sides-over-peoples-vote\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"fashion/2018/sep/24/green-carpet-awards-sprinkle-stardust-on-milan-fashion-week\",\"type\":\"article\",\"sectionId\":\"fashion\",\"sectionName\":\"Fashion\",\"webPublicationDate\":\"2018-09-23T23:37:37Z\",\"webTitle\":\"Green Carpet awards sprinkle stardust on Milan fashion week\",\"webUrl\":\"https://www.theguardian.com/fashion/2018/sep/24/green-carpet-awards-sprinkle-stardust-on-milan-fashion-week\",\"apiUrl\":\"https://content.guardianapis.com/fashion/2018/sep/24/green-carpet-awards-sprinkle-stardust-on-milan-fashion-week\",\"isHosted\":false,\"pillarId\":\"pillar/lifestyle\",\"pillarName\":\"Lifestyle\"},{\"id\":\"sport/2018/sep/23/tiger-woods-tears-tour-championship\",\"type\":\"article\",\"sectionId\":\"sport\",\"sectionName\":\"Sport\",\"webPublicationDate\":\"2018-09-23T23:09:40Z\",\"webTitle\":\"Tiger Woods holds back tears before claiming Tour Championship\",\"webUrl\":\"https://www.theguardian.com/sport/2018/sep/23/tiger-woods-tears-tour-championship\",\"apiUrl\":\"https://content.guardianapis.com/sport/2018/sep/23/tiger-woods-tears-tour-championship\",\"isHosted\":false,\"pillarId\":\"pillar/sport\",\"pillarName\":\"Sport\"}]}}";


    private QueryUtils() {

    }

    public static ArrayList<News> extractNews() {

        ArrayList<News> news = new ArrayList<>();

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
