package com.leader.demo.study.jdk8.annotation;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.*;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
@Slf4j
public class TestAnnotation {

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };

    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }

}
