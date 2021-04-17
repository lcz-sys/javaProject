package cn.gdcp.controller;

import cn.gdcp.domain.Account;
import cn.gdcp.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Resource(name = "accountService")
    private AccountService accountService;

    @RequestMapping(value = "/save",produces = "text/html;charset=utf8")
//    @ResponseBody
    public String save(Account account){
        accountService.save(account);
//        return "保存成功";
        return "redirect:/account/findAll";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("accountList");
        modelAndView.addObject("accountList",accountList);
        return modelAndView;
    }

    @RequestMapping(value = "/api/findAll",produces = "text/html;charset=utf8")
    @ResponseBody
    public String apiFindAll(){
        List<Account> accountList = accountService.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String str = "";
        try {
            str =  mapper.writeValueAsString(accountList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

}
