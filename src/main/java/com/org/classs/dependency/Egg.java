/*
 *company:jlc
 *author:xudd
 *date:2019/12/11:17:32
 *desc:{}
 **/


package com.org.classs.dependency;

/**
 * @author:xudd
 * @date:2019/12/11 -17:32
 * @desc:
 **/
public class Egg {
    private Chicken chicken ;
    private int weight ;
    public Egg(){
        chicken = new Chicken() ;
        setWeight(1) ;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
