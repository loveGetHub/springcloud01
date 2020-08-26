package com.min.springcloud.controller;

import com.min.springcloud.dao.DeptDao;
import com.min.springcloud.service.DeptService;
import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @RequestMapping(value = "/dept/add" ,method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }
    @RequestMapping(value = "/dept/get/{id}" ,method = RequestMethod.GET)
    public Dept get(@PathVariable("id")long id){
        return deptService.get(id);
    }
    @RequestMapping(value = "/dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }
    @RequestMapping(value = "dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        return list;
    }
}
