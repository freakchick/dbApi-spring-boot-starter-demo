package com.demo.controller;


import com.alibaba.fastjson.JSONObject;
import com.gitee.freakchicken.DBApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: starterDemo
 * @description:
 * @author: jiangqiang
 * @create: 2021-03-11 11:42
 **/
@Slf4j
@RequestMapping("/student")
@RestController
public class HomeController {

    @Autowired
    DBApi dbApi;

    @RequestMapping("/getAll")
    public List<JSONObject> getAllStudent() {
        List<JSONObject> jsonObjects = dbApi.executeQuery(null, "user", "getUser");
        return jsonObjects;
    }

    @RequestMapping("/getById")
    public List<JSONObject> getStudentById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<JSONObject> jsonObjects = dbApi.executeQuery(map, "user2", "getUserById");
        return jsonObjects;
    }

    @RequestMapping("/getById2")
    public List<Student> getStudentById2(Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<Student> list = dbApi.executeQuery(map, "user2", "getUserById", Student.class);
        return list;
    }

    @RequestMapping("/add")
    public Integer add(String name, Integer age) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        int i = dbApi.executeUpdate(map, "user2", "createStudent");
        return i;
    }

}
