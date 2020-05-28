/*
 *company:jlc
 *author:xudd
 *date:2020/5/28:19:33
 *desc:{}
 **/


package com.org.link;

/**
 * @author:xudd
 * @date:2020/5/28 -19:33
 * @desc:
 **/
public class LinkListApp {

    public static void main(String[] args) {
        LinkList linkList= new LinkList();
        linkList.insertFirst(22,2.99);
        linkList.insertFirst(44,4.99);

        linkList.insertFirst(66,6.99);

        linkList.insertFirst(88,8.99);

        linkList.displayList();
        while(!linkList.isEmpty()){
           Link alink = linkList.deleteFirst();
           System.out.println("Deteleted ");
          alink.displayLink();
        }
    }





}
