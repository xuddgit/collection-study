package com.org.algorithm;


import java.util.Objects;

/**冒泡排序*/
public class BubbleSort {



   public static int [] sort(int []array ){
       if(Objects.isNull(array)){

         return array;

       }

       int temp;
       for(int i=1;i<array.length;i++){
           for(int j=0;j<array.length-1;j++){
            if(array[j]>array[j+1]){
                temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }
           }
       }
     return array;
   }


    public static void main(String[] args) {
        int array[]= {5,9,6,3,4,2};
        BubbleSort.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }


}
