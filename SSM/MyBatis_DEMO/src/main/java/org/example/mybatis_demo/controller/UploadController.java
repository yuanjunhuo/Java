package org.example.mybatis_demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_demo.pojo.Result;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile file) throws IOException {


        //文件本地存储
        String filename = file.getOriginalFilename();
        int index = filename.lastIndexOf(".");
        String suffix = filename.substring(index);
        // 构造唯一文件名！！！
        String newFileName = UUID.randomUUID() + suffix;
        System.out.println(newFileName);

        file.transferTo(new File("/Users/baimo/Desktop/HJY/"+newFileName));


        log.info("文件上传！！！");
        return Result.success();
    }


}
