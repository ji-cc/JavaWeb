package model;

public class Article {
    private  int articleId;
    private  String title;
    private String content;
    private int userId;

    // alt + insert:代码自动生成，如生成对象的 set / get 方法，构造函数，toString() 等


    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
