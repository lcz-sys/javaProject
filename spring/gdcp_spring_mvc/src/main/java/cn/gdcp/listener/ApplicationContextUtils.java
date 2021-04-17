package cn.gdcp.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

public class ApplicationContextUtils {

    public static ApplicationContext getApplicationContext(ServletContext servletContext){
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
