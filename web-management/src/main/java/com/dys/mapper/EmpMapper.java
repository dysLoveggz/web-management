package com.dys.mapper;

import com.dys.pojo.Emp;
import com.dys.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /*
    * 查询总记录数
    * */
    /*@Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    public Long count();*/


    /*
    * 分页查询
    * */
    /*@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.entry_time desc limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);*/


    /*
    * 基于pagehelper 的分页查询，基于pagehelper实现分页查询时，在select语句最后不用写limit,而且语句最后绝对不能写分号
    * */
    /*@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id " +
            "order by e.entry_time desc")*/
//    public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);


//    条件分页查询优化
    List<Emp> list(EmpQueryParam empQueryParam);



//    新增员工信息（包括员工基本信息和员工工作经历信息）
//    第一条SQL语句用于添加员工基本信息
    @Options(useGeneratedKeys = true, keyProperty = "id")   //   获取到生成的主键  --  主键返回
    @Insert("insert into emp(username, name, gender, phone, salary, entry_time, dept_id)" +
            "values('smk', '死门凯', 1, '1330907021', 10000, '2023-08-12 17:00:00', 2)")
    void insert(Emp emp);
}
