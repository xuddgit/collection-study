/*
 *company:jlc
 *author:xudd
 *date:2020/5/28:19:23
 *desc:{}
 **/


package com.org.link;

/**
 * @author:xudd
 * @date:2020/5/28 -19:23
 * @desc:
 **/
public class LinkList {
    /**ref to first link on list*/
    private Link first;

    public LinkList(){

        first=null;
    }
    /**true if list is empty*/
    public boolean isEmpty(){

        return (first==null);

    }

    public void insertFirst(int id ,double dd){
        Link newLink = new Link(id,dd);

        newLink.next=first;

        first=newLink;


    }

    /**delete first item*/
    public Link deleteFirst(){
        /**assumes list not empty
         * save reference to link
         *
         * */
        Link temp= first;

        first=first.next;
        /**return deleted link*/
        return temp;
    }


    public void displayList(){
        System.out.println("List (first ---》last)");
        /**start at beginning of list*/
        Link current=first;

        while(current!=null){
            current.displayLink();
            current=current.next;
        }
    }

}
