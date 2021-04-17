package cn.gdcp.controller.admin;

import cn.gdcp.domain.Good;
import cn.gdcp.domain.Type;
import cn.gdcp.service.GoodService;
import cn.gdcp.service.TypeService;
import cn.gdcp.utils.UploadUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Resource(name = "goodService")
    private GoodService goodService;

    @Resource(name = "typeService")
    private TypeService typeService;

    /*跳转商品管理界面
     * 按商品名搜索商品
     * */
    @GetMapping("/goodList")
    public ModelAndView goGoodList(int pageNum,
                                    @RequestParam(required = false) String name) {
        PageHelper.startPage(pageNum, 6);
        ModelAndView modelAndView = new ModelAndView();

        List<Good> goodList = null;
        if (name != null) {
            goodList = goodService.searchGoods(name);
            modelAndView.addObject("name", name);
        } else {
            goodList = goodService.findAllGoods();
        }

        PageInfo pageInfo = new PageInfo(goodList);
//        System.out.println(pageInfo);
        modelAndView.setViewName("admin/good-list");
        modelAndView.addObject("pageInfo", pageInfo);

        return modelAndView;
    }

    //跳转添加商品页面
    @RequestMapping("/add")
    public String addGood(Good good, HttpServletRequest request) {
        List<Type> typeList = typeService.findAll();
        request.setAttribute("typeList",typeList);
        return "admin/good-add";
    }

    //修改页面回显管理员信息
    @GetMapping("/edit/{id}")
    public ModelAndView showEditGood(@PathVariable("id") int id) {
        List<Type> typeList = typeService.findAll();
        Good good = goodService.get(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("good", good);
        modelAndView.addObject("typeList", typeList);
        modelAndView.setViewName("admin/good-edit");

        return modelAndView;
    }

    //修改商品
    @PostMapping("/update")
    @ResponseBody
    public String editGood(Good good) {
//        System.out.println(good);
        boolean flag = goodService.updateGood(good);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //封面上传
    @PostMapping(value = "/upload",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String importFile(@RequestParam("file") MultipartFile file) {
        JSONObject object = new JSONObject();
        String fileName = null;
        String oldName = null;
        try {
            oldName = file.getOriginalFilename();
            fileName = UploadUtil.upload(file);
            object.put("oldName",oldName);
            object.put("fileName", fileName);
            object.put("code", "success");
            object.put("message", "文件上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            object.put("code", "fail");
            object.put("message", "文件上传失败");
        }

//        System.out.println(object);

        return object.toJSONString();
    }

    //富文本编辑时上传照片
    @PostMapping(value = "/uploadPhotos",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String uploadPhotos(@RequestParam("file") MultipartFile file) {
        JSONObject object = new JSONObject();
        String name = null;
        try {
            name = UploadUtil.upload(file);
//            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        object.put("msg", "上传图片成功");
        object.put("code", 0);
        JSONObject data = new JSONObject();
        data.put("src", name);
        data.put("title", file.getOriginalFilename());
        object.put("data", data);
//        System.out.println(object);
        return object.toJSONString();
    }

    //保存商品
    @PostMapping("/save")
    @ResponseBody
    public String save(Good good) {
//        System.out.println(good);
        boolean flag = goodService.addGood(good);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //删除商品
    @GetMapping("/del")
    @ResponseBody
    public String del(int id) {
        int flag = goodService.deleteGood(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    //删除选中商品
    @PostMapping("/delAll")
    @ResponseBody
    public String delAll(@RequestParam(value = "ids[]") int[] ids) {
        int flag = goodService.deleteSelectGood(ids);
        if (flag == ids.length) {
            return "true";
        }
        return "false";

    }

    //推送商品
    @GetMapping("/up")
    @ResponseBody
    public String up(int id) {
        int flag = goodService.upGood(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    //下调商品
    @GetMapping("/down")
    @ResponseBody
    public String down(int id) {
        int flag = goodService.downGood(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

}
