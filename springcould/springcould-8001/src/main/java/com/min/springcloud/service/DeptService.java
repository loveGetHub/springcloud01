package com.min.springcloud.service;

import entities.Dept;

import java.util.List;

public interface DeptService {
    public boolean add(Dept dept);
    public Dept get(long id);
    public List<Dept> list();
}
