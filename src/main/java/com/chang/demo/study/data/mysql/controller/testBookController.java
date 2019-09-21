package com.chang.demo.study.data.mysql.controller;

import com.alibaba.fastjson.JSON;
import com.chang.demo.study.data.mysql.dao.BookDao;
import com.chang.demo.study.data.mysql.model.Book;
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
    public String getBookMaxId(){
        Book maxIdBook = dao.getMaxIdBook();
        return JSON.toJSONString(maxIdBook);
    }

    @GetMapping("/getBookByAuthor")
    public String getBookByAuthor(){
        List<Book> booksByAuthorStartingWith = dao.getBooksByAuthorStartingWith("12");
        return JSON.toJSONString(booksByAuthorStartingWith);
    }

}
