package api;

import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html; charset=utf-8");
        // 1.验证用户的登录状态，如果未登录，肯定不能删除
        HttpSession httpSession = req.getSession(false);   // 获取到登录状态
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("您尚未登录！","login.html");
            resp.getWriter().write(html);
            return;
        }
        // 2.读取请求内容，获取到要删除的文章 id

        // 3.根据文章 id 查找到改文章的作者，当前用户如果是作者，才能删除，否则删除失败

        // 4.真正执行数据库的删除操作

        // 5.返回一个“删除成功”页面


    }
}
