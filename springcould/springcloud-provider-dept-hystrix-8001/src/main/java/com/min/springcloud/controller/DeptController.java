package com.min.springcloud.controller;

import com.min.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id")long id){
        Dept dept = deptService.get(id);
        if (dept==null){
            throw new RuntimeException("该ID:"+id+"没有对应的值");
        }
        return dept;
    }
    private Dept processHystrix_Get(@PathVariable("id")long id){
        return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的值").setDb_source("mysql没有这个数据库");
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
