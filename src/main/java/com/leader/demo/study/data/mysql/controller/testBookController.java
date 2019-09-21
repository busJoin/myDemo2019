package com.leader.demo.study.data.mysql.controller;

import com.alibaba.fastjson.JSON;
import com.leader.demo.study.data.mysql.dao.BookDao;
import com.leader.demo.study.data.mysql.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: changhao
 * @time: 2019-09-19
 */
@RestController
public class testBookController {
    @Resource
    private BookDao dao;

    @GetMapping("/saveBook")
    public String saveBook(){
        Book book = new Book();
        book.setAuthor("123");
        book.setDescription("好");
        book.setName("name");
        book.setPrice(12F);
        dao.save(book);
        return "save ok";
    }

    @GetMapping("/getBookMaxId")
    public Object getBookMaxId(){
        Book maxIdBook = dao.getMaxIdBook();
        //测试有属性没空的情况
        maxIdBook.setAuthor(null);
        return JSON.toJSONString(maxIdBook);
    }

    @GetMapping("/getBookByAuthor")
    public String getBookByAuthor(){
        List<Book> booksByAuthorStartingWith = dao.getBooksByAuthorStartingWith("12");
        return JSON.toJSONString(booksByAuthorStartingWith);
    }

}
