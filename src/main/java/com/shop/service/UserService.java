package com.shop.service;

import com.shop.pojo.OrderFrom;
import com.shop.pojo.User;

import java.util.List;

public interface UserService {

//    根据用户名和密码判断用户是否登录
    Boolean isLogin(User user);

//    判断用户是否存在，不存在则添加
    boolean isUser(User user);

    //根据用户名获取用户
    User toUser(String username);

//    修改用户信息
    void update_user(User user);

    //    修改用户密码
    boolean update_password(User user);

    //获取用户订单
    List<OrderFrom> getUserOrder(String username);

    //获取购物车信息
    List<OrderFrom> getAllShopping(String username);

    //删除订单
    void deleteShoppingOrder(String fruits_name);

    //查询全部用户
    List<User> getAllUser();

    //删除用户
    void deleteFromUser(String username);
}
