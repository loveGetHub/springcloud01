package com.min.springcloud.controller;

import entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DeptClientService;

import java.util.List;

@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptClientService deptClientService;
    @RequestMapping(value = "/consumer/dept/add" ,method = RequestMethod.POST)
    public boolean add(Dept dept){
       return deptClientService.add(dept);
    }
    @RequestMapping(value = "/consumer/dept/get/{id}" ,method = RequestMethod.GET)
    public Dept get(@PathVariable("id") long id){
       return deptClientService.get(id);
    }
    @RequestMapping(value = "/consumer/dept/list" ,method = RequestMethod.GET)
    public List<Dept> list(){
        return deptClientService.list();
    }
}
