package harvey.ggc.edu.harveynewsapp;

public class News {
    private String mName;
    private String mUrl;
    private String mSection;
    private String mAuthor;


    public News(String name, String url, String section, String author) {
        mName = name;
        mUrl = url;
        mSection = section;
        mAuthor = author;
    }
    public String getName(){
       return mName;
    }

    public String getUrl(){
        return mUrl;
    }
    public String getSection(){
        return mSection;
    }

    public String getAuthor(){
        return mAuthor;
    }

}