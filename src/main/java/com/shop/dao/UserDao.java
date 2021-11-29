package com.shop.dao;

import com.shop.pojo.OrderFrom;
import com.shop.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

//    根据用户名获取用户信息
    User selectByName(String name);

//    添加用户
    void addUser(User user);

//    修改用户信息
    void updateByUser(User user);

    //    修改用户密码
    void updateByPassword(User user);

    //获取用户订单
    List<OrderFrom> selectByNameOrder(String username);

    //获取购物车信息
    List<OrderFrom> selectAllShopping(String username);

    //删除订单
    void deleteShopping(String fruits_name);

    //查询全部用户
    List<User> selectAllUser();

    //删除用户
    void deleteUser(String username);
}
