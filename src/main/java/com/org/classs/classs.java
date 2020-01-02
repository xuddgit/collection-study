/*
 *company:jlc
 *author:xudd
 *date:2020/1/2:11:35
 *desc:{}
 **/


package com.org.classs;

/**
 * @author:xudd
 * @date:2020/1/2 -11:35
 * @desc:
 **/
public class classs {

    public static void print(Object obj) {
        System.out.println(obj);
    }
    public static void main(String[] args) {
        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("com.org.classs.Gum");
        } catch(ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"com.org.classs.Gum\")");
        new Cookie();
        print("After creating Cookie");
    }



}
class Candy {
    static {   System.out.println("Loading Candy"); }
}

class Gum {
    static {   System.out.println("Loading Gum"); }
}

class Cookie {
    static {   System.out.println("Loading Cookie"); }
}

