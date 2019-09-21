package com.leader.demo.study.fastJson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author: changhao
 * @time: 2019-09-19
 */
@Data
public class Teacher {
    @JSONField(name = "studentName")
    private String name;
    private Integer studentAge;

    public Teacher(String studentName, Integer studentAge){
        this.name = studentName;
        this.studentAge = studentAge;
    }
}
