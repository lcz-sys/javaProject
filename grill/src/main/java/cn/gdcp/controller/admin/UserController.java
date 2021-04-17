package cn.gdcp.controller.admin;

import cn.gdcp.domain.User;
import cn.gdcp.service.UserService;
import cn.gdcp.utils.CreateUsernameUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    /*跳转会员界面
     * 按时间和用户名搜索管理员
     * */
    @GetMapping("/userList")
    public ModelAndView goUserList(int pageNum,
                                   @RequestParam(required = false) String username,
                                   @RequestParam(required = false) String start_time,
                                   @RequestParam(required = false) String end_time) {
        PageHelper.startPage(pageNum, 6);
        ModelAndView modelAndView = new ModelAndView();

        List<User> userList = null;
        if (username != null || start_time != null || end_time != null) {
            userList = userService.searchUsers(username, start_time, end_time);
            modelAndView.addObject("username", username);
            modelAndView.addObject("start_time", start_time);
            modelAndView.addObject("end_time", end_time);
        } else {
            userList = userService.findAllUsers();
        }

        PageInfo pageInfo = new PageInfo(userList);
//        System.out.println(pageInfo);
        modelAndView.setViewName("admin/member-list");
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }

    //添加用户
    @RequestMapping("/add")
    public String addUser(User user) {
        return "admin/member-add";
    }

    //修改页面回显用户信息
    @GetMapping("/edit/{id}")
    public ModelAndView showEditUser(@PathVariable("id") int id) {

        User user = userService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/member-edit");

        return modelAndView;
    }

    //回显用户信息
    @GetMapping("/show/{id}")
    public ModelAndView showUser(@PathVariable("id") int id) {

        User user = userService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/member-show");

        return modelAndView;
    }

    //跳转修改用户密码界面
    @GetMapping("/editPass/{id}")
    public ModelAndView showPassUI(@PathVariable("id") int id) {

        User user = userService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("admin/member-password");

        return modelAndView;
    }

    //保存修改的密码
    @PostMapping("/savePass")
    @ResponseBody
    public String savePass(@Param("id") int id, @Param("newPass") String newPass, @Param("oldPass") String oldPass) {
        boolean flag = userService.editPass(id, newPass, oldPass);

        if (flag) {
            return "true";
        } else {
            return "false";
        }
    }

    //修改用户
    @PostMapping("/update")
    @ResponseBody
    public String editUser(User user) {
//        System.out.println(user);
        boolean flag = userService.updateUser(user);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //保存用户
    @PostMapping("/save")
    @ResponseBody
    public String save(User user) {
        user.setCreate_time(new Date());
        int num = (int) (Math.random() * 10);
        String username = num <= 5 ? CreateUsernameUtil.getRandomJianHan(num) : CreateUsernameUtil.getStringRandom(num);
        user.setUsername(username);
//        System.out.println(user);
        boolean flag = userService.addUser(user);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //删除用户
    @GetMapping("/del")
    @ResponseBody
    public String del(int id) {
        int flag = userService.deleteUser(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    //删除选中用户
    @PostMapping("/delAll")
    @ResponseBody
    public String delAll(@RequestParam(value = "ids[]") int[] ids) {
        int flag = userService.deleteSelectUser(ids);
        if (flag == ids.length) {
            return "true";
        }
        return "false";
    }
}
