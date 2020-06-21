package com.org.tree.tree234;
/**
 *
 *
 *
 * */
public class Node {

    private  static  final int ORDER=4;

    private int numItems;

    private Node parent;

    private Node childArray[] = new Node[ORDER];



    private DataItem itemArray[] = new DataItem[ORDER-1];

    //connect child to this node
    public void connectChild(int childNum,Node child){
        childArray[childNum]= child;
        if(child!=null){
            child.parent=this;

        }

    }
    //disconnect child from this node ,return it
    public Node disconnectChild(int childNum){
      Node tempNode = childArray[childNum];
        childArray[childNum]=null;
        return tempNode;
    }

    public Node getChild(int childNum){
        return childArray[childNum];

    }

    public Node getParent(){

        return parent;
    }

    //判断是否是叶子节点
    public boolean isLeaf(){

        return (childArray[0]==null?true:false);
    }

    public int getNumItems(){

        return numItems;
    }


    //get DataItem at index
    public DataItem getItem(int index ){
      return itemArray[index];

    }

    public boolean isFull(){

       return (numItems==ORDER-1)?true:false;
    }

    public int findItem(long key){
        //item (within node)
        //if found , otherwise return -1;
      for(int j=0;j<ORDER-1;j++){
        if(itemArray[j]==null){

            break;
        }else if (itemArray[j].dData==key)
          return j;
      }
        return -1;
    }

    public int insertItem(DataItem newItem){
        //assumes node is not full
        //will add new item
        numItems ++;
        long newKey = newItem.dData;
        //从右边开始 检验items
        for(int j=ORDER-2;j>=0;j--){
            //如果item 是空的
           if(itemArray[j]==null){
              continue;

           }else  {
               //从 左边来搞
               long itsKey = itemArray[j].dData;
               //如果新的节点的数据大于当前节点的数据
               if(newKey<itsKey){
                   //切换右边
                itemArray[j+1]=itemArray[j];

               }else{
                   //插入新的item
                  itemArray[j+1]=newItem;
                  return j+1;

               }

            }
        }
        itemArray[0]= newItem;
        return 0;
    }



    public DataItem removeItem(){
        //删除最大的 item
        //假定node 节点不为空
        //先将值保存起来
        DataItem temp = itemArray[numItems-1];
        //取消对象的指向
        itemArray[numItems-1]=null;
        //减少item
        numItems--;
        //返回
        return temp;

    }


   public void displayNode(){
        for(int j=0;j<numItems;j++){

            itemArray[j].displayItem();;
            System.out.println("/");

        }


   }



}
