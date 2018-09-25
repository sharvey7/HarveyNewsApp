package harvey.ggc.edu.harveynewsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<News> news = QueryUtils.extractNews();

        ListView newsListView = (ListView) findViewById(R.id.list);

        final NewsAdapter adapter = new NewsAdapter(this, news, R.color.colorPrimary);

        newsListView.setAdapter(adapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                                    News currentNews = adapter.getItem(position);
                                                    Uri newsUri = Uri.parse(currentNews.getUrl());
                                                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                                                    startActivity(websiteIntent);
                                                }
                                            }
        );
    }
}
