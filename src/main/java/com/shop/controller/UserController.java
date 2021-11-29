package com.shop.controller;

import com.shop.pojo.OrderFrom;
import com.shop.pojo.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private String username="";

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "redirect:/homepage";
    }

    //登入
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request){
        boolean res = userService.isLogin(user);
        if(res){
            request.getSession().setAttribute("username",user.getUsername());
            username=user.getUsername();
            if("admin".equals(user.getUsername())){
                return "redirect:/allUser";
            }
            return "redirect:/homepage";
        }
        return "login";
    }

    //注册
    @RequestMapping("/register")
    public String register(User user){
        boolean res = userService.isUser(user);
        if(res){
            return "login";
        }
        return "register";
    }

    //退出登入
    @RequestMapping("/exitRegister")
    public String exitRegister(HttpServletRequest request){
        request.getSession().setAttribute("username","");
        return "redirect:/homepage";
    }

    //根据用户名获取用户
    @RequestMapping("/userCenter/{label}")
    public ModelAndView userCenter(@PathVariable("label")String label){
        ModelAndView modelAndView = new ModelAndView();
        if("order".equals(label)){
            List<OrderFrom> orderFromList = userService.getUserOrder(username);
            modelAndView.addObject("orderFromList",orderFromList);
        }
        User user = userService.toUser(username);
        modelAndView.addObject("user",user);
        modelAndView.addObject("label",label);
        modelAndView.setViewName("user_center");
        return modelAndView;
    }

    //修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        user.setUsername(username);
        userService.update_user(user);
        return "redirect:/userCenter/message";
    }

    //修改密码
    @RequestMapping("/updatePaw")
    public String updatePaw(String password){
        User user = new User(username,password,null,null);
        boolean res = userService.update_password(user);
        if (res){
            return "redirect:/userCenter/message";
        }
        return "redirect:/userCenter/paw";
    }

    //用户订单
    @RequestMapping("/order")
    public String order(){
        if(username=="" || username==null){
            return "redirect:/login";
        }
        return "redirect:/userCenter/order";
    }

    //购物车
    @RequestMapping("/goShopping")
    public ModelAndView goShopping(){
        ModelAndView modelAndView = new ModelAndView();
        if(username=="" || username==null){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        if(username.equals("admin")){
            modelAndView.setViewName("redirect:/allUser");
            return modelAndView;
        }
        List<OrderFrom> orderFromList = userService.getAllShopping(username);
        modelAndView.addObject("orderFromList",orderFromList);
        modelAndView.addObject("username",username);
        modelAndView.setViewName("index_gwc");
        return modelAndView;
    }

    //删除订单
    @RequestMapping("deleteOrder/{fruits_name}")
    public ModelAndView deleteOrder(@PathVariable("fruits_name")String fruits_name){
        ModelAndView modelAndView = new ModelAndView();
        userService.deleteShoppingOrder(fruits_name);
        List<OrderFrom> orderFromList = userService.getAllShopping(username);
        modelAndView.addObject("orderFromList",orderFromList);
        modelAndView.setViewName("index_gwc");
        return modelAndView;
    }

    //获取全部用户
    @RequestMapping("/allUser")
    public ModelAndView allUser(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userService.getAllUser();
        modelAndView.addObject("userList",userList);
        modelAndView.addObject("username",username);
        modelAndView.addObject("label","abc");
        modelAndView.setViewName("user_admin");
        return modelAndView;
    }

    //删除用户
    @RequestMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable("username")String username){
        userService.deleteFromUser(username);
        return "redirect:/allUser";
    }
}
