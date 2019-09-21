package com.leader.demo.study.jdk8.optional;

import java.util.Optional;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
public class TestOptional {
    public static void main(String[] args) {
        Optional<String> fullName = Optional.ofNullable("ew");
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        System.out.println(fullName.get());
    }
}
