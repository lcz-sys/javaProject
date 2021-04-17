package cn.gdcp.controller.admin;

import cn.gdcp.domain.Order;
import cn.gdcp.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Resource(name = "orderService")
    private OrderService orderService;

    @GetMapping("/orderList")
    public ModelAndView goAdminList(int pageNum,
                                    @RequestParam(name = "status", required = false) String status,
                                    @RequestParam(name = "username", required = false) String username,
                                    @RequestParam(name = "start_time", required = false) String start_time,
                                    @RequestParam(name = "end_time", required = false) String end_time) {
        PageHelper.startPage(pageNum, 6);
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = null;
        if (username != null || start_time != null || end_time != null) {
            if (status != null && !status.equals("")) {
//                System.out.println(3);
                byte status1 = Byte.valueOf(status.trim());
                byte status2 = status1 >= 0 & status1 <= 4 ? status1 : -1;
                orderList = orderService.searchOrderByMore(status2, username, start_time, end_time);
                modelAndView.addObject("status", status2);
                modelAndView.addObject("username", username);
                modelAndView.addObject("start_time", start_time);
                modelAndView.addObject("end_time", end_time);
            } else {
//                System.out.println(1);
                orderList = orderService.searchOrders(username, start_time, end_time);
                modelAndView.addObject("username", username);
                modelAndView.addObject("start_time", start_time);
                modelAndView.addObject("end_time", end_time);
            }
        } else if (status != null && !status.equals("")) {
//            System.out.println(2);
            byte status1 = Byte.valueOf(status.trim());
            byte status2 = status1 >= 0 & status1 <= 4 ? status1 : -1;
            orderList = orderService.getListByStatus(status2);
            modelAndView.addObject("status", status2);
        } else {
//            System.out.println(4);
            orderList = orderService.getOrderList();
        }
        PageInfo pageInfo = new PageInfo(orderList);
//        System.out.println(pageInfo);
        modelAndView.setViewName("admin/order-list");
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    /*发货*/
    @GetMapping("/deliver")
    @ResponseBody
    public String deliver(int id) {
        boolean flag = orderService.send(id);
//        System.out.println("----");
        if (flag) {
            return "true";
        }
        return "false";
    }

    /*删除*/
    @GetMapping("/del")
    @ResponseBody
    public String del(int id) {
        int flag = orderService.delete(id);
        if (flag > 0) {
            return "true";
        }
        return "false";
    }

    /*完成*/
    @GetMapping("/finish")
    @ResponseBody
    public String finish(int id) {
        boolean flag = orderService.complete(id);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //删除选中订单
    @PostMapping("/delAll")
    @ResponseBody
    public String delSelect(@RequestParam(value = "ids[]") int[] ids) {
        int flag = orderService.deleteSelectOrders(ids);
        if (flag == ids.length) {
            return "true";
        }
        return "false";
    }

    //发货选中订单
    @PostMapping("/deliverAll")
    @ResponseBody
    public String deliverSelect(@RequestParam(value = "ids[]") int[] ids) {
        boolean flag = orderService.sendSelectOrders(ids);
        if (flag) {
            return "true";
        }
        return "false";
    }

    //完成选中订单
    @PostMapping("/finishAll")
    @ResponseBody
    public String finishSelect(@RequestParam(value = "ids[]") int[] ids) {
        boolean flag = orderService.completeSelectOrders(ids);
        if (flag) {
            return "true";
        }
        return "false";
    }

}
