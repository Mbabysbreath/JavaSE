package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhaomin
 * @date 2020/2/28 15:28
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //只是对请求设置编码，如果是url中的请求参数，需要自己处理
        req.setCharacterEncoding("UTF-8");
        //对响应设置编码：响应体
        resp.setCharacterEncoding("UTF-8");
        //设置Content-Type字段，浏览器根据Content-Type类型进行渲染或其他处理
        resp.setContentType("text/html;charset=UTF-8");

        //处理响应
        PrintWriter pw=resp.getWriter();
        pw.println( "<p>获取用户信息成功</p>");
        pw.flush();
    }
}
