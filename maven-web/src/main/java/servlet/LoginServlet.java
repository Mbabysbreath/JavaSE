package servlet;

/**
 * @author zhaomin
 * @date 2020/2/26 14:22
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理login.html用户登录请求（post方式提交，url为/login）
 * 注意点：servlet绑定的url，一定要/开头
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //只是对请求设置编码，如果是url中的请求参数，需要自己处理
        req.setCharacterEncoding("UTF-8");
        //对响应设置编码：响应体
        resp.setCharacterEncoding("UTF-8");
        //设置Content-Type字段，浏览器根据Content-Type类型进行渲染或其他处理
        resp.setContentType("text/html;charset=UTF-8");
        //处理逻辑
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.printf("username=%s,password=%s\n", username, password);
        //处理响应
        PrintWriter pw=resp.getWriter();
        pw.println("<p>用户名：" + username + "密码为：" + password + "</p>");
        pw.flush();
      //  super.service(req, resp);
    }
}
