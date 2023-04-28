package com.example.demo.controller;

import com.example.demo.bean.user;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.userService;
import com.example.demo.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userServiceImpl userService;

    @Autowired
    UserMapper userMapper;

    //@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @GetMapping("/selectAll")
    public List<user> selectAll() {
        //List<user> list = userService.selectAll();
        List<user> users = userMapper.selectAll();
        return users;
    }


    //@RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @GetMapping("/testXX")
    public String testXX() {
        //List<user> list = userService.selectAll();
        String i = userService.testXX();
        return i;
    }

    @GetMapping("/findUser")
    public user findUser(@RequestParam(value = "userName", required = true) String userName) {
        //List<user> list = userService.selectAll();
        user user = userService.findUser(userName);
        return user;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody user user) {
        System.out.println("开始更新...");
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser( user user) {
        System.out.println("开始新增...");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public boolean delete(int userId) {
        System.out.println("开始删除...");
        return userService.deleteUser(userId);
    }
}

