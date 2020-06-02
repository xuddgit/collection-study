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


   public static int currion(int n){
       System.out.println("当前执行到n="+n);
        if(n==1){
            return 1;
        }

        return currion(n-1)+n;

    }

    public static void main(String[] args) {
        int n=3;
       System.out.println("最后求的第三项="+currion(n)); ;

    }

}
