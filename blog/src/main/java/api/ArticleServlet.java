package api;

import model.Article;
import model.ArticleDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        // 1.验证用户是否已经登录了。如果尚未登录，就提示用户要先登录
        HttpSession httpSession = req.getSession(false);   // 直接获取现session
        if (httpSession == null) {
            // 当前是未登录状态
            String html = HtmlGenerator.getMessagePage("请先登录", "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User)httpSession.getAttribute("user");
        // 2.判断请求中是否存在 articleId 参数
        String articleIdStr = req.getParameter("articleId");
        if (articleIdStr == null) {
            // a)没有这个参数就去执行文章列表操作
            getAllArticle(user,resp);
        } else{
            // b)有这个参数就去执行获取文章详情操作
            getOneArticle();
        }


    }
    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        // 1. 查找数据库
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        // 2.构造页面
        String html= HtmlGenerator.getArticleListPage(articles,user);
        resp.getWriter().write(html);


    }

    private void getOneArticle() {

    }
}
