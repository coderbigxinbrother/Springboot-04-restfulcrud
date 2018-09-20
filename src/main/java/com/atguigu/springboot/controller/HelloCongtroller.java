package com.atguigu.springboot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.springboot.exception.UserNotExistException;


@Controller
public class HelloCongtroller {

	
	
    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "Hello World";
    }
    
	@RequestMapping("/success")
	public String success(Map<String, Object> map){
		List<String> asList = Arrays.asList("wangxin","zhangjun","liujiefeng");
		map.put("success", "<h1>hello,欢迎过来!!!</h1>");
		map.put("users", asList);
		return "success";
	}
	
	
}
