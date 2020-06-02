/*
 *company:jlc
 *author:xudd
 *date:2020/6/2:10:07
 *desc:{}
 **/


package com.org.sort.insert;

/**
 * @author:xudd
 * @date:2020/6/2 -10:07
 * @desc:
 **/
public class InsertSort {


    /**
     * @author: xudd
     * @desc:  插入排序 ：描述  假定前几个是
     * 排好序的，然后依次往后面走
     * @date: 10:08 2020/6/2
     * @param:
     * @return:
     **/
    public static void insert(int array[]){

        for(int i=array.length-1;i>1;i-- ){

            for(int j=0;j<i;j++){

                if(array[j]>array[j+1]){
                    int temp =array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                }

            }

        }

    }


    public static void main(String[] args) {
        int array[] = new int[10];
        array[0]=77;
        array[1]=99;

        array[2]=44;

        array[3]=55;

        array[4]=22;

        array[5]=88;

        array[6]=11;
        array[7]=0;
        array[8]=66;
        array[9]=33;

        insert(array);

        for(int i=0;i<array.length-1;i++){

            System.out.println(array[i]);

        }

    }



}
