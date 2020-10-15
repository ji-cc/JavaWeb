package servlet_test;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

//处理文件上传的类前面必须要加 MultipartConfig 这个注解，提示Servlet这个类要处理文件上传操作
@MultipartConfig
public class ServletDemo10 extends HttpServlet {
    @Override
    // 刚才html文件中是以post方法提交的，所以现在使用doPost方法
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 收到图片之后，直接把图片保存到指定目录中
        // 先把路径准备好
        String basePath = "F:/编程/bite资料/javaweb/practice/JavaWeb/maven_test/src/main/java/servlet_test2";
        Part image = req.getPart("image");
        // 这个方法就能得到上传的文件名
        String path = basePath + image.getSubmittedFileName();
        image.write(path);

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("图片上传成功！");

    }
}
