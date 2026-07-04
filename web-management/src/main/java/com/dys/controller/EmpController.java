package com.dys.controller;

import com.dys.pojo.Emp;
import com.dys.pojo.EmpQueryParam;
import com.dys.pojo.PageResult;
import com.dys.pojo.Result;
import com.dys.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j   //   日志记录器，用于记录日志
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //   分页查询
    /*@GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize){
        log.info("分页查询: {}, {}",page, pageSize);
        PageResult<Emp> pageResult = empService.page(page, pageSize);
        return Result.success(pageResult);
    }*/


    /*
    * 条件分页查询
    * */
    /*@GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询: {}, {}, {}, {}, {}, {}",page, pageSize, name, gender, begin, end);
        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }*/


    /*
    * 条件分页查询优化
    * */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询: {}",empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }


//    添加员工信息（包括员工基本信息和员工工作经历信息）,RequestBody注解用于将前端传入的JSON数据映射（封装）为Emp对象
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存员工信息: {}", emp);
        empService.save(emp);
        return Result.success();
    }


    /*
    * 删除员工
    * */
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工: {}", ids);
        return Result.success();
    }
}
