package com.org.tree.avl;


/**
 *
 * AVL树
 *
 * */

public class AvlTree {




    static int height(AvlNode T){

        if(T==null){

         return -1;
        }else{
            return T.height;
        }


    }

    //左左型，右旋操作
    /**
     * 右旋操作原理
     *
     * 将当前节点当做当前节点的左孩子的右孩子
     *
     *
     * */
    static  AvlNode R_Rotate(AvlNode K2){
       AvlNode K1;

       //进行旋转

        K1= K2.lchild;

        K2.lchild = K1.rchild;

        K1.rchild=K2;
        //重新计算节点的高度
        K2.height = Math.max(height(K2.lchild),height(K2.rchild))+1;
        K1.height = Math.max(height(K1.lchild),height(K1.rchild))+1;

        return K1;
    }


    //进行左旋
    /**
     *
     *  左旋的基本逻辑
     *
     *   因子节点
     *
     *    将 因子节点的左子节点 提升为 因子节点的位置
     *
     * */

    static  AvlNode L_Rotate(AvlNode K2){
       AvlNode K1;
       /**K2 为因子节点   获取K2因子节点的 右节点
        * 用临时变量 K1来指定
        * */
       K1=K2.rchild;
       //将K1的左孩子 赋值于
       K2.rchild=K1.lchild;

       K1.lchild = K2;
       //重新计算高度

        K2.height = Math.max(height(K2.lchild),height(K2.rchild))+1;

        K1.height = Math.max(height(K1.lchild),height(K1.rchild))+1;
        return K1;

    }


  //左-右型，进行右旋，再左旋

    static  AvlNode R_L_Rotate(AvlNode K3){
        //先对其孩子进行左旋
        K3.lchild = R_Rotate(K3.lchild);

        //再进行右旋

        return L_Rotate(K3);
    }

    //右左型，先进行左旋，再右旋

    static  AvlNode L_R_Rotate(AvlNode K3){
      //先对孩子进行左旋
      K3.rchild = L_Rotate(K3.rchild);
      //再右旋
       return  R_Rotate(K3);

    }

    /** *
     * @author: xudd
     * @desc: 插入数值操作
     * @date: 9:57 2020/6/17
     * @param:  T 我理解的T为最初传输进来的根节点
     * @return:
     **/
    static AvlNode insert(int data,AvlNode T) {
        if (T == null) {
            T = new AvlNode();
            T.data = data;
            //初始化赋值
            T.lchild = null;
            T.rchild = null;

        } else if (data < T.data) {
            //如果数值 小于父节点 向左 节点 递归
            T.lchild = insert(data, T.lchild);
            //进行调整操作
            //如果左孩子的高度比右孩子大2,这个过程是在找平衡因子

            if (height(T.lchild) - height(T.rchild) == 2) {
                //左-左 型
                if (data < T.lchild.data) {
                    T = R_Rotate(T);

                } else {
                    //左右型
                    T = R_L_Rotate(T);
                }

            }
        } else if (data > T.data) {
            T.rchild = insert(data, T.rchild);
            //进行调整
            //右孩子比左孩子高度大2
            if (height(T.rchild) - height(T.lchild) == 2) {
                //右-右型
                if (data > T.rchild.data) {
                    T = L_R_Rotate(T);

                } else {
                    T = L_R_Rotate(T);

                }
            }


        }

        //否则，这个节点以及在树上存在了，我们什么也不做。
        //重新计算T的高度
        T.height = Math.max(height(T.lchild), height(T.rchild)) + 1;
        return T;

    }
}
