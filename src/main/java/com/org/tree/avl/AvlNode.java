package com.org.tree.avl;

import lombok.Data;

/**
 *
 * AVL树的节点
 *
 * */
@Data
public class AvlNode {

    int data;
    /**左孩子*/
   private AvlNode lchild;
    /**右孩子*/
   private   AvlNode rchild;
     /**记录节点的高度*/
  private   int height ;


     /**
      * @author: xudd
      * @desc: 获取树的高度 【递归方法】
      * @date: 19:42 2020/6/15
      * @param:
      * @return:
      **/
    public int getTreeHeight(){

       int leftHeight=0;
       int rightHeight=0;
       //返回左子树高度
       if(lchild!=null){
           leftHeight=lchild.getTreeHeight();
       }
       //返回右子树高度
       if(rchild!=null){
           rightHeight=rchild.getTreeHeight();
       }
        return Math.max(leftHeight,rightHeight)+1;

    }


}
