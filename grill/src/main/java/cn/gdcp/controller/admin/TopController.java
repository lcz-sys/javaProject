package cn.gdcp.controller.admin;

import cn.gdcp.domain.Good;
import cn.gdcp.domain.Top;
import cn.gdcp.service.GoodService;
import cn.gdcp.service.TopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/top")
public class TopController {

    @Resource(name = "topService")
    private TopService topService;

    @Resource(name = "goodService")
    private GoodService goodService;

    /*跳转推荐界面*/
    @GetMapping("/topList")
    public ModelAndView goAdminList(int pageNum) {
        PageHelper.startPage(pageNum, 6);
        ModelAndView modelAndView = new ModelAndView();

        List<Top> topList = topService.findAllTop();

        PageInfo pageInfo = new PageInfo(topList);
//        System.out.println(pageInfo);
        modelAndView.setViewName("admin/banner-list");
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }

    //添加推荐
    @RequestMapping("/add")
    public String addAdmin(Top top, HttpServletRequest request) {
        List<Good> goodList = goodService.findAllGoods();
        request.setAttribute("goodList",goodList);
        return "admin/banner-add";
    }

    //保存推荐
    @PostMapping("/save")
    @ResponseBody
    public String save(Top top) {
        System.out.println(top);
        boolean flag = topService.add(top);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //删除推荐
    @GetMapping("/del")
    @ResponseBody
    public String del(int id) {
        int flag = topService.delete(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    //删除选中推荐
    @PostMapping("/delAll")
    @ResponseBody
    public String delAll(@RequestParam(value = "ids[]") int[] ids) {
        int flag = topService.deleteSelectTop(ids);
        if (flag == ids.length) {
            return "true";
        }
        return "false";
    }

}
