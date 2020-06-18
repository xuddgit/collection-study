package com.org.tree.avl3;

import lombok.Data;

public class AVLTree<E extends Comparable<E>> {
    // 树根结点

    private Node<E> root;

    public Node<E> getRoot(){

        return root;
    }

    // 向树中插入数据
    public Node<E> add(E element) {
        return root = insert(element, root);
    }

    // 删除树中值为element的元素
    public Node<E> delete(E element) {
        return root = remove(element, root);
    }

    // 前序遍历树
    public void print() {
        print(root);
    }

    /**
     * 向树中插入数据
     *
     * @param element 数据的值
     * @param node    树的根结点
     * @return 返回插入数据后的树的根结点
     */
    private Node<E> insert(E element, Node<E> node) {
        if (node == null) {
            return new Node<>(element);
        }

        if (element.compareTo(node.element) < 0) {
            node.left = insert(element, node.left);
        } else if (element.compareTo(node.element) > 0) {
            node.right = insert(element, node.right);
        }

        calcHeight(node);
        return balance(node);
    }

    /**
     * 删除树中的元素
     *
     * @param element 要删除的元素值
     * @param node    树的根结点
     * @return 返回删除后的树根结点
     */
    private Node<E> remove(E element, Node<E> node) {
        if (node == null || (node.left == null && node.right == null)) {
            return null;
        }

        if (element.compareTo(node.element) < 0) {
            node.left = remove(element, node.left);
        } else if (element.compareTo(node.element) > 0) {
            node.right = remove(element, node.right);
        } else {
            if (node.right == null) {// 右空左不空
                node = node.left;
            } else if (node.left == null) {// 左空右不空
                node = node.right;
            } else {//左右都不空，则取出右子树最小结点，并用来替换根结点
                Node<E> rightMin = searchMin(node.right);
                node.element = rightMin.element;
                node.right = remove(rightMin.element, node.right);
            }
        }
        calcHeight(node);
        return balance(node);
    }

    /**
     * 打印以node为树根的树
     *
     * @param node 树根
     */
    private void print(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.element + " , height = " + node.height);
        print(node.left);
        print(node.right);
    }

    /**
     * AVL树的结点类
     *
     * @param <E>结点值的类型
     */
     @Data
     class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        int height;

        public Node(E element) {
            this.element = element;
        }
    }

    private Node<E> searchMin(Node<E> node) {
        assert node != null;

        if (node.left != null) {
            return searchMin(node.left);
        }
        return node;
    }

    /**
     * 计算结点的高度
     *
     * @param node 要计算的节点
     * @return 返回节点高度
     */
    private int height(Node<E> node) {
        return node == null ? -1 : node.height;
    }

    private void calcHeight(Node<E> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * 左旋
     *
     * @param node 要旋转的子树的根结点
     * @return 返回旋转后的子树的根结点
     */
    private Node<E> leftRotate(Node<E> node) {
        Node<E> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        calcHeight(node);
        calcHeight(newNode);
        return newNode;
    }

    /**
     * 右旋
     *
     * @param node 要旋转的子树的根结点
     * @return 返回旋转后的子树的根结点
     */
    private Node<E> rightRotate(Node<E> node) {
        Node<E> newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        calcHeight(node);
        calcHeight(newNode);
        return newNode;
    }

    /**
     * 先左旋再右旋
     *
     * @param node 要旋转的子树的根结点
     * @return 返回旋转后的子树的根结点
     */
    private Node<E> leftAndRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    /**
     * 先右旋再左旋
     *
     * @param node 要旋转的子树的根结点
     * @return 返回旋转后的子树的根结点
     */
    private Node<E> rightAndLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    /**
     * 让以node为根结点的树恢复平衡
     *
     * @param node 根结点
     * @return 返回恢复平衡后的树的根结点
     */
    private Node<E> balance(Node<E> node) {
//        assert node != null;
        if (height(node.left) - height(node.right) == 2) {
            if (height(node.left.left) > height(node.left.right)) {
                // 需要进行右旋转
                return rightRotate(node);
            } else {// 需要左旋再右旋
                return leftAndRightRotate(node);
            }
        } else if (height(node.right) - height(node.left) == 2) {
            if (height(node.right.right) > height(node.right.left)) {
                // 需要进行左旋转
                return leftRotate(node);
            } else {// 需要右旋再左旋
                return rightAndLeftRotate(node);
            }
        }
        return node;
    }
}
