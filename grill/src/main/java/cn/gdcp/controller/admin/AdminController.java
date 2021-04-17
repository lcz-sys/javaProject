package cn.gdcp.controller.admin;

import cn.gdcp.domain.Admin;
import cn.gdcp.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource(name = "adminService")
    private AdminService adminService;

    /*后台入口*/

    @RequestMapping("/main")
    public String main() {
        return "admin/main";
    }

    @GetMapping("/login")
    public String index() {
        return "admin/login";
    }

    @PostMapping(value = "/login")
    public String login(Admin admin, HttpSession session, HttpServletRequest req) {
        Admin adminsLogin = adminService.getByUsernameAndPassword(admin.getUsername(), admin.getPassword());
        if (adminsLogin == null) {
            req.setAttribute("msg", "用户名或密码错误");
            return "admin/login";
        } else {
            session.setAttribute("admin", adminsLogin);
            return "redirect:/admin/main";
        }

    }

    //回显用户信息
    @GetMapping("/show/{id}")
    public ModelAndView showUser(@PathVariable("id") int id) {

        Admin admin = adminService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("admin/admin-show");

        return modelAndView;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest req) {
        req.removeAttribute("msg");
        session.removeAttribute("admin");
        return "redirect:/admin/index";
    }

    /*后台管理员页面*/

    /*跳转管理员界面
     * 按时间和用户名搜索管理员
     * */
    @GetMapping("/adminList")
    public ModelAndView goAdminList(int pageNum,
                                    @RequestParam(required = false) String username,
                                    @RequestParam(required = false) String start_time,
                                    @RequestParam(required = false) String end_time) {
        PageHelper.startPage(pageNum, 6);
        ModelAndView modelAndView = new ModelAndView();

        List<Admin> adminList = null;
        if (username != null || start_time != null || end_time != null) {
            adminList = adminService.searchAdmins(username, start_time, end_time);
            modelAndView.addObject("username", username);
            modelAndView.addObject("start_time", start_time);
            modelAndView.addObject("end_time", end_time);
        } else {
            adminList = adminService.findAllAdmins();
        }

        PageInfo pageInfo = new PageInfo(adminList);
        System.out.println(pageInfo);
        modelAndView.setViewName("admin/admin-list");
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }

    //添加管理员
    @RequestMapping("/add")
    public String addAdmin(Admin admin) {
        return "admin/admin-add";
    }

    //修改页面回显管理员信息
    @GetMapping("/edit/{id}")
    public ModelAndView showEditAdmin(@PathVariable("id") int id) {

        Admin admin = adminService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("admin/admin-edit");

        return modelAndView;
    }

    //修改管理员
    @PostMapping("/update")
    @ResponseBody
    public String editAdmin(Admin admin) {
//        System.out.println(admin);
        boolean flag = adminService.updateAdmin(admin);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //保存管理员
    @PostMapping("/save")
    @ResponseBody
    public String save(Admin admin) {
        admin.setCreate_time(new Date());
//        System.out.println(admin);
        boolean flag = adminService.addAdmin(admin);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //删除管理员
    @GetMapping("/del")
    @ResponseBody
    public String del(int id) {
        int flag = adminService.deleteAdmin(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    //删除选中管理员
    @PostMapping("/delAll")
    @ResponseBody
    public String delAll(@RequestParam(value = "ids[]") int[] ids) {
        int flag = adminService.deleteSelectAdmin(ids);
        if (flag == ids.length) {
            return "true";
        }
        return "false";
    }

}
