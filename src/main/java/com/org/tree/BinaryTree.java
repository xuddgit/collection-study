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



  /**
   * 树节点的删出分为以下几种情况
   *  删出key为某个值的元素
   *  1.该节点是叶子节点（没有子节点）
   *  2.该节点有一个子节点
   *  3.该节点有两个子节点
   *  第一种最简单，第二种也是相对比较简单，第三种相当复杂
   *
   *  情况1：
   *     要删除叶子节点，只需要改变该节点父节点的对应子节点的值，由值线改节点
   *      改为null就可以了。要删出的节点仍然存在，但是它已经不是树的一部分了。因为Java语言有垃圾
   *     自动回收机制，所以不需要非得把节点本身给删掉。
   *  情况2：
   *      删出有一个子节点的节点 。只需要将原来父节点指向该节点的子节点即可。如果该节点为根节点
   *      则 需要root引用该节点
   *  情况3：删出有两个子节点的节点
   *        在二叉搜索树中的节点是按照升序的关键字值排排列的。对于每一个节点来说，比该节点的关键字
   *        值次高的节点是它的中序后继，可以简称该节点的后继。这个就是窍门了：删除有两个子节点的节点
   *        ，用它的中序后继来代替该节点。
   *
   * @author: xudd
   * @date: 19:12 2020/6/9
   * @param:
   * @return:
   **/
  public boolean delete(int key){
    Node current = root;
    Node parent= root;
    boolean isLeftChild=true;

    while(current.getData()!=key) {
        parent = current;
        //左子树
        if (key < current.getData()) {
            isLeftChild = true;
            current = current.getLeftNode();

        } else {
            isLeftChild = false;
            current = current.getRightNode();

        }
        if (current == null) {
            return false;
        }
    }
        //如果没有子节点，直接删除它就行了
        if(current.getLeftNode()==null&&current.getRightNode()==null){
            //如果是根节点，直接将根节点引用置空
            if(current==root){
              root=null;
            }else if(isLeftChild){
                parent.setLeftNode(current.getLeftNode());

            }else{
                parent.setRightNode(current.getRightNode());
            }

        }else if(current.getRightNode()==null){
         if(current==root){
             root=current.getLeftNode();

         }else if(isLeftChild){
             parent.setLeftNode(current.getLeftNode());

         }else{

             parent.setRightNode(current.getLeftNode());
         }

        }else if(current.getLeftNode()==null){

            if(current==root){
                root= current.getRightNode();
            }
            else  if(isLeftChild){
                parent.setLeftNode(current.getRightNode());
            }else{
                parent.setRightNode(current.getRightNode());
            }
        }else {
           //two childern ,so replace with inorder successor
            // 以中小遍历方式找出后继节点 后继节点定义即 比当前节点大的最小的节点
         Node successor = getSuccessor(current);

          if(current==root){

              root = successor;
          }
          else if(isLeftChild){

              parent.setLeftNode(successor);
          }else{

              parent.setRightNode(successor);
          }

           successor.setLeftNode(current.getLeftNode());


        }
         return true;

    }


    /**
     *
     *
     * */
    private  Node getSuccessor(Node delNode){

      Node successorParent = delNode;
      Node successor = delNode;
      Node current = delNode.getRightNode();
      while(current!=null){
          successorParent = successor;
          successor=current;
          current=current.getLeftNode();
      }

      if(successor!=delNode.getRightNode()){
          successorParent.setLeftNode(successor.getRightNode());
          successor.setRightNode(delNode.getRightNode());

      }

      return successor;
    }




}
