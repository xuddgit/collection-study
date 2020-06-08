package com.org.tree;



/**
 *为什么要用到树呢？因为它通常结合了另外两种数据结构的优点：
 * 1.有序数组
 * 2.链表
 * 有序数组插入数据项太慢了，因为插入需要移动后续元素
 *
 *
 *
 * */
public class BinaryTree {
  /**树的根节点*/
 private  Node root;

  /**
   *
   * 根据key查找元素
   * */
  public Node find(int key){

      Node current = root;
      while(current!=null){

          if(current.getData()==key){

              return current;
          }
          if(key<current.getData()){

              current=current.getLeftNode();
          }
          if(key>current.getData()){

             current=current.getRightNode();
          }

      }
       return null;

  }



  /**
   *
   * 假定关键词key不存在重复数据
   * **/
  public void insert(int key){

    Node insertNode = new Node();
         insertNode.setData(key);
       Node current = root;
       Node parent;
      if(root==null){
          root = insertNode;
          return;

      }


         while(true){

             parent=current;

             if(key<current.getData()){
                 current=current.getLeftNode();

                 if(current==null){
                     parent.setLeftNode(insertNode);
                     return;
                 }
             }else {
                 current=current.getRightNode();
                 if(current==null){
                     parent.setRightNode(insertNode);
                     return;
                 }

             }


         }


  }

  /**
   * 中序遍历
   *  二叉搜索树最常用的遍历方式是中序遍历
   *   中序遍历搜索会使所有的节点按照关键字升序被访问到。
   *   如果希望在二叉树中创建有序的数据序列，这是一种方法。
   *  遍历步骤：
   *    遍历树最简单的方法是用递归的方法。用递归的方法遍历整棵树要用一个节点
   *    作为参数。初始化时，这个节点是根。这个方法只需要做三件事：
   *    1.调用资深来遍历节点的左子树。
   *    2.访问这个节点
   *    3.调用自身来遍历节点的右子树
   *
   *
   * **/
  public void inorder(Node nodeRoot){

      if(nodeRoot!=null){

          inorder(nodeRoot.getLeftNode());
          System.out.println("root.data"+nodeRoot.getData());
          inorder(nodeRoot.getRightNode());

      }


  }



  public void delete(int id){


  }


}
