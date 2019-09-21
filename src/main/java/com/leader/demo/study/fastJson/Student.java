package com.leader.demo.study.fastJson;

import lombok.Data;

/**
 * @author: changhao
 * @time: 2019-09-19
 */
@Data
public class Student {
    private String studentName;
    private Integer studentAge;

    public Student(String studentName,Integer studentAge){
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
}
