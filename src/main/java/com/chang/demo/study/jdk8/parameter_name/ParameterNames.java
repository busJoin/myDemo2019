package com.chang.demo.study.jdk8.parameter_name;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author: changhao
 * @time: 2019-09-04
 */
public class ParameterNames {
    public static void main(String[] argdfds) throws NoSuchMethodException {
        Method method = ParameterNames.class.getMethod("main", String[].class);
        for (Parameter parameter:method.getParameters()){
            System.out.println("parameter :"+ parameter.getName());
        }
    }

    public void te(int  a, String B){

    }
}
