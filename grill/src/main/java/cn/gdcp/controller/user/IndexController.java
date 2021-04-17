package cn.gdcp.controller.user;

import cn.gdcp.domain.Good;
import cn.gdcp.domain.Type;
import cn.gdcp.service.GoodService;
import cn.gdcp.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Resource(name = "goodService")
    private GoodService goodService;

    @Resource(name = "typeService")
    private TypeService typeService;

    /*商品类目*/
    @GetMapping("/typeN")
    @ResponseBody
    public String type(HttpServletRequest request) {
        List<Type> typeList = typeService.findAll();
//        System.out.println(typeList);
        request.getSession().setAttribute("typeList", typeList);
        return "true";
    }

    /*商品分类（显示商品）*/
    @GetMapping("/type")
    public ModelAndView type(@RequestParam(required = false) int id, int pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNum, 10);

        List<Good> goodList = goodService.getListByType(id);
        PageInfo pageInfo = new PageInfo(goodList);
        Type type = typeService.get(id);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("type",type);
        modelAndView.setViewName("index/goods");

        return modelAndView;
    }

    /*主页显示*/
    @GetMapping("/main")
    public ModelAndView Index() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("flag", 1);
        /*今日推荐*/
        List<Good> todayList = goodService.getListByTop(0, 6);//获取最新六个推荐商品
        modelAndView.addObject("todayList", todayList);
        /*热销排行*/
        List<Good> hotList = goodService.getListOrderSale(0, 10);//获取前十个热销商品
        modelAndView.addObject("hotList", hotList);
        /*类目列表*/
        List<Type> typeList = typeService.findAll();
        List<Map<String, Object>> dataList = new ArrayList<>();
        for (Type type : typeList) {
            Map<String, Object> map = new HashMap<>();
            map.put("type", type);
            map.put("goodList", goodService.getListByType(type.getId(), 1, 15));//获取每个类目前十五个商品
            dataList.add(map);
        }
        modelAndView.addObject("dataList", dataList);
//        System.out.println(dataList);
        modelAndView.setViewName("index/index");

        return modelAndView;
    }

    /*根据商品名搜索*/
    /*商品类型定位*/
    /*商品属性定位*/
    @GetMapping("/good")
    public ModelAndView search(int pageNum,
                               @RequestParam(required = false) String goodName,
                               @RequestParam(required = false,defaultValue = "1") int flag) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNum, 10);

        if(flag == 1){
            List<Good> goodList = goodService.searchGoods(goodName);
            PageInfo pageInfo = new PageInfo(goodList);
            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("goodName", goodName);
            modelAndView.setViewName("index/goods");
        }else if(flag == 2){/*今日推荐*/
            modelAndView.addObject("flag", 2);
            List<Good> goodList = goodService.getListByTop();
            PageInfo pageInfo = new PageInfo(goodList);
            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("goodName", goodName);
            modelAndView.setViewName("index/goods");
        } else if(flag == 3){/*热销排行*/
            modelAndView.addObject("flag", 3);
            List<Good> hotList = goodService.getListOrderSales();
            PageInfo pageInfo = new PageInfo(hotList);
            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("goodName", goodName);
            modelAndView.setViewName("index/goods");
        } else if(flag == 4){/*新品上市*/
            modelAndView.addObject("flag", 4);
            List<Good> goodList = goodService.getNewGoods();
            PageInfo pageInfo = new PageInfo(goodList);
            modelAndView.addObject("pageInfo", pageInfo);
            modelAndView.addObject("goodName", goodName);
            modelAndView.setViewName("index/goods");
        }

        return modelAndView;
    }

    /*跳转商品详情界面*/
    @RequestMapping("/detail")
    public ModelAndView detail(int id){
        ModelAndView modelAndView = new ModelAndView();

        Good good = goodService.get(id);
        modelAndView.addObject("good",good);

        //今日推荐前两个  在详情页显示
        List<Good> todayList = goodService.getListByTop(1, 2);
        modelAndView.addObject("todayList",todayList);
        modelAndView.setViewName("index/detail");

        return modelAndView;
    }

}
