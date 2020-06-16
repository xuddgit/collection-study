package com.org.tree.avl2;


/**
 * AVL树
 *
 * 具有二叉搜索树的特征 ，为了保证树的平衡性，
 * 规定 左右子树的高度差不能大于1
 *
 * 这样插入过程中就得通过旋转来达成
 *
 * 基本上有四种情况
 *
 * 1. 在节点X的左孩子节点的左子树中插入元素
 * 2. 在节点X的左孩子节点的右子树中插入元素
 * 3. 在节点X的右孩子节点的左子树中插入元素
 * 4. 在节点X的右孩子节点的右子树中插入元素
 *
 * 其中1 和4 对称
 *
 *  遇到1和4 的情况，单次旋转即可。
 *
 *
 * 2和 3对称
 *  遇到2 和3 需要两次旋转才能解决
 *
 *
 * */

public class AVLTree {


   /**单向左旋转*/
  AVLTreeNode SingleRotateLeft(AVLTreeNode X){
      //先获取 因子节点的 左孩子
      AVLTreeNode W =X.getLeft();
      //将 右孩子设置给左孩子的左节点
      X.setLeft(W.getRight());
      //设置 左孩子的右节点 为 因子节点
      W.setRight(X);
      //设置 高度
      X.setHeight(Math.max(Height(X.getLeft()),Height(X.getRight()))+1);
      //设置 高度
      W.setHeight(Math.max(Height(W.getLeft()),X.getHeight())+1);
      //新的根节点
      return W;

  }






  int Height(AVLTreeNode root){

      if(root ==null){

          return  -1;

      }else
          return root.getHeight();

  }


}
