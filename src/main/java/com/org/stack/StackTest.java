/*
 *company:jlc
 *author:xudd
 *date:2020/5/19:18:28
 *desc:{}
 **/


package com.org.stack;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author:xudd
 * @date:2020/5/19 -18:28
 * @desc:
 **/
public class StackTest {



    public static void main(String[] args) {

        String str = "(AB(C(DE)F)(G((H)I J)K))";

        Stack<Integer> left = new Stack();
        int num= 0;

        char a[] =str.toCharArray();
        for(int i=0;i<a.length;i++  ){
            if(a[i]=='('){

                left.push(i);
                num=num+1;
                System.out.println("left偷偷看一下栈顶的元素:"+left.peek());
            }else if(a[i]==')'){
                left.push(i);
                num=num+1;
            }
        }

          System.out.println("总数据是"+num);
            while(!left.empty()){

                System.out.println("弹出的左括号位置:"+left.pop());
            }




    }
}
