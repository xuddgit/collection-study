package com.org.matrix;

public class Matrix {

    /**
     *
     * 矩阵
     * 矩阵底层基本上采用 一维数组来表示
     * ***/
    /**矩阵行数，矩阵列数*/
    private  int rows,columns;
    /**
     * 构造m*n 零矩阵，若m或者n为负数，Java破案出
     * 数组长度异常
     *
     *
     * */
    private int [][] element;



    public Matrix(int m,int n){
       this.element= new int [m][n];
        this.rows=m;
        this.columns=n;
    }
    /**
     * 构造n*n零方阵
     * */
  public Matrix(int n){

        this(n,n);

  }


  /**
   * 构造m*n矩阵，由value[][]提供元素
   *
   * */
  public Matrix(int m,int n ,int[][]value) {

      this(m, n);
      //value 元素不足的时候补0，忽略多余元素
      for (int i = 0; i < value.length && i < m; i++) {

          for (int j = 0; j < value[i].length && j < n; j++) {

              this.element[i][j] = value[i][j];

          }

      }
  }
      /**
       * 返回矩阵行数
       *
       * **/
      public int getRow(){

        return this.rows;

      }
      /**
       *
       * 返回矩阵列数
       * **/
      public int getColumns(){

         return this.columns;
      }
      /**
       * 返回矩阵第i行第j列元素.若i,j越界，抛出序号越界异常
       *
       * */
      public int get(int i,int j){

         if(i>=0&&i<this.rows&&j>=0&&j<=this.columns){

             return this.element[i][j];

         }

          throw new IndexOutOfBoundsException("i="+i+"j="+j);
      }

      /**
       *设置矩阵第i行j列元素为x,若i,j越界，
       * 抛出序号越界异常
       * **/
      public void set(int i,int j,int x){
         if(i>=0&&i<this.rows&&j>=0&&j<this.columns){
             this.element[i][j]=x;

         } else{

             throw new IndexOutOfBoundsException("i="+i+",j="+j);
         }


      }


      public String toString(){
         String str = "矩阵"+this.getClass().getName()+"("+this.rows+"x"+this.columns+"):\n";
         for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                /**%6d格式表示十进制整数占6列*/
              str+=String.format("%6d",this.element[i][j]);

            }

            str +="\n";

         }
          return str;
      }

      /**
       *
       * 设置矩阵为m行n列。若参数指定行列数较大，则将矩阵扩容，并复制原矩阵元素
       *
       *
       * **/

      public void setRowsColumns(int m ,int n){
          if(m>0&&n>0){
             if(m>this.element.length||n>this.element[0].length){
               //参数指定的行数或者列数较大时，扩充二维数组容量
               int[][] source = this.element;
               //重新申请二维数组空间，元素初始值为0
               this.element= new int [m][n];
                 for(int i=0;i<this.rows;i++){
                     for(int j=0;j<this.columns;j++){
                         this.element[i][j]= source[i][j]   ;

                     }


                 }
                 this.rows=m;
                 this.columns=n;

             }
             else throw new IllegalArgumentException("矩阵行列数不能<=0,m="+m+"n="+n);

          }

      }

}
