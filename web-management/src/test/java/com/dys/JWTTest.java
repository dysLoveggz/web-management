package com.dys;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;   //  旧版0.9版本JWT使用
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    /*
    * 生成JWT令牌
    * */
    @Test
    public void testGenerateJwt(){
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "丁于珊");

        String jwt = Jwts.builder().signWith(Keys.hmacShaKeyFor("dysLoveggz1234567890123456789123456789".getBytes(StandardCharsets.UTF_8)))   //  新版本指定加密算法，密钥
                .setClaims(dataMap)   //  添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 7200 * 1000))   //  设置令牌过期时间
                .compact();   //  生成令牌,HS256要求密钥至少32字节（256）
        System.out.println("生成的JWT:" + jwt);
    }


    /*
    * 解析JWT令牌
    * */
    @Test
    public void testParseJwt(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiLkuIHkuo7nj4oiLCJleHAiOjE3ODI1ODA5MjZ9.I6Qo9X4FvyA3e3aK57vJVumSmwsML1LvY8QidgQf8B4";
        Claims claims = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor("dysLoveggz1234567890123456789123456789".getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println("解析结果:" + claims);

//        取出数据
        Integer id = claims.get("id", Integer.class);
        String username = claims.get("username", String.class);
        Date expiration = claims.getExpiration();

//        输出数据
        System.out.println("id:" + id);
        System.out.println("username:" + username);
        System.out.println("过期时间:" + expiration);
            }
}
