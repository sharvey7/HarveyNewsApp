package harvey.ggc.edu.harveynewsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    public static final String LOG_TAG = MainActivity.class.getName();
    private static final int NEWS_LOADER_ID = 1;
    private NewsAdapter mAdapter;
    private static final String USGS_REQUEST_URL = "https://content.guardianapis.com/search?api-key=8790b10f-4581-4c81-9927-38d186e5e689&show-tags=contributor";
    //old URL =         "http://content.guardianapis.com/search?q=debates&api-key=test&show-tags=contributor";
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView newsListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsListView.setEmptyView(mEmptyStateTextView);

        mAdapter = new NewsAdapter(this, new ArrayList<News>());

        newsListView.setAdapter(mAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                                    News currentNews = mAdapter.getItem(position);
                                                    Uri newsUri = Uri.parse(currentNews.getUrl());
                                                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                                                    startActivity(websiteIntent);
                                                }
                                            }
        );

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
                mEmptyStateTextView.setText(R.string.connection);
        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {

        mEmptyStateTextView.setText(R.string.empty);
        mAdapter.clear();
        if (news != null && !news.isEmpty()) {
            mAdapter.addAll(news);

        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> Loader) {
        mAdapter.clear();
    }
}