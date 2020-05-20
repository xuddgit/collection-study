package com.org.algorithm;


/**直接插入排序*/
public class DirectInsertSort {
    /***排序算法描述
     * 假定前面的是排好序的，新来一个数据之后，从最后一个排好序的倒叙遍历
     * 遇到大于当前需要插入的数据后交换，然后继续，否则直接break跳出即可
     *
     * 4，5，3，2，0，10
     * 开始第一次 5与4比较 5大于4
     * 第二次 3与5比较3小于5 交换 4，3，5，2，0，10
     * 然后 继续 3与4比较 交换；break
     * 3,4,5,2,0,10
     *
     * 然后
     * 2
     * */

    public static void main(String[] args) {
        int a[]={4,5,3,2,0,10};
        insertSort(a);
        for(int i=0;i<a.length;i++){

            System.out.println(a[i]);
        }

    }


    public static void insertSort(int a[]){
        for(int i=1;i<a.length;i++){
            int temp =a[i] ;
            int j;
            for( j=i-1;j>=0;j--){

               if(a[j]>temp){
                   a[j+1]=a[j];
               }else{
                   break;
               }

            }
            a[j+1]=temp;

        }

    }

}
