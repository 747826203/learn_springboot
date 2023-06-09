package com.example.demo.mapper;

import com.example.demo.bean.user;
import com.example.demo.bean.jsonData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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
    /**
     * 用户数据新增
     */
    @Insert("insert into user(id,name,age,sex) values (#{id},#{name},#{age},#{sex})")
    void addUser(user user);
    /**
     * 用户数据删除
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(int id);
    /**
     * 根据用户名称查询用户成绩
     */
//    @Select("SELECT score FROM score where user_id=#{id} and c_id=#{cid}")

    int findScoreByName(@Param("id") int id,@Param("cid") int cid);
    /**
     * 导入JSON数据
     */
    @Insert("insert into jsonData(firstName,lastName,phone,email,name,phone1,localGovernmentName,cityName,fullAddress) values (#{firstName},#{lastName},#{phone},#{email},#{name},#{phone1},#{localGovernmentName},#{cityName},#{fullAddress})")
    void addJson(jsonData jsonData);
}