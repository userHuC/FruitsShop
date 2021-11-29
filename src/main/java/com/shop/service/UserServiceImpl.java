package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.pojo.OrderFrom;
import com.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    //    登入验证
    public Boolean isLogin(User user) {
        User user1 = userDao.selectByName(user.getUsername());
        if(user1 != null && user.getPassword().equals(user1.getPassword())){
            return true;
        }
        return false;
    }

//    添加用户
    public boolean isUser(User user) {
        User user1 = userDao.selectByName(user.getUsername());
        if(user1==null){
            userDao.addUser(user);
            return true;
        }
        return false;
    }

    //根据用户名获取用户
    public User toUser(String username){
        User user = userDao.selectByName(username);
        return user;
    }

//    修改用户信息
    public void update_user(User user) {
        userDao.updateByUser(user);
    }

//    修改用户密码
    public boolean update_password(User user) {
        User user1 = userDao.selectByName(user.getUsername());
        if(user.getPassword().equals(user1.getPassword())){
            return false;
        }
        userDao.updateByPassword(user);
        return true;
    }

    //获取用户订单
    public List<OrderFrom> getUserOrder(String username) {
        return userDao.selectByNameOrder(username);
    }

    //获取购物车信息
    public List<OrderFrom> getAllShopping(String username) {
        return userDao.selectAllShopping(username);
    }

    //删除订单
    public void deleteShoppingOrder(String fruits_name) {
        userDao.deleteShopping(fruits_name);
    }

    //获取全部用户
    public List<User> getAllUser() {
        return userDao.selectAllUser();
    }

    //删除用户信息
    public void deleteFromUser(String username) {
        userDao.deleteUser(username);
    }
}
