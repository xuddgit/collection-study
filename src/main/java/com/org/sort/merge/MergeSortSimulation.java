package com.org.sort.merge;

public class MergeSortSimulation {

    public static void main(String[] args) {
        /**在排序钱，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间*/

        int[] arrayA = {23,47,81,95};
        int [] arrayB = {7,14,39,55,62,74};

        int [] arrayC = new int[10];

        merge(arrayA,4,arrayB,6,arrayC);
        for(int i=0;i<arrayC.length-1;i++){

            System.out.println(arrayC[i]);
        }
    }


   public static void merge(int []arrayA,int sizeA,int[] arrayB,
                            int sizeB,int []arrayC){

        int aDex=0,bDex=0,cDex=0;
        /**当两个数组都不为空*/
        while(aDex<sizeA&&bDex<sizeB){
            /***如果数组A的最小值，小于数组B的最小值*/
           if(arrayA[aDex]<arrayB[bDex]){
               /***将数组A的下标为aDex的值，赋予C 的下标为Cdex的值；然后A的下标和
                * C的下标都+1*/
               arrayC[cDex++]=arrayA[aDex++];

           }else{
               /***将数组B的下标为bDex的值，赋予C 的下标为Cdex的值；然后A的下标和
                * C的下标都+1*/
               arrayC[cDex++]=arrayB[bDex++];
           }
        }
           /**arrayB 是空的 ，但是arrayA不是空的*/
           while(aDex<sizeA){

               arrayC[cDex++]= arrayA[aDex++];
           }
            /**ArrayA是空的，但是arrB不是空的*/
           while(bDex<sizeB){
             arrayC[cDex++]=arrayB[bDex++];

           }


   }







}
