package com.example.demo.service;

import com.example.demo.bean.user;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class userServiceImpl implements userService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private xxx x;

    @Override
    public List<user> selectAll() {
        //int xx = x.xx(111);
        return userMapper.selectAll();
    }


    public user findUser(String x) {
        //int xx = x.xx(111);
        return userMapper.findByName(x);
    }

    public boolean updateUser(user user) {
        boolean flag=false;
        try{
            userMapper.updateUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean addUser(user user) {
        boolean flag=false;
        try{
            userMapper.addUser(user);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteUser(int id) {
        boolean flag=false;
        try{
            userMapper.deleteUser(id);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public String testXX() {
        String xx = x.xx(111);
        return xx;
    }
}
