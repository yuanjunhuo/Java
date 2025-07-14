package org.example.mybatis_demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDept {

    private Integer id; //ID
    private LocalDateTime createTime; //创建时间
    private String description; //修改时间
}
