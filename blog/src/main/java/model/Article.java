package model;

public class Article {
    private  int articleId;
    private  String title;
    private  String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
