package com.org.tree.avl2;

import lombok.Data;

@Data
public class AVLTreeNode {

    private int data;

    private int height;

    private AVLTreeNode left;

    private AVLTreeNode right;

}
