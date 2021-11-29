package com.shop.service;

import com.shop.dao.FruitsDao;
import com.shop.pojo.Fruits;
import com.shop.pojo.OrderFrom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FruitsServiceImpl implements FruitsService{

    @Autowired
    FruitsDao fruitsDao;

//    获取全部水果
    public List<Fruits> getFruits() {
        return fruitsDao.selectAllFruits();
    }

//    获取同种类水果
    public List<Fruits> getFruitsClass(String fruits_class) {
        List<Fruits> fruits = fruitsDao.selectFruitsClass(fruits_class);
        return fruits;
    }

//     根据水果名获取水果
    public Fruits getFruitsName(String fruits_name) {
        return fruitsDao.selectByFruitsName(fruits_name);
    }

//    添加水果到购物车
    public void toFruitsShopping(OrderFrom orderFrom) {
        fruitsDao.toByShopping(orderFrom);
    }

    public void buyFruits(String username) {
        fruitsDao.updateFruitsBuy(username);
    }

    // 模糊查询水果
    public List<Fruits> getVagueFruits(String keyword) {
        return fruitsDao.selectVagueFruits(keyword);
    }

    // 获取全部订单
    public List<OrderFrom> getAllOrder() {
        return fruitsDao.selectAllOrder();
    }

    //添加水果
    public void inertAddFruits(Fruits fruits) {
        fruitsDao.insertFruits(fruits);
    }

    //删除水果
    public void deleteFruitsOut(String fruitsName) {
        fruitsDao.deleteFruits(fruitsName);
    }
}
