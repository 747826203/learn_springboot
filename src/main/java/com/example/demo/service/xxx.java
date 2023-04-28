package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class xxx {

    @Autowired
    private  QQQ qqq;

    public String xx(int i){
        String qqq = this.qqq.qqq();
        return qqq + i;
    }
}
