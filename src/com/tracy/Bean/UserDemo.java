/**
 * 
 */
package com.tracy.Bean;

import java.util.Date;

/**
 * @author tracy.lu
 * @date:2016年3月24日 下午7:41:31
 * @version :
 */
public class UserDemo {

    private int  x;
    private Date birthday = new Date();

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}
