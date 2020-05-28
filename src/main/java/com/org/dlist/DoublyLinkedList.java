package com.org.dlist;

public class DoublyLinkedList {


    private Link first;

    private Link last;

   public DoublyLinkedList(){

       first=null;
       last=null;
   }


   public boolean isEmpty(){

    return first==null;

   }


   public void insertFirst(long dd){

       Link newLink = new Link(dd);

    if(isEmpty()){
        first=newLink;
        last=newLink;

    }else {
        /**暂存first原来指的对象*/
        Link plink= first;
        /**将新的节点赋值给first*/
        first=newLink;
        /**给first的next赋值plink;*/
        first.next=plink;
        /**将原来的头节点的next指向新来的节点*/
        plink.prrvious=newLink;

    }

   }

   /***在最后一个节点插入
    ***/
   public void insertLast(long dd){
       Link newLink = new Link(dd);
       if(isEmpty()){
           first=newLink;
           last=newLink;
       }else{
          /**得到最后一个节点的前驱节点*/
        last.next=newLink;
        /**设置新加入的节点的前驱是最后一个节点*/
         newLink.prrvious=last;
         /**将最后一个最后加入的节点赋值给last*/
           last=newLink;

       }


   }



  public Link deleteFirst(){

       /**假定链表不为空*/

       if(isEmpty()){

           return  null;
       }



      Link temp = first;
       if(first.next==null){
           last =null;
           first=null;

       }else{
           Link tempNext=first.next;
           first =tempNext;
           tempNext.prrvious=null;

       }
      return temp;


  }



}
