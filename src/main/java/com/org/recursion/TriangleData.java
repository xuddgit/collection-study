package com.org.recursion;


/**三角形数字
 *
 * 原理：
 * 第n项的值 = n-1项值+n获得
 *
 * */
public class TriangleData {



    public int recursion(int n){
      int total =0;

      while (n>0){

          total=total+n;
          n--;

      }
    return total;
    }



}
