package harvey.ggc.edu.harveynewsapp;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News>{
    private static final String LOCATION_SEPERATOR = "of";


    public NewsAdapter(Activity context, ArrayList<News> news){
        super(context, 0, news);

    }
public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false );

            //the views
            TextView articleName = convertView.findViewById(R.id.names_textview);  //issues here, exception on a null object reference
           // Log.i(" textview an exception", TextView articleName= convertView.findViewById(R.id.names_textview));
            TextView articleAuthor = convertView.findViewById(R.id.author_textview);
            TextView dateArticle = convertView.findViewById(R.id.date_textview);


            //current updated news
            News currentNews = getItem(position);

            articleName.setText(currentNews.getArticleName());
            articleAuthor.setText(currentNews.getArticleAuthor());
            dateArticle.setText(currentNews.getDateArticle());





        }

        return listItemView;
}

}
