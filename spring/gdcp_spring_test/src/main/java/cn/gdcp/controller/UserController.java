package cn.gdcp.controller;

import cn.gdcp.domain.Role;
import cn.gdcp.domain.User;
import cn.gdcp.service.RoleService;
import cn.gdcp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "roleService")
    private RoleService roleService;

    @RequestMapping("/del/{userId}")
    public String save(@PathVariable("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/userList";
    }

    @RequestMapping("/save")
    public String save(User user,Long[] roleId){
        userService.save(user,roleId);
        return "redirect:/user/userList";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");

        return modelAndView;
    }

    @RequestMapping("/userList")
    public ModelAndView showUserList(){
        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = userService.list();
        modelAndView.addObject("userList",userList);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }
}
