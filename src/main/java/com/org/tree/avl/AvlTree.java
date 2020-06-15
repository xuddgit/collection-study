/*
 *company:jlc
 *author:xudd
 *date:2020/6/15:18:08
 *desc:{}
 **/


package com.org.tree.avl;

/**
 * @author:xudd
 * @date:2020/6/15 -18:08
 * @desc: AVL树
 *
 *描述 ：具有搜索二叉树的特点。
 *
 *二叉搜索树可能面对不平衡后性能急剧下降
 * 所以AVL树是想办法让 搜索二叉树平衡
 * 即左子树和右子树的高度差小于2
 *
 *
 **/
public class AvlTree {

    /**根节点*/
    private Node root;

    /**
     * @author: xudd
     * @desc: 获取节点高度
     * @date: 18:12 2020/6/15
     * @param:
     * @return:
     **/
    public int height(Node node) {

        int leftHeight = 0;

        int rightHeight = 0;
        //得到左子树的高度
        if (node != null && node.getLeft() != null) {
            leftHeight = node.getLeft().getHeight();

        }
        //得到右子树的高度
        if (node != null && node.getRight() != null) {

            rightHeight = node.getRight().getHeight();
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }
}
