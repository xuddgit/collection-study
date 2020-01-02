package com.org.reflect;

import lombok.Data;

import java.lang.reflect.Field;

public class ReflectField {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.org.reflect.Student");
       Student student= (Student) clazz.newInstance();
        //获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
        // 否则抛NoSuchFieldException
        Field field = clazz.getField("age");
        System.out.println("field:" + field);

        //获取所有修饰符为public的字段,包含父类字段,注意修饰符为public才会获取
        Field fields[] = clazz.getFields();
        for (Field f : fields) {
            System.out.println("f:" + f.getDeclaringClass());
        }

        System.out.println("================getDeclaredFields====================");
        //获取当前类所字段(包含private字段),注意不包含父类的字段
        Field fields2[] = clazz.getDeclaredFields();
        for (Field f : fields2) {
            System.out.println("f2:" + f.getDeclaringClass());
        }
        //获取指定字段名称的Field类,可以是任意修饰符的自动,注意不包含父类的字段
        Field field2 = clazz.getDeclaredField("desc");
        System.out.println("field2:" + field2);
        field2.set(student,"za");
        System.out.println("字段的值是=="+field2.get(student));
    }


}
@Data
class Person{
    public int age;
    public String name;
    //省略set和get方法
}
@Data
class Student extends Person{
    public String desc;
    private int score;
    //省略set和get方法
}