package cn.gdcp.web;

import cn.gdcp.listener.ApplicationContextUtils;
import cn.gdcp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*ServletContext servletContext = request.getServletContext();

        ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");*/

//        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext(request.getServletContext());

        ServletContext servletContext = this.getServletContext();

        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.save();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
