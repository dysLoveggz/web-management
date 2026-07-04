package com.dys.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/*
* 员工工作经历类
* */
@Data
public class EmpExpr {
    private int id;
    private int empId;
    private LocalDateTime begin;
    private LocalDateTime end;
    private String company;
    private String job;
}
