package api;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html; charset=utf-8");
        // 1.先获取到用户名和密码，并进行简单校验
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name == null || "".equals(name)
             || password == null || "".equals(password)) {
            String html = HtmlGenerator.getMessagePage("用户名或密码为空", "login.html");
            resp.getWriter().write(html);
            return;
        }
        // 2.数据库中查找，看用户是否存在  // 3.对比密码是否匹配
        UserDao userDao = new UserDao();
        User user = userDao.selectByName(name);
        if (user == null || !password.equals(user.getPassword())) {
            // 用户名不存在，提示错误
            String html = HtmlGenerator.getMessagePage("用户名或密码错误", "login.html");
            resp.getWriter().write(html);
            return;
        }

        // 4.匹配成功则认为登录成功，创建一个 Session
        HttpSession httpSession = req.getSession(true);   // true 表示，若存在会话则返回该会话，否则新建一个会话。
        httpSession.setAttribute("user",user);

        // 5.返回一个登录成功的提示页面
        String html = HtmlGenerator.getMessagePage("登录成功", "article");
        resp.getWriter().write(html);
    }
}

