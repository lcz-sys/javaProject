package cn.gdcp.controller;

import cn.gdcp.domain.Role;
import cn.gdcp.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Resource(name = "roleService")
    private RoleService roleService;

    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/roleList";
    }

    @RequestMapping("/roleList")
    public ModelAndView showRoleList(){

        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("role-list");

        return modelAndView;

    }
}
