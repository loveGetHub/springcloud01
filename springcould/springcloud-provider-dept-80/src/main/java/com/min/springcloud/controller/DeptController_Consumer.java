package com.min.springcloud.controller;

import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {
    /**
     * (url,requestMap,ResponseBean.class)这三个参数分别代表rest请求地址，请求参数，HTTP响应转换被转换成的对象类型
     */
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(value = "/consumer/dept/add" ,method = RequestMethod.POST)
    public boolean add(Dept dept){
        return restTemplate.patchForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }
    @RequestMapping(value = "/consumer/dept/get/{id}" ,method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }
    @RequestMapping(value = "/consumer/dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
}
