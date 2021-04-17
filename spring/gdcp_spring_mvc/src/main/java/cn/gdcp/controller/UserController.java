package cn.gdcp.controller;

import cn.gdcp.domain.User;
import cn.gdcp.domain.VO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/show15")
    @ResponseBody
    public void show15(String username, MultipartFile[] uploadFile) throws IOException {
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\JavaProject\\upload\\" + originalFilename));
        }
    }

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/show14")
    @ResponseBody
    public void show14(@CookieValue("JSESSIONID") String jsessionId) {
        System.out.println(jsessionId);
    }

    @RequestMapping("/show13")
    @ResponseBody
    public void show11(@RequestHeader("User-Agent") String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping("/show12")
    @ResponseBody
    public void show12(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        System.out.println(req);
        System.out.println(resp);
        System.out.println(session);
    }

    @RequestMapping("/show11")
    @ResponseBody
    public void show11(Date date) {
        System.out.println(date);
    }

    @RequestMapping("/show10/{username}")
    @ResponseBody
    public void show10(@PathVariable("username") String username) {
        System.out.println(username);
    }

    @RequestMapping("/show9")
    @ResponseBody
    public void show9(@RequestParam(value = "name", required = false, defaultValue = "gdcp") String username, int age) {
        System.out.println(username + "   " + age);
    }

    @RequestMapping(value = "/show8", method = RequestMethod.POST)
    public void show8(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping("/ajax")
    public String ajax() {
        return "ajax";
    }

    @RequestMapping("/show7")
    @ResponseBody
    public void show7(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping("/show6")
    @ResponseBody
    public void show6(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping("/show5")
    @ResponseBody
    public void show5(User user) {
        System.out.println(user);
    }

    @RequestMapping("/show4")
    @ResponseBody
    public void show4(String name, String addr) {
        System.out.println(name);
        System.out.println(addr);
    }

    @RequestMapping("/show3")
    @ResponseBody
    public User show3() throws JsonProcessingException {
        User user = new User();

        user.setName("zhangsan");
        user.setAddr("beijing");

        return user;
    }

    @RequestMapping("/show2")
    @ResponseBody
    public String show2() throws JsonProcessingException {
        User user = new User();

        user.setName("zhangsan");
        user.setAddr("beijing");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);

        return json;
    }

    @RequestMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sname", "GDCP的");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save() {
        return "success";
    }

    @RequestMapping("/index")
    public String index() {
        return "redirect:/index.jsp";
    }
}
