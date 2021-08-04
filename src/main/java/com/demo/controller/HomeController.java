package com.demo.controller;


import com.gitee.freakchicken.DBApi;
import com.gitee.freakchicken.entity.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: starterDemo
 * @description:
 * @author: jiangqiang
 * @create: 2021-03-11 11:42
 **/
@Slf4j
@RestController
public class HomeController {

    @Autowired
    DBApi dbApi;

    @RequestMapping("/hello")
    public ResponseDto hello(@RequestBody Map<String,Object> map) {
        ResponseDto execute = dbApi.execute(map, "getUser");
        return execute;
    }

    @RequestMapping("/getUserIn")
    public ResponseDto getUserIn(@RequestBody Map<String,Object> map) {
        ResponseDto execute = dbApi.execute(map, "getUserIn");
        return execute;
    }
}
