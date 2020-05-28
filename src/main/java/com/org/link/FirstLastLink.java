/*
 *company:jlc
 *author:xudd
 *date:2020/5/28:19:45
 *desc:{}
 **/


package com.org.link;

import com.sun.xml.internal.ws.api.message.stream.InputStreamMessage;

/**
 * @author:xudd
 * @date:2020/5/28 -19:45
 * @desc: 双端链表
 **/
public class FirstLastLink {

    /**ref to first link*/
    private Dlink first;
    /**ref to last link*/
    private Dlink last;

    public FirstLastLink(){

        first=null;
        last=null;

    }

    public boolean isEmpty(){

        return first==null;

    }

    public void insertFirst(long dd){

        Dlink dlink = new Dlink(dd);

        if(isEmpty()){

            first=dlink;
            last=dlink;
        }else{
            dlink.next=first.next;
            first=dlink;
        }


    }

    /**insert at end of list*/
    public void insertLast(long dd){
        Dlink newLink = new Dlink(dd);

        if(isEmpty()){
            first=newLink;
            last=newLink;
        }else {
            last.next=newLink;
            last=newLink;
        }

    }

    /**从头删出*/
    public long deleteFirst(){

        long temp=first.dData;
        if(first.next==null){
         last=null;
         first=first.next;

        }

        return temp;

    }
}
