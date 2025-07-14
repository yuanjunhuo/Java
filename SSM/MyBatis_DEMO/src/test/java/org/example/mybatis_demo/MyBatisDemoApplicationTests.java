package org.example.mybatis_demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class MyBatisDemoApplicationTests {

    @Test
    void contextLoads() {
    }


    // 测试
    // 生成jwt
    @Test
    public void generateJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "admin");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "hjy6666") // 设置签名和加密算法
                .setClaims(claims)  // 自定义内容
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000)) // 设置过期时间
                .compact();
        System.out.println(jwt);
    }

    // 解析jwt
    @Test
    public void parseJWT() {
        Claims claims = Jwts.parser()
                .setSigningKey("hjy6666")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiYWRtaW4iLCJpZCI6MSwiZXhwIjoxNzE2OTY1MjkyfQ.2fi99F0TLqef_ly93hN7xgejnXV4WGvBRUb2G7HLGrc")
                .getBody();
        System.out.println(claims);


    }




}
