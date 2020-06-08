package com.org.tree;

import lombok.Data;

/**
 * 二叉树节点
 *
 * */
@Data
public class Node {
    /**左节点*/
    private  Node leftNode;
    /**右节点*/
    private Node rightNode;

    /**数据*/
    private  int data;


}
