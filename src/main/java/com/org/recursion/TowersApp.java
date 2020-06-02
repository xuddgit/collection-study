/*
 *company:jlc
 *author:xudd
 *date:2020/6/1:17:48
 *desc:{}
 **/


package com.org.recursion;

/**
 * @author:xudd
 * @date:2020/6/1 -17:48
 * @desc:
 **/
public class TowersApp {

    static  int nDisks=3;

    public static void main(String[] args) {
        doTower(nDisks,'A','B','C');
    }



    public static void doTower(int topN,char from ,char inter,char to){

        if(topN==1){
          System.out.println("Disk 1 from "+ from +" to "+ to);

        }else{
            /**from -->inter*/
            doTower(topN-1,from,to,inter);

            System.out.println("disk "+ topN+" from "+from+" to "+to);

            doTower(topN-1,inter,from,to);
        }

    }
}
