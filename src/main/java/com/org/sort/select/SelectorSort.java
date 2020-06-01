package com.org.sort.select;


/**
 *选择排序
 *
 * 排序算法描述
 *    选择排序  假定第一个 位置的数值最小，然后依次和后面的元素
 *    对比，当后面的元素小于它，进行交换。依次往后面推
 *
 *
 * */
public class SelectorSort {


      /**选择排序*/
      public static void select(int array[]){

          for(int i=0 ;i<array.length-1;i++){

             for(int j=i+1;j<array.length;j++){

               if(array[i]>array[j]){
                   int temp= array[i];
                   array[i]=array[j];
                   array[j]=temp;
               }

             }

          }


      }


    public static void main(String[] args) {

          int []a = new int[5];
        a[0]=6;
        a[1]=3;
        a[2]=5;
        a[3]=7;
        a[4]=0;
        select(a);

        for (int i : a) {
            System.out.println(i);
        }
    }


}
