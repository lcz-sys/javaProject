package cn.gdcp.controller.admin;

import cn.gdcp.domain.Type;
import cn.gdcp.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Resource(name = "typeService")
    private TypeService typeService;

    @GetMapping("/typeList")
    public ModelAndView goTypeList(int pageNum) {
        PageHelper.startPage(pageNum, 6);
        ModelAndView modelAndView = new ModelAndView();

        List<Type> typeList = typeService.findAll();

        PageInfo pageInfo = new PageInfo(typeList);
//        System.out.println(pageInfo);
        modelAndView.setViewName("admin/category");
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }

    //修改页面回显类目信息
    @GetMapping("/edit/{id}")
    public ModelAndView showEditType(@PathVariable("id") int id) {

        Type type = typeService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("type", type);
        modelAndView.setViewName("admin/cate-edit");

        return modelAndView;
    }

    //修改类目
    @PostMapping("/update")
    @ResponseBody
    public String editType(Type type) {
//        System.out.println(type);
        boolean flag = typeService.update(type);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //保存类目
    @PostMapping("/save")
    public String save(@RequestParam(value = "name",required = false) String name,
                       @RequestParam(value = "num",required = false) String num) {
//        System.out.println("111111111");
        if(name.equals("") && num.equals("")){
//            System.out.println("22222222222");
            return "redirect:typeList?pageNum=1";
        }
//        System.out.println(name+" 3333333  "+num);
        Type type = new Type();
        type.setNum(Integer.parseInt(num));
        type.setName(name);

        typeService.typeAdd(type);
        return "redirect:typeList?pageNum=1";
    }

    //删除类目
    @GetMapping("/del")
    @ResponseBody
    public String del(int id) {
        int flag = typeService.deleteType(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    //删除选中类目
    @PostMapping("/delAll")
    @ResponseBody
    public String delAll(@RequestParam(value = "ids[]") int[] ids) {
        int flag = typeService.deleteSelectType(ids);
        if (flag == ids.length) {
            return "true";
        }
        return "false";
    }
}
