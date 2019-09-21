package com.chang.demo.study.data.mysql.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: changhao
 * @time: 2019-09-19
 */
@Entity(name = "t_book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键的生成策略
    private Integer id;
    @Column(name = "book_name",nullable = false)//自定义字段，设置不为空
    private String name;
    private String author;
    private Float price;

    @Transient//在生成数据库的表时，该属性被忽略
    private String description;
}
