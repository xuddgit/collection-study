/*
 *company:jlc
 *author:xudd
 *date:2020/6/3:10:16
 *desc:{}
 **/


package com.org.sort.merge;

/**
 * @author:xudd
 * @date:2020/6/3 -10:16
 * @desc:
 **/
public class MergeSort {

    public static void mergeSort(int []array){


        if(array==null ||array.length==0){
            return;
        }

        int[]temp = new int[array.length];
        mergeSort(array,0,array.length-1,temp);


    }


   /***归并--或者叫拆分*/
   private static void mergeSort(int array[],int first,int last,int temp[]){
        if(first<last){

            int mid =first+last/2;
           /**递归左边元素*/
            mergeSort(array,first,mid,temp);
            /**递归右边元素*/
            mergeSort(array,mid+1,last,temp);
            /**再将二哥有序数列合并*/
            mergeArray(array,first,mid,last,temp);
        }

   }

   private  static  void mergeArray(int array[],int first,int mid ,int last,int temp[]){
    //i为第一组的起点，j为第二组的起点
    int i=first,j=mid+1;
     //m为第一组终点，n为第二组终点
    int m = mid ,n=last;
    //K用于指向temp数组当前放到哪个位置
    int k=0;
    //将两个有序序列循环比较，填入数组temp
    while(i<=m&&j<=n){
        if(array[i]<=array[j]){
            temp[k++]=array[i++];

        }else{

            temp[k++]=array[j++];
        }

    }

    while(i<=m){
    temp[k++]=array[i++];
    }

    while(j<=n){

        temp[k++]=array[j++];
    }

    for(i=0;i<k;i++){

        array[first+i]=temp[i];

    }

   }

}
