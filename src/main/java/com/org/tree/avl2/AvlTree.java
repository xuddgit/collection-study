/*
 *company:jlc
 *author:xudd
 *date:2020/6/17:14:56
 *desc:{}
 **/


package com.org.tree.avl2;

/**
 * @author:xudd
 * @date:2020/6/17 -14:56
 * @desc:
 *
 * 总结：
 *   AVL树在了解情况
 *   4中
 *
 *   X节点的
 *   1.左节点的左子树插入节点
 *
 *   2.右节点的右子树插入节点
 *
 *   3. 左节点的右子树插入节点
 *
 *   4. 右节点的左子树插入节点
 *
 *   这种对不平衡非常敏感的结构-可以容忍的高度差仅仅为1.
 *   这虽然可以让树尽可能的平衡，使查找效率尽可能高，但也付出了相应的
 *   代价：调整平衡。
 *
 *   它的插入元素引发的调整的最坏时间复杂度O(1),但是删出元素引发的最坏时间复杂度O(longN)
 *   ，这正是AVL树的弊端所在。
 *   所以后来的2-3树，2-3-4 树，红黑树都尝试针对这种弊端进行了改进，改进的思路可以大概
 *    理解为两种：
 *    1.使树完全平衡
 *      这是2-3树，和2-3-4树这两种结构尝试的方向。因为造成AVL树删出时，“学霸的原因”
 *      正是因为它能容忍这一点的高度差，在高度差大量积累后，删出“薄弱”侧的节点，
 *      就会导致需要大量的调整才能恢复平衡。而如果完全消除高度差就可以避免这种情况了。
 *    2. 容忍不平衡
 *       红黑树的思路的核心是增大了可容忍的高度差，从而实现既保证查询效率O(logN)，也保证了
 *       插入和删出后调整平衡的效率O(1).
 *
 *        红黑树的查询效率 2*O(logN)是略低于AVL树的O(logN)的，但是
 *        红黑树通过牺牲了少许查询效率，使插入删出后的调整效率达到了常数基本。
 *
 *        红黑树算法种的着色策略，对于父节点，叔节点，祖父节点等颜色的判断，以及相应的
 *        调整策略都是经过极度抽象后的结果，因此想要从头到尾彻底理解红黑树的设计思想其实
 *        还是有些难度的
 * 参考如下链接
 * @{link https://segmentfault.com/a/1190000019101902}
 *
 **/
public class AvlTree <T extends Comparable<T>>{


    /**最大高度差*/
    private static final  int MAX_HEIGHT_DIFFERENCE=1;

    private Node<T> root;

    class Node<KT> {
        KT key;

        Node<KT> left;

        Node<KT> right;

        int height = 1;

        public Node(KT key, Node<KT> left, Node<KT> right) {
            this.key = key;

            this.left = left;
            this.right = right;

        }
    }
        /**
         * @author: xudd
         * @desc: 树的初始化构建
         * @date: 15:10 2020/6/17
         * @param:
         * @return:
         **/
        public AvlTree(T ...keys){

            if(keys ==null || keys.length<1){


                throw  new NullPointerException();

            }

            root = new Node<>(keys[0],null,null);

            for(int i=1;i<keys.length&&keys[i]!=null ;i++){

                root = insert(root,keys[i]);


            }
        }

    /**
     * @author: xudd
     * @desc: 二分 查找元素
     * @date: 15:12 2020/6/17
     * @param:
     * @return:
     **/
    public T find(T key){

     if(key==null||root==null){


         return null;

     }

     return find(root,key,key.compareTo(root.key));

    }

    /**
     * @author: xudd
     * @desc: //TODO
     * @date: 15:24 2020/6/17
     * @param: node
     * @param: key
     * @param: cmp
     * @return: T
     **/
    private T find(Node<T> node,T key,int cmp){
        if(node==null){
            return null;
        }
        if (cmp==0){
            return node.key;

        }
        return find((node=cmp>0?node.right:node.left),key,node==null?0:key.compareTo(node.key));
    }



    public void insert(T key){
        if(key==null){

            throw  new NullPointerException();

        }
        root = insert(root,key);
    }

    private Node<T> insert(Node<T> node,T key){

        if(node==null){
            return new Node<>(key,null,null);
        }
        int cmp = key.compareTo(node.key);
        //不应该存在等于的情况，约定不存在相等的情况
        if(cmp==0){

            return node;

        }
        if(cmp<0){

            node.left=insert(node.left,key);

        }else{
            node.right=insert(node.right,key);
        }

        if(Math.abs(height(node.left)-height(node.right))>MAX_HEIGHT_DIFFERENCE){

            node = balance(node);

        }

        refreshHeight(node);

         return node;

    }


     private int height(Node<T> node){

        if(node ==null){
            return 0;
        }
        return node.height;

     }

     /**
      * @author: xudd
      * @desc: 刷新节点的高度
      * @date: 15:40 2020/6/17
      * @param:
      * @return:
      **/
     private void refreshHeight(Node<T> node){
        node.height=Math.max(height(node.left),height(node.right))+1;

     }

    private Node<T>balance(Node<T> node){
         Node<T> node1,node2;
          //LL-L
         if(height(node.left)>height(node.right)
                 &&height(node.left.left)>height(node.left.right)){
            node1 = node.left;
            node.left=node1.right;
            node1.right=node;

            refreshHeight(node);
             return  node1;

         }
         //L-R
         if(height(node.left)>height(node.right)
                 &&height(node.left.right)>height(node.left.left)){
             node1 = node.left;
             node2 = node.left.right;
             node.left=node2.right;
             node1.right=node2.left;
             node2.left=node1;
             node2.right=node;
             refreshHeight(node);
             refreshHeight(node1);
              return node2;

         }
         //RR&R
         if(height(node.right)>height(node.left)
                 &&height(node.right.right)>=height(node.right.left)){
             node1= node.right;

             node.right=node1.left;
             node1.left=node;
             refreshHeight(node);
             return node1;
         }

         //r-l
         if(height(node.right)>height(node.left)
                 &&height(node.right.left)>height(node.right.right)){

             node1=node.right;
             node2 = node.right.left;
             node.right = node2.left;
             node1.left=node2.right;
             node2.left=node;
             node2.right=node1;
             refreshHeight(node);
             refreshHeight(node1);
            return  node2;

         }
         return node;

    }


    private Node<T> remove(Node<T> node, T key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        }
        if (cmp > 0){
            node.right = remove(node.right, key);
        }
        if (cmp == 0) {
            if (node.left == null || node.right == null) {
                return node.left == null ? node.right : node.left;
            }
            T successorKey = successorOf(node).key;
            node = remove(node, successorKey);
            node.key = successorKey;
        }

        if (Math.abs(height(node.left) - height(node.right)) > MAX_HEIGHT_DIFFERENCE) {
            node = balance(node);
        }
        refreshHeight(node);
        return node;
    }

    private Node<T> successorOf(Node<T> node) {
        if (node == null) {
            throw new NullPointerException();
        }
        if (node.left == null || node.right == null) {
            return node.left == null ? node.right : node.left;
        }

        return height(node.left) > height(node.right) ?
                findMax(node.left, node.left.right, node.left.right == null) :
                findMin(node.right, node.right.left, node.right.left == null);
    }

    private Node<T> findMax(Node<T> node, Node<T> right, boolean rightIsNull) {
        if (rightIsNull) {
            return node;
        }
        return findMax((node = right), node.right, node.right == null);
    }

    private Node<T> findMin(Node<T> node, Node<T> left, boolean leftIsNull) {
        if (leftIsNull) {
            return node;
        }
        return findMin((node = left), node.left, node.left == null);
    }






}
