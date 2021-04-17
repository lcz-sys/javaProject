package cn.gdcp.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle)throws Exception{
        //指定拦截路径
        String uri = request.getRequestURI();
        if (uri.contains("customer/cart") || uri.contains("customer/order") || uri.contains("customer/personal")) {
            Object user=request.getSession().getAttribute("user");
            if (user == null ) {
                response.sendRedirect(request.getContextPath()+"/customer/login");
                return false;
            }
        }
        //默认放过
        return true;
    }

}
