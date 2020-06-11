package com.org.tree.huffman;

/**
 * 哈夫曼编码
 *
 * 解析：
 *
 *    从根节点遇到0 向左遍历，遇到1 向右遍历，
 *
 *
 * 和创建
 *
 *    优先队列
 *
 *    字符出现的频率来决定优先级,出现频率越小的优先级越高
 *
 *    然后开始，删除优先队列中的 出现频率最小的节点,
 *
 *    两个节点之和新建一个 父节点，将父节点放入优先队列中。
 *    直到优先队列中只有一棵树。
 *
 *
 *
 * **/


public class HuffmanTree {

    /**码表，编码对照*/

   private String [] CodeTable= new String[4];

   /**根节点*/
   private Node root;




  /**
   * 遍历
   *
   *
   *
   * */
  public void iterator(){




  }



  /**构建哈夫曼树
   * 先根据出现的频率进行排序
   *
   * 然后不断的，删除节点，组成新节点，然后将新节点放入
   *
   * 多少次能搞定呢？
   *
   *
   *
   * */
  public void builderHuffman(){





  }





}
