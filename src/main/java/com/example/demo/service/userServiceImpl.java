package com.example.demo.service;

import com.example.demo.bean.user;
import com.example.demo.bean.jsonData;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.*;
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

    public int findScore(int x,int y) {
        //int xx = x.xx(111);
        return userMapper.findScoreByName(x,y);
    }

    public String testXX() {
        String xx = x.xx(111);
        return xx;
    }

    public  boolean jsonBatchExport() {
        boolean flag=false;
        try{
            String basePath = "D:\\Users\\Administrator\\Desktop\\bcc\\";
            String[] list = new File(basePath).list();
            System.out.println(JSONObject.toJSONString(list));
            System.out.println(JSONObject.toJSONString(list.length));
            for (String fileName : list) {
                String filePath = basePath + fileName;
                jsonExport(filePath);
            }
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean jsonExport(String filePath) {
        boolean flag=false;
        try{
//            File file = new File("D:/Users/Administrator/Desktop/export/bussiness_0");
            File file = new File(filePath);
            long size = file.length();
            byte[] content = new byte[(int)size];
//            FileInputStream in = new FileInputStream("D:/Users/Administrator/Desktop/export/bussiness_0");
            FileInputStream in = new FileInputStream(filePath);
            int read = in.read(content);
            in.close();
            String full = new String(content);
//            System.out.println("全部字符数据:"+ full );
            String[] split = full.split("\r\n");
            for(String x : split ){
//                System.out.println("单条数据"+ x );
//                JSONObject obj=JSONObject.parseObject(x);
//                System.out.println("JSON:"+ obj.get("phone").toString() );
                jsonExchange(x);
            }
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean jsonExchange(String data) {
        boolean flag=false;
        try{
            jsonData jsonData = new jsonData();
//            String data = "{\"contacts\":\"[{\\\"is_primary\\\":false,\\\"updated_at\\\":\\\"2022-11-04T09:52:45.000000Z\\\",\\\"phone\\\":\\\"08098899883\\\",\\\"name\\\":\\\"Bincom ICT Solutions\\\",\\\"created_at\\\":\\\"2000-01-01T06:01:01.000000Z\\\",\\\"id\\\":19858,\\\"business_id\\\":24731,\\\"email\\\":\\\"badesemowo@yahoo.com\\\"}]\",\"email\":\"badesemowo@yahoo.com\",\"firstName\":\"Bade\",\"lastName\":\"Adesemowo\",\"locations\":\"[{\\\"street_address\\\":\\\"21, Araromi Street, Off Moloney Street\\\",\\\"phone_1\\\":\\\"08098899883\\\",\\\"is_active\\\":true,\\\"is_primary\\\":true,\\\"city\\\":{\\\"is_active\\\":true,\\\"name\\\":\\\"Onikan\\\",\\\"id\\\":8431,\\\"state_id\\\":25},\\\"model_type\\\":\\\"App\\\\\\\\Models\\\\\\\\Business\\\",\\\"created_at\\\":\\\"2000-01-01T06:01:01.000000Z\\\",\\\"model_id\\\":24731,\\\"full_address\\\":\\\"21, Araromi Street, Off Moloney Street, Onikan, Lagos Island\\\",\\\"local_government\\\":{\\\"is_active\\\":true,\\\"updated_at\\\":\\\"2022-02-14T08:18:48.000000Z\\\",\\\"name\\\":\\\"Lagos Island\\\",\\\"created_at\\\":\\\"2021-12-10T19:30:32.000000Z\\\",\\\"id\\\":563,\\\"city_id\\\":8431},\\\"local_government_id\\\":563,\\\"enable_email_feedback\\\":true,\\\"website_url\\\":\\\"https://bincom.net/\\\",\\\"updated_at\\\":\\\"2022-11-04T09:55:14.000000Z\\\",\\\"enable_sms_feedback\\\":true,\\\"id\\\":19858,\\\"city_id\\\":8431}]\",\"phone\":\"+2348098899883\"}";
            JSONObject obj=JSONObject.parseObject(data);
//            System.out.println("JSON:"+ obj.get("email") );
//            BeanUtils.copyProperties(obj, jsonData);
            if(obj.get("email") != null){
                jsonData.setEmail(obj.get("email").toString());
            }
            if(obj.get("firstName") != null){
                jsonData.setFirstName(obj.get("firstName").toString());
            }
            if(obj.get("lastName") != null){
               jsonData.setLastName(obj.get("lastName").toString());
            }
            if(obj.get("phone") != null){
                jsonData.setPhone(obj.get("phone").toString());
            }
            // 处理contacts字段
            JSONArray  contacts=JSONArray.parseArray(obj.get("contacts").toString());
            JSONObject contact =JSONObject.parseObject(contacts.get(0).toString());
            if(contact.get("name") != null){
                jsonData.setName(contact.get("name").toString());
            }
            if(contact.get("phone") != null){
                jsonData.setPhone(contact.get("phone").toString());
            }
//            // 处理locations字段
            JSONArray  locations=JSONArray.parseArray(obj.get("locations").toString());
            JSONObject location =JSONObject.parseObject(locations.get(0).toString());
            if(location.get("phone_1") != null){
                jsonData.setPhone1(location.get("phone_1").toString());
            }
            if(location.get("full_address") != null){
                jsonData.setFullAddress(location.get("full_address").toString());
            }
//            // 处理locations 里的city字段
            if(location.get("city") != null) {
                JSONObject city =JSONObject.parseObject(location.get("city").toString());
                if(city.get("name") != null){
                    jsonData.setCityName(city.get("name").toString());
                }
            }

//            // 处理locations 里的local_government字段
            if(location.get("local_government") != null) {
                JSONObject local_government =JSONObject.parseObject(location.get("local_government").toString());
                if(local_government.get("name") != null){
                    jsonData.setLocalGovernmentName(local_government.get("name").toString());
                }
            }
//            System.out.println("数据:"+ location );
            System.out.println("数据:"+ jsonData.getPhone() );
            userMapper.addJson(jsonData);

            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
