package com.leader.demo.study.jdk8.interface1;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
@FunctionalInterface
public interface Functional {
    int method();

    default void de(){
        System.out.println("i am default");
    }
    static void d(){

    }
}
