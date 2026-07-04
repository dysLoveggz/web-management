package com.dys.service;

import com.dys.pojo.Dept;

import java.util.List;

public interface DeptService {
    /*
    * 查询所有部门数据
    * */
    List<Dept> findAll();


    /*
    * 根据id删除部门
    * */
    void deleteById(Integer id);


    /*
    * 新增部门
    * */
    void add(Dept dept);


    /*
    * 修改部门第一步，1、查询回显
    * */
    Dept getById(Integer id);

    void update(Dept dept);
}
