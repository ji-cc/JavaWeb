package view;

import model.Article;
import model.User;

import java.util.List;

public class HtmlGenerator {
    // 通过字符串拼接的形式，构造出一个 html 格式的内容来
    // 下面这个代码实现起来非常麻烦 （HTML 嵌入到 Java 代码中）
    // 如果页面简单还好，如果页面复杂，那就非常不好整
    // 这里使用这种写法，代码简单粗暴（不需要引入新的知识点）
    // 实际开发中还有更科学的写法：
    // 1.服务渲染页面，把业务代码嵌入到 HTML  （JSP, PHP）
    // 2.服务器渲染页面，把 HTML 嵌入到业务代码中，不使用字符串拼接的方式，而是使用模板的方式。（FreeMarker）
    // 3.前端渲染页面，通过前后端分离的方式，服务器只是返回简单数据，由前端代码通过 JS 构造页面内容 [主流]
    public static String getMessagePage(String message, String nextUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");

        stringBuilder.append(String.format("<a href=\"%s\"> 点击这里进行跳转 </a>",
                nextUrl));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        return  stringBuilder.toString();
    }

    // 按照字符串拼装的方式，生成html
    public static String getArticleListPage(List<Article> articles, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");
        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        // style 标签内部就是写 CSS 的逻辑
        stringBuilder.append("a{"+
                "color:#333;" +
                "text-decoration:none;"+
                "}");
        stringBuilder.append("</style>");

        stringBuilder.append("</head>");
        stringBuilder.append("<body>");

        stringBuilder.append("<h3> 欢迎您！" + user.getName() + "</h3>");
        // 有一个文章列表，显示每个文章的标题。
        stringBuilder.append("<hr>");

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");

        for (Article article :articles) {
            stringBuilder.append(String.format("<div style=\"width:200px;height:50px\"> <a href= \"article?articleId=%d\"> %s </a></div>",
                    article.getArticleId(), article.getTitle()));
        }
        stringBuilder.append(String.format("<hr>"));
        stringBuilder.append(String.format("<div>当前共有博客 %d 篇</div>", articles.size()));
        return  stringBuilder.toString();
    }
}
