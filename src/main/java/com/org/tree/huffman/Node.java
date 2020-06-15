package com.org.tree.huffman;


import lombok.Data;

@Data
public class Node {

    /**左子树*/
    private   Node left;
    /**右子树*/
    private Node right;

    /**节点出现的频率*/
    private int frequency;
    /**节点对应的字符*/
    private     String data;



}
