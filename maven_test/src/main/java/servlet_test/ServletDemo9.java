package servlet_test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

// 写一个页面，通过这个页面来记录当前用户访问了几次
public class ServletDemo9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.先获取Session.如果用户曾经没有访问过，此时将创建新的session
        //    如果用户已经访问过了，就获取到曾经的Session

        // 新用户访问：
        // 这个操作会自动生成一个sessionId, 同时创建一个httpSession 对象
        // 把这个键值对放到内置的hash表中，同时把sessionId写回到到浏览器中
        // Cookie中
        // 老用户访问：
        // 根据请求中Cookie里的sessionId,在hash表中查，找到对应的session对象
        HttpSession httpSession = req.getSession(true);
        // 2.判断是否是新用户
        Integer count = 1;
        if(httpSession.isNew()) {   // 新用户返回true,老用户返回false
            // 新用户
            // 把count值写入到session对象中
            // httpSession也可以当成一个hash表
            httpSession.setAttribute("count", count);
        } else {
            // 老用户
            // 从 httpSession 中读取到 count 值
            count =  (Integer) httpSession.getAttribute("count");
            count = count + 1;
            // count 自增完成后, 要重新写入 session
            httpSession.setAttribute("count", count);
        }
        // 3.返回响应页面
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("count: " + count);
        writer.write("</html>");

    }
}
