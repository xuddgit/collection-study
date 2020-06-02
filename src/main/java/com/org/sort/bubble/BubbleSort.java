package com.org.sort.bubble;


import java.util.Objects;

/**冒泡排序*/
public class BubbleSort {



   public static void sort(int []a ){
       for(int i=a.length-1;i>0;i-- ){

           for(int j=0;j<i;j++){

               if(a[j]>a[j+1]){
                  //如果前面的大于后面的进行交换
                   int temp =a[j];
                   a[j]=a[j+1];
                   a[j+1]=temp;

               }

           }

       }

   }


    public static void main(String[] args) {
        int array[]= {5,9,6,3,4,2};
        BubbleSort.sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }


}
