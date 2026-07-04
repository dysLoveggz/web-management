package com.dys.service.impl;

import com.dys.mapper.DeptMapper;
import com.dys.pojo.Dept;
import com.dys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /*
    查询所有部门数据
    */
    @Override
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    /*
    根据id删除部门
    */
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    /*
    * 新增部门
    * */
    @Override
    public void add(Dept dept) {
//        1、补全基础属性   - createTime, updateTime
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

//        2、调用Mapper接口方法来插入数据
        deptMapper.insert(dept);
    }


    /*
    * 修改数据第一步，1、查询回显，根据id查询一条数据返回
    * */
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }


    /*
    * 修改数据第二步，2、修改数据
    * */
    @Override
    public void update(Dept dept) {
//        补充最后修改时间属性
        dept.setUpdateTime(LocalDateTime.now());
//        调用Mapper接口方法
        deptMapper.update(dept);
    }
}
