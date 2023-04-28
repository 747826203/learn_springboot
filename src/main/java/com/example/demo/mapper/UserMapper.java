package com.example.demo.mapper;

import com.example.demo.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select({
            "select",
            "id, name, sex, age",
            "from user"
    })
    List<user> selectAll();

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,name,sex, age FROM user where name=#{userName}")
    user findByName(String userName);
    /**
     * 用户数据修改
     */
    @Update("update user set name=#{name},age=#{age},sex=#{sex} where id=#{id}")
    void updateUser(user user);
}