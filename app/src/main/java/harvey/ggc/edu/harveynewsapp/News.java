package harvey.ggc.edu.harveynewsapp;

public class News {
    private String mArticleName;
    private String mUrl;
    private String mDateArticle;
    private String mArticleAuthor;

    public News(String articleName, String articleAuthor, String dateArticle, String url) {
        mArticleName = articleName;
        mUrl = url;
        mDateArticle = dateArticle;
        mArticleAuthor = articleAuthor;
    }
    public String getArticleName(){
       return mArticleName;
    }

    public String getUrl(){
        return mUrl;
    }
    public String getDateArticle(){
        return mDateArticle;
    }

    public String getArticleAuthor(){
        return mArticleAuthor;
    }

}