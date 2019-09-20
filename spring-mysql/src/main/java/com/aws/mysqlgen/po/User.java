package com.aws.po;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * UserID编号
     */

    private String id;
    /**
     * UserName用户名称
     */
    private String name;
    /**
     * UserBirth用户生日
     */
    private Date birthday;
    /**
     * 描述
     */
    private String description;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",name=" + name +
                ",birthday=" + birthday +
                ",description=" + description + "}";
    }
}
