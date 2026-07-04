package com.dys.service.impl;

import com.dys.mapper.EmpExprMapper;
import com.dys.mapper.EmpMapper;
import com.dys.pojo.Emp;
import com.dys.pojo.EmpExpr;
import com.dys.pojo.EmpQueryParam;
import com.dys.pojo.PageResult;
import com.dys.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    /*原始分页查询
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //   调用Mapper接口方法获取总记录数
        Long total = empMapper.count();

        //   调用Mapper接口方法获取当前页数据,但要注意前端传入的是页码，而Mapper接口方法里的第一个参数是起始索引，要转化
        Integer start = (page - 1) * pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        //   封装成PageResult对象并返回
        return new PageResult<Emp>(total, rows);
    }*/


    /*
    * 基于pagehelper分页查询,通过pageHelper的方法来实现分页查询，只需要在原始代码（方法）上改动empService和empMapper即可
    * */
    /*@Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
       //   1、设置分页参数
        PageHelper.startPage(page, pageSize);

        //   2、执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);

        //   3、封装对象
        Page<Emp> p = (Page<Emp>) empList;   //   PageHelper自动将分页查询的结果封装到Page对象中，用的时候拿出来
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }*/


    /*
    * 条件分页查询优化
    * */
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        //   1、设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        //   2、执行查询
        List<Emp> empList = empMapper.list(empQueryParam);

        //   3、封装对象
        Page<Emp> p = (Page<Emp>) empList;   //   PageHelper自动将分页查询的结果封装到Page对象中，用的时候拿出来
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }


    @Override
    public void save(Emp emp) {
//        新增员工基本信息,第一步应该是要补全基础属性的，但我这里没有这个需求
        empMapper.insert(emp);

//        新增员工工作经历信息
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList)){
            //   遍历集合，为empId赋值
            exprList.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }
}
