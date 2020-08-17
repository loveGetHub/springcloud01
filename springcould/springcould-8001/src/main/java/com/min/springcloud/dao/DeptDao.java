package com.min.springcloud.dao;

import entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  DeptDao {
    public boolean addDept(Dept dept);
    public Dept findById(long id);
    public List<Dept> findAll();
}
