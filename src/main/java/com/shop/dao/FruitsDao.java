package com.shop.dao;

import com.shop.pojo.Fruits;
import com.shop.pojo.OrderFrom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FruitsDao {

//    获取全部水果
    List<Fruits> selectAllFruits();

//    根据水果种类查找水果
    List<Fruits> selectFruitsClass(String fruits_class);

//    根据水果名查找水果
    Fruits selectByFruitsName(String fruits_name);

//    添加水果到购物车
    void toByShopping(OrderFrom orderFrom);

    //购买水果
    void updateFruitsBuy(String username);

    //模糊查询
    List<Fruits> selectVagueFruits(String keyword);

    //查询全部订单
    List<OrderFrom> selectAllOrder();

    //添加水果
    void insertFruits(Fruits fruits);

    //删除水果
    void deleteFruits(String fruitsName);
}
