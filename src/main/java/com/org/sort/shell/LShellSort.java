/*
 *company:jlc
 *author:xudd
 *date:2020/6/4:16:46
 *desc:{}
 **/


package com.org.sort.shell;

/**
 * @author:xudd
 * @date:2020/6/4 -16:46
 * @desc:
 **/
public class LShellSort {


    private static void shellSort(int []arr){

        int N=arr.length;

        /**进行分组,最开始时的增量(gap)为数组长度的一半*/
        for(int gap=N/2;gap>0;gap/=2){
            /**对各个分组进行插入排序*/
            for(int i=gap;i<N;i++){
                //将arr[i]插入到所在分组的正确位置上



            }

        }

    }


    private static void insertI(int []arr,int gap,int i){

        int inserted=arr[i];

        int j;
        //插入的时候按组进行插入（组内元素两两相隔gap）
        for(j=i-gap;j>=0&&inserted<arr[j];j-=gap){
            arr[j+gap]=arr[j];

        }
       arr[j+gap]=inserted;
    }



}
