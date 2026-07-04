package com.dys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//   统一返回结果类
public class Result {
    private Integer code;    //  1代表成功，0代表失败
    private String message;     //  返回信息
    private Object data;    // 返回给前端的数据

    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.message = "success";
        return result;
    }

    public static Result success(Object object){
        Result result = new Result();
        result.code = 1;
        result.message = "success";
        result.data = object;
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.code = 0;
        result.message = message;
        return result;
    }
}
