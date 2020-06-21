package com.org.tree.heap;

/**
 * 堆是一种二叉树
 *
 * 特点定义： 节点的关键字大于等于子节点的关键字
 * 完全二叉树
 * 堆一般 采用数组方式来存储，且中间没有洞，也就是说不用有
 * 空数据占位
 * 堆中的每一个节点都满足的条件也就是说每一个节点的关键字
 * 都大于（或等于这个）阶段的子节点的关键字
 * */

public class Heap {

 private Node[] heapArray;
 /**最大的数组量*/
 private  int maxSize;

 /**当前数组的内容的大小*/
 private  int currentSize;


 public  Heap(int mx){
     maxSize =mx;

     currentSize =0;

     heapArray= new Node[maxSize];

 }

 public boolean isEmpty(){

     return currentSize ==0;
 }


 /***
  *
  * 元素插入步骤原理
  *  1.假设 数组不满，先将新插入元素放到数组末尾
  *  2.比较 根节点和 末尾元素的大小，如果
  *
  *
  *
  *
  * */
 public  boolean insert(int key){
    if(currentSize ==maxSize){
        return false;
    }
    Node newNode = new Node(key);

    heapArray[currentSize]=newNode;

    trickleUp(currentSize++);

    return true;

 }

 /**
  *
  *移动
  * */
 public void trickleUp(int index){
   int parent = (index-1)/2;

   Node bottom = heapArray[index];

   while (index>0&&heapArray[parent].getKey()<bottom.getKey()){

      heapArray[index]= heapArray[parent] ;
      index = parent;
      parent= (parent-1)/2;
   }

    heapArray[index]= bottom;

 }


 /**
  * 删除最大元素
  * 假定数组不为空
  *
  *
  *
  *
  * **/
 public  Node remove(){
     //1.先将根节点临时存储起来
     Node root = heapArray[0];
     //将 数组最后一个元素放到根节点的位置
     heapArray[0]= heapArray[--currentSize];

     trickleDown(0);
     //返回 删除的根元素的值
     return  root;


 }


 public void trickleDown(int index){

     int largerChild;
     //
     Node top = heapArray[index];

     while(index<currentSize/2){
       int leftChild = 2*index+1;

       int rightChild = leftChild +1;

       //查找最大的子节点

         if(rightChild<currentSize&&
         heapArray[leftChild].getKey()<
                 heapArray[rightChild].getKey()){
             largerChild = rightChild;

         }else{
             largerChild = leftChild;
             if(top.getKey()>=heapArray[largerChild].getKey()){
                 break;
             }
             heapArray[index]= heapArray[largerChild];
             index = largerChild;

         }
         heapArray[index]= top;

     }
 }

 /**
  *
  *
  *
  *
  * */
 public boolean change(int index,int newValue){

     if(index<0||index>=currentSize){

         return false;
     }
     //先临时存储 旧的值
     int oldValue = heapArray[index].getKey();
     //
     heapArray[index].setKey(newValue);

     if(oldValue<newValue){

         trickleUp(index);
     }else{
         trickleDown(index);
     }
     return  true;
 }

    public void dispalyHeap(){
       System.out.println("heapArray:");
      for(int m = 0;m<currentSize;m++){
          if(heapArray[m]!=null){

             System.out.println(heapArray[m].getKey()+" ");
          }else {

              System.out.println("--");
          }
          System.out.println();
      }

      int nBlanks = 32;
      int itemsPerRow =1;
      int column = 0;
      int j=0;
      String dots ="........";
      while(currentSize>0){
          if(column==0){
            for(int k=0;k<nBlanks;k++){

               System.out.println(' ');
            }

          }

      }

    }


}
