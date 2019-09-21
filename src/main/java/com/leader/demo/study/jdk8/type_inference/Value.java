package com.leader.demo.study.jdk8.type_inference;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
public class Value<T> {
    public static <T>  T defaultValue(){
        return null;
    }

    public T getOrDefault(T value,T defaultValue){
        return (value != null)?value :  defaultValue;
    }

    public static void main(String[] args) {
        Value<String> value = new Value<>();
        value.getOrDefault("2",Value.defaultValue());
    }
}
