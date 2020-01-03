/*
 *company:jlc
 *author:xudd
 *date:2020/1/3:14:46
 *desc:{}
 **/


package com.org.annation;

import lombok.Data;

/**
 * @author:xudd
 * @date:2020/1/3 -14:46
 * @desc:
 **/
@Data
@DBTable(name = "MEMBER")
public class Member {
    //主键ID
    @SQLString(name = "ID",value = 50, constraint = @Constraints(primaryKey = true))
    private String id;

    @SQLString(name = "NAME" , value = 30)
    private String name;

    @SQLInteger(name = "AGE")
    private int age;

    @SQLString(name = "DESCRIPTION" ,value = 150 , constraint = @Constraints(allowNull = true))
    private String description;
    //个人描述


}
