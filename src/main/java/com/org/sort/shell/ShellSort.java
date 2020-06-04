/**
 *company:jlc
 *author:xudd
 *date:2020/6/4:14:42
 *desc:{}
 **/


package com.org.sort.shell;


/**
 * @author:xudd
 * @date:2020/6/4 -14:42
 * @desc:希尔排序
 **/
public class ShellSort {

    private long [] theArray;
    /**数据的数量*/
    private int nElems;

    public ShellSort(int max){

        theArray=new long [max];
        nElems=0;
    }

    /**
     * @author: xudd
     * @desc: 往数组中放元素
     * @date: 14:52 2020/6/4
     * @param:
     * @return:
     **/
    public void insert(long value){
        theArray[nElems]=value;
        nElems++;
    }

    /**
     * @author: xudd
     * @desc:希尔排序
     * @date: 14:54 2020/6/4
     * @param: initValue
     * @return:
     **/
    public void shellSort(int initValue){
        /**定义两个变量*/

        int inner=0 ,outer;
        long temp=0;
        /**设置初始值,初始值的计算有常见几种策略.目前采取的策略是大于数组的三分之一作为初始值*/
        int h=1;
        while(h<=nElems/initValue){
           h = h*3+1;
        }
        while(h>0){
          for(outer=h;outer<nElems;outer++){
              temp= theArray[outer];
              inner = outer;
              while(inner>h-1&&theArray[inner-h]>=temp){
                  theArray[inner]= theArray[inner-h];
                  inner-=h;
              }
              theArray[inner]=temp;
          }
            h=(h-1)/initValue;

        }
    }


    public static void main(String[] args) {
        int maxSize=10;
        ShellSort shellSort = new ShellSort(10);

        for(int j=0;j<maxSize;j++){
            long n= (int) (Math.random()*99);
            shellSort.insert(n);
            System.out.println("排序前的数据："+n);

        }
        shellSort.shellSort(3);

        for(int i=0;i<maxSize;i++){

            System.out.println("排序后的数据:"+shellSort.theArray[i]);

        }

    }


}
