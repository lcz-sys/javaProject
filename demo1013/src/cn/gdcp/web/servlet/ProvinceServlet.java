package cn.gdcp.web.servlet;

import cn.gdcp.domain.Province;
import cn.gdcp.service.ProvinceService;
import cn.gdcp.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
        String json = service.findAllJson();

//        System.out.println(json);

//        System.out.println(list);

//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);

        response.setContentType("application/json;charset=utf8");

        response.getWriter().write(json);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }
}
