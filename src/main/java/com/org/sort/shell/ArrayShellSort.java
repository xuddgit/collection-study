package com.org.sort.shell;

/**
 *
 * @author xudongdong
 * @date :2020-06-03
 * @desc:希尔排序
 *
 *
 * **/
public class ArrayShellSort {
    /**ref to array the Array*/
    private long [] theArray;
    /**number of data items*/
    private int nElems;
    /**构造函数**/
    public ArrayShellSort(int max){
        //create the array
        theArray= new long[max];
        //no items yet
        nElems=0;
    }

    //put element into array
    public void insert(long value){
        //insert it
        theArray[nElems]= value;
        //increment size
        nElems++;

    }



    public void shellSort(int []array){
      int inner ,outer;

        long temp;

      int h=1;
      /**1.步骤一：计算出 h的值，本程序采用三分之一的方案
       * 即 最长的步长占长度的三分之一开头，
       * 看其他的设计也有二分支一的
       *
       * */
      while(h<=nElems/3){
          h=h*3+1;
      }
      /**
       * 减h 直到减到h=1
       * */
      while(h>0){
          /**当h大于0，且outer小于数组长度的时候
           *
           *，按照步长h*/
         for(outer=h;outer<nElems;outer++){
             /**拿临时变量 存储 下标为outer的数组的值*/
             temp = theArray[outer];
             /**把outer下标赋值给inner*/
             inner = outer;
             //在次类上 ，不懂啥意思？！！！！
             while(inner >h-1&&theArray[inner-h]>=temp){
                 theArray[inner]= theArray[inner-h];
                 inner=h;

             }
             theArray[inner]=temp;

         }
         //decrease h
         h=(h-1)/3;

      }


    }






}
