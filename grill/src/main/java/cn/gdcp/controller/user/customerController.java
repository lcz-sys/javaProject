package cn.gdcp.controller.user;

import cn.gdcp.domain.Good;
import cn.gdcp.domain.Order;
import cn.gdcp.domain.User;
import cn.gdcp.interceptor.ExceptionInterceptor;
import cn.gdcp.service.*;
import cn.gdcp.utils.MD5Util;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/customer")
public class customerController {

    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "cartService")
    private CartService cartService;
    @Resource(name = "orderService")
    private OrderService orderService;
    @Resource(name = "goodService")
    private GoodService goodService;

    /*前台用户注册界面*/
    @RequestMapping("/register")
    public String goRegister() {
        return "index/register";
    }

    @PostMapping("/register")
    public ModelAndView register(User user) {
        ModelAndView modelAndView = new ModelAndView();
        if (user.getUsername().isEmpty()) {
            modelAndView.addObject("msg", "用户名不能为空！");
        } else if (Objects.nonNull(userService.getByUsername(user.getUsername()))) {
            modelAndView.addObject("msg", "用户已经存在！");
        } else {
            user.setCreate_time(new Date());
            userService.addUser(user);
            modelAndView.addObject("msg", "注册成功，可以登陆了！");
            modelAndView.setViewName("/index/login");
            return modelAndView;
        }
        modelAndView.setViewName("/index/register");
        return modelAndView;
    }

    /*前台用户登录界面*/
    @GetMapping("/login")
    public String goLogin() {
        return "index/login";
    }

    /*登录 */
    @PostMapping("/login")
    public String Login(User user, HttpServletRequest request, HttpSession session) {
        //验证用户名和密码是否正确
        boolean flag = userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (flag) {
            User user1 = userService.getByUsername(user.getUsername());
            //还原购物车
            session.setAttribute("cartCount", cartService.getCount(user1.getId()));
//            String referer = request.getHeader("referer");//页面来源
//            System.out.println(referer);
            session.setAttribute("user", user1);
            return "redirect:/index/main";
        } else {
            request.setAttribute("msg", "账号或密码错误");
            return "index/login";
        }
    }

    /*退出登录  */
    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request, HttpSession sess) {
        try {
            sess.removeAttribute("user");
            request.removeAttribute("msg");
            sess.removeAttribute("cartCount");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/customer/login";
    }


    /*跳转到我的订单界面*/
    @RequestMapping("/order")
    public ModelAndView goMyOrder(int pageNum, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(pageNum, 6);

        User user = (User) session.getAttribute("user");
        List<Order> orderList = orderService.getListByUserId(user.getId());
        PageInfo pageInfo = new PageInfo(orderList);
//        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("index/order");

        return modelAndView;
    }

    /*跳转到收获地址*/
    @RequestMapping("/personal/address")
    public String goMyAddress() {
        return "/index/address";
    }

    /*修改收获地址信息*/
    @PostMapping("/personal/addressUpdate")
    public String updateAddress(String name, String phone, String address, HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        boolean flag = userService.updateAddress(user.getId(), name, phone, address);
        session.setAttribute("user", userService.get(user.getId()));
        if (flag) {
            request.setAttribute("msg", "修改成功");
        } else {
            request.setAttribute("msg", "修改失败");
        }
        return "/index/address";
    }

    /*跳转到修改密码*/
    @RequestMapping("/personal/password")
    public String goUpdatePassword() {
        return "/index/password";
    }

    /*修改用户密码*/
    @PostMapping("/personal/passwordUpdate")
    public String updatePassword(String password, String passwordNew, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        user = userService.get(user.getId());
        if (!user.getPassword().equals(MD5Util.encode(password))) {
            request.setAttribute("msg", "原始密码错误");
        } else {
            userService.editPass(user.getId(), passwordNew, password);
            request.setAttribute("msg", "密码修改成功");
        }
        return "index/password";
    }


    //购物车相关

    /*加入购物车*/
    @PostMapping("/cartBuy")
    @ResponseBody
    public boolean cartBuy(int goodId,
                           @RequestParam(required = false, defaultValue = "0") int count,
                           HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (count == 0) {
            return cartService.save(goodId, user.getId());
        }
        return cartService.save(goodId, count, user.getId());
    }

    /*跳转购物车界面*/
    @RequestMapping("/cart")
    public String Cart(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        request.setAttribute("cartList", cartService.getList(user.getId()));
        session.setAttribute("cartCount", cartService.getCount(user.getId()));
        request.setAttribute("cartTotal", cartService.getTotal(user.getId()));
        return "index/cart";
    }

    /*购物车总金额*/
    @GetMapping("/cartTotal")
    @ResponseBody
    public int cartTotal(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return cartService.getTotal(user.getId());
    }

    /*购物车结算*/
    @GetMapping("/orderSave")
    public String orderSave(HttpServletRequest request, HttpSession session) throws ExceptionInterceptor.MyException {
        User user = (User) session.getAttribute("user");
        request.setAttribute("cartList", cartService.getList(user.getId()));
        int orderId = orderService.save(user.getId());
        session.removeAttribute("cartCount");//清理购物车
        return "redirect:/customer/orderPay?id=" + orderId;
    }

    /*立即结算*/
    @GetMapping("/orderImmediatelySave")
    public String orderImmediatelySave(int goodId, int count, HttpServletRequest request, HttpSession session) throws ExceptionInterceptor.MyException {
        User user = (User) session.getAttribute("user");
        Good good = goodService.get(goodId);
        int orderId = orderService.Immediatelysave(user.getId(), good, count);
        request.setAttribute("order", orderService.get(orderId));
        return "index/pay";
    }

    /*跳转支付界面*/
    @GetMapping("/orderPay")
    public String orderPay(int id, HttpServletRequest request) {
        request.setAttribute("order", orderService.get(id));
        return "index/pay";
    }

    /*支付成功*/
    @PostMapping("/orderPay")
    public String orderPay(Order order) {
        boolean flag = orderService.pay(order);
        return "index/payok";
    }

    /*更新购物车数量*/
    @GetMapping("/updateCartCount")
    @ResponseBody
    public int updateCartCount(HttpSession session) {
       /* User user = (User) session.getAttribute("user");
        int count = cartService.getCount(user.getId());
        session.setAttribute("cartCount", count);*/
        User user = (User) session.getAttribute("user");
        int count = cartService.getCount(user.getId());
        if (count > 999) {
            session.setAttribute("cartCount", 999);
            return 999;
        }
        session.setAttribute("cartCount", count);
        return count;
    }

    /*购物车里面商品加号添加*/
    @PostMapping("/cartAdd")
    @ResponseBody
    public boolean cartAdd(int id) {
        return cartService.add(id);
    }

    /*购物车商品减少*/
    @PostMapping("/cartLess")
    @ResponseBody
    public boolean cartLess(int id) {
        return cartService.less(id);
    }

    /*购物车里面的商品删除*/
    @PostMapping("/cartDelete")
    @ResponseBody
    public boolean cartDelete(int id) {
        return cartService.cartDel(id);
    }

}
