package cn.gdcp.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionInterceptor  {

    /**
     * 业务异常
     * @param exception
     * @param request
     * @return
     */
    @ExceptionHandler(MyException.class)
    public String exception(MyException exception, HttpServletRequest request){
        request.setAttribute("msg",exception.getMessage());
        return "index/error";
    }

    /**
     * 默认异常
     * @param exception
     * @param request
     * @return
     */
    public String exception(Exception exception,HttpServletRequest request){
        request.setAttribute("msg","系统错误");
        return "index/error";
    }

    /**
     * 自定义异常
     */
    public static class MyException extends Exception{
        public MyException(String msg){
            super(msg);
        }
    }
}
