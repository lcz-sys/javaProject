package cn.gdcp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        String uri = request.getRequestURI();
        if (uri.contains("images") || uri.contains("css") || uri.contains("js") || uri.contains("lib") || uri.contains("login") || uri.contains("logout")) {
            return true;//不拦截路径
        }

        HttpSession session = request.getSession();
        Object admin = session.getAttribute("admin");
        if(admin !=null && !admin.toString().trim().isEmpty()){
            return true;//验证通过
        }
        response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
        return false;//其他情况一律拦截
    }

}
