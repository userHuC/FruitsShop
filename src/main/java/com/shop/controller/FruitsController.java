package com.shop.controller;

import com.shop.pojo.Fruits;
import com.shop.pojo.OrderFrom;
import com.shop.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class FruitsController {

    private String username="";

    @Autowired
    FruitsService fruitsService;

    //    获取全部水果
    @RequestMapping("/homepage")
    public ModelAndView homepage(HttpServletRequest request){
        username = (String) request.getSession().getAttribute("username");
        ModelAndView modelAndView = new ModelAndView();
        List<Fruits> fruitsList = fruitsService.getFruits();
        modelAndView.addObject("fruitsList",fruitsList);
        modelAndView.addObject("username",username);
        modelAndView.setViewName("index_one");
        return modelAndView;
    }

    //    获取同种类水果
    @RequestMapping("/fruitsClass/{fruits_class}")
    public ModelAndView fruitsClass(@PathVariable("fruits_class")String fruits_class){
        ModelAndView modelAndView = new ModelAndView();
        List<Fruits> fruitsList = fruitsService.getFruitsClass(fruits_class);
        modelAndView.addObject("fruitsList",fruitsList);
        modelAndView.setViewName("index_one");
        return modelAndView;
    }

    //    根据水果名获取水果
    @RequestMapping("/fruitsName/{fruits_name}")
    public ModelAndView fruitsName(@PathVariable("fruits_name")String fruits_name){
        ModelAndView modelAndView = new ModelAndView();
        if(username=="" || username==null){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }
        Fruits fruits = fruitsService.getFruitsName(fruits_name);
        modelAndView.addObject("fruits",fruits);
        modelAndView.addObject("username",username);
        modelAndView.setViewName("index_sg");
        return modelAndView;
    }

    //将水果添加到购物车
    @RequestMapping("/toShopping")
    public String toShopping(OrderFrom orderFrom){
        orderFrom.setUsername(username);
        orderFrom.setState("待支付");
        fruitsService.toFruitsShopping(orderFrom);
        return "redirect:/goShopping";
    }

    //购买水果
    @RequestMapping("/buyFruits")
    public String buyFruits(){
        fruitsService.buyFruits(username);
        return "redirect:/goShopping";
    }

    //模糊查询
    @RequestMapping("/vagueSelect")
    public ModelAndView vagueSelect(String keyword){
        ModelAndView modelAndView = new ModelAndView();
        if(keyword == null || keyword.equals("")){
            modelAndView.setViewName("redirect:/homepage");
            return modelAndView;
        }
        keyword = "%"+keyword+"%";
        List<Fruits> fruitsList = fruitsService.getVagueFruits(keyword);
        modelAndView.addObject("fruitsList",fruitsList);
        modelAndView.setViewName("index_one");
        return modelAndView;
    }

    //获取全部水果信息
    @RequestMapping("/manageFruits")
    public ModelAndView manageFruits(){
        ModelAndView modelAndView = new ModelAndView();
        List<Fruits> fruitsList = fruitsService.getFruits();
        modelAndView.addObject("fruitsList",fruitsList);
        modelAndView.addObject("label","manageFruits");
        modelAndView.setViewName("user_admin");
        return modelAndView;
    }

    //获取全部订单
    @RequestMapping("/allOrder")
    public ModelAndView allOrder(){
        ModelAndView modelAndView = new ModelAndView();
        List<OrderFrom> orderFromList = fruitsService.getAllOrder();
        modelAndView.addObject("orderFromList",orderFromList);
        modelAndView.addObject("label","order");
        modelAndView.setViewName("user_admin");
        return modelAndView;
    }

    //跳转
    @RequestMapping("/skipFruits")
    public ModelAndView skipFruits(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.addObject("label","add");
        modelAndView.setViewName("user_admin");
        return modelAndView;
    }

    //添加水果
    @RequestMapping("/addFruits")
    public String addFruits(Fruits fruits, MultipartFile photo, HttpSession session)throws IOException {
        String site = photo.getOriginalFilename();
        fruits.setSite(site);
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("resources/images");
        String finalPath = photoPath + File.separator + site;
        photo.transferTo(new File(finalPath));
        fruitsService.inertAddFruits(fruits);
        return "redirect:/manageFruits";
    }

    //删除水果
    @RequestMapping("/removeFruits/{fruitsName}")
    public String removeFruits(@PathVariable("fruitsName")String fruitsName){
        fruitsService.deleteFruitsOut(fruitsName);
        return "redirect:/manageFruits";
    }
}
