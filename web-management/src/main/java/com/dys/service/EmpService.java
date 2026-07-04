package com.dys.service;

import com.dys.pojo.Emp;
import com.dys.pojo.EmpQueryParam;
import com.dys.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {

    /*
    * 条件分页查询
    * */
//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);


    /*
    * 条件分页查询优化
    * */
    PageResult<Emp> page(EmpQueryParam empQueryParam);



    void save(Emp emp);
}
