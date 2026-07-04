package com.dys.controller;

import com.dys.pojo.Dept;
import com.dys.pojo.Result;
import com.dys.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

//    查询部门数据
    @GetMapping
    public Result list(){
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }


   /* 删除部门数据
    注意，用了RequestParam注解，在Apifox里调用时必须在最后传入参数id，
    但如果请求参数名与形参变量名一样，那可以省略RequestParam注解,形参里直接写Integer id*/
    @DeleteMapping
    public Result delete(/*@RequestParam*/ Integer id){
        System.out.println("删除部门数据:" + id);
        deptService.deleteById(id);
        return Result.success();
    }


    /*
    * 新增部门数据,注意，前端传入的JSON数据的键名要和方法形参对象的属性名一致，并用RequestBody注解标识,
    * RequestBody注解是将前端传入的JSON数据映射（封装）为Dept对象
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门:" + dept);
        deptService.add(dept);
        return Result.success();
    }


    /*
    * 修改数据，分两步
    * 1、查询回显，根据id查询一条数据返回
    * 2、修改数据
    * */
    @GetMapping("/{id}")
//    后面的{id}是路径参数，就是根据这个id去查询数据，前端传入过来的，用@PathVariable注解标识
    public Result getInfo(@PathVariable Integer id){
        System.out.println("查询的数据:" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }


    /*
    * 修改数据第二步，修改数据
    * */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        System.out.println("修改数据:" + dept);
        deptService.update(dept);
        return Result.success();
    }
}
