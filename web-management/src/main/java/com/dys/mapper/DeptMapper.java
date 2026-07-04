package com.dys.mapper;

import com.dys.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    /*
    * 查询部门数据
    * */
    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> findAll();


    /*
    * 根据id删除部门
    * */
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);


    /*
    * 新增部门
    * */
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);


    /*
    * 修改数据第一步，1、根据id查询数据回显
    * */
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);


    /*
    * 修改数据第二步，2、修改数据
    * */
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
