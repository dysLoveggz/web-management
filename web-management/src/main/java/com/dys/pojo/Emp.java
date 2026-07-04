package com.dys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//   员工类
public class Emp {
    private Integer id;
    private String username;
    private Integer password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer salary;
    private LocalDateTime entryTime;
    private Integer deptId;
//    封装部门名称
    private String deptName;

//    员工工作经历信息
    private List<EmpExpr> exprList;
}
