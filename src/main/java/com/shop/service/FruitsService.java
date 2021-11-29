package com.shop.service;

import com.shop.pojo.Fruits;
import com.shop.pojo.OrderFrom;

import java.util.List;

public interface FruitsService {

    //    获取全部水果
    List<Fruits> getFruits();

    //获取同种类的水果
    List<Fruits> getFruitsClass(String fruits_class);

    //根据水果名获取水果
    Fruits getFruitsName(String fruits_name);

    //添加水果到购物车
    void toFruitsShopping(OrderFrom orderFrom);

    //购买水果
    void buyFruits(String username);

    //模糊查询水果
    List<Fruits> getVagueFruits(String keyword);

    //获取全部订单
    List<OrderFrom> getAllOrder();

    //添加水果
    void inertAddFruits(Fruits fruits);

    //删除水果
    void deleteFruitsOut(String fruitsName);
}
