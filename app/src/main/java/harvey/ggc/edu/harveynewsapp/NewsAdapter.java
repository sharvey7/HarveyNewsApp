package harvey.ggc.edu.harveynewsapp;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News>{
    private static final String LOCATION_SEPERATOR = "of";

    private int mColorResourceId;

    public NewsAdapter(Activity context, ArrayList<News> news, int colorResourceId){
        super(context, 0, news);
        mColorResourceId = colorResourceId;
    }
public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false );

            News currentNews = getItem(position);


        }

        return listItemView;
}

}
