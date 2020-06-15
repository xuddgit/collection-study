/*
 *company:jlc
 *author:xudd
 *date:2020/6/15:18:06
 *desc:{}
 **/


package com.org.tree.avl;

import lombok.Data;

/**
 * @author:xudd
 * @date:2020/6/15 -18:06
 * @desc: 节点
 **/
@Data
public class Node {
    /**高度*/
    private int height;
    /**左树*/
    private Node left;
    /**右树*/
    private Node right;



}
