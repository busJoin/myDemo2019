package com.chang.demo.study.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: changhao
 * @time: 2019-09-19
 * 测试json和对象之间的互转
 */
public class testFastJson {
    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    private static final String  JSON_OBJ_Ter = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";

    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public static void main(String[] args) {
//        testJSONStrToJSONObject();
//        testJSONObjectToJSONStr();
//        testComplexJSONStrToJSONObject();
//        testJSONStrToJavaBeanObj();
//        testJSONStrToJavaBeanList();
        Teacher teacher = JSONObject.parseObject(JSON_OBJ_Ter, Teacher.class);
        System.out.println(JSON.toJSON(teacher));
    }

    /**
     * 1
     * json字符串-简单对象型到JSONObject的转换
     */
    public static void testJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));

    }

    /**
     * JSONObject到json字符串-简单对象型的转换
     */
    public static void testJSONObjectToJSONStr() {

        //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        // 第一种方式
//        String jsonString = JSONObject.toJSONString(jsonObject);

        // 第二种方式
        String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
    }

    /**
     * 3
     * 复杂json格式字符串到JSONObject的转换
     */
    public static void testComplexJSONStrToJSONObject() {

        JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");

        System.out.println("teacherName:  " + teacherName + "   teacherAge:  " + teacherAge);

        JSONObject jsonObjectcourse = jsonObject.getJSONObject("course");
        //获取JSONObject中的数据
        String courseName = jsonObjectcourse.getString("courseName");
        Integer code = jsonObjectcourse.getInteger("code");

        System.out.println("courseName:  " + courseName + "   code:  " + code);

        JSONArray jsonArraystudents = jsonObject.getJSONArray("students");

        //遍历JSONArray
        for (Object object : jsonArraystudents) {

            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            System.out.println("studentName:  " + studentName + "   studentAge:  " + studentAge);
        }
    }

    /**
     * json字符串-简单对象到JavaBean之间的转换
     */
    public static void testJSONStrToJavaBeanObj() {

        //第一种方式
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        String studentName = jsonObject.getString("studentName");
        Integer studentAge = jsonObject.getInteger("studentAge");

        //Student student = new Student(studentName, studentAge);

        //第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Student student = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});

        //第三种方式,使用Gson的思想
//        Student student = JSONObject.parseObject(JSON_OBJ_STR, Student.class);

        System.out.println(student);
    }

    /**
     * json字符串-数组类型到JavaBean_List的转换
     */
    public static void testJSONStrToJavaBeanList() {

        //第一种方式
        JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);

        //遍历JSONArray
        List<Student> students = new ArrayList<Student>();
        Student student = null;
        for (Object object : jsonArray) {

            JSONObject jsonObjectone = (JSONObject) object;
            String studentName = jsonObjectone.getString("studentName");
            Integer studentAge = jsonObjectone.getInteger("studentAge");

            student = new Student(studentName,studentAge);
            students.add(student);
        }

        System.out.println("students:  " + students);


        //第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        List<Student> studentList = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        System.out.println("studentList:  " + studentList);

        //第三种方式,使用Gson的思想
        List<Student> studentList1 = JSONArray.parseArray(JSON_ARRAY_STR, Student.class);
        System.out.println("studentList1:  " + studentList1);

    }



}
