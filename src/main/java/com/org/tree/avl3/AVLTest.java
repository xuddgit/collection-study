package com.org.tree.avl3;

import com.alibaba.fastjson.JSON;

/**
 *
 * AVL树测试
 *
 * */
public class AVLTest {

        public static void main(String[] args) {
            AVLTree<Integer> tree = new AVLTree<>();
            tree.add(3);
            tree.add(2);
            tree.add(1);
            tree.add(4);
            tree.add(5);
            tree.add(6);
            tree.add(7);
            tree.add(10);
            tree.add(9);
            tree.add(8);
            System.out.println(JSON.toJSON(tree.getRoot()));
           // tree.print();
            System.out.println("=====================");
            //tree.delete(4);
           // tree.print();
        }







}
