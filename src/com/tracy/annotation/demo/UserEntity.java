/**
 * 
 */
package com.tracy.annotation.demo;

/**
 * @author tracy.lu
 * @date:2016年5月18日 下午5:16:08
 * @version :
 */
@TableNameAnnotation("tts_user")
public class UserEntity {

    @FieldNameAnnotation(fieldName = "user_name", fieldType = "varchar", fieldLength = 20, comment = "姓名")
    private String userName;
    @FieldNameAnnotation(fieldName = "id", fieldType = "int", fieldLength = 10)
    private int    id;
    @FieldNameAnnotation(fieldName = "age", fieldType = "int", fieldLength = 2, comment = "年龄")
    private long   age;
    //
    // public void setUserName(String userName) {
    // this.userName = userName;
    // }
    //
    // public void setId(int id) {
    // this.id = id;
    // }
    //
    // public void setAge(long age) {
    // this.age = age;
    // }
    //
    // public String getUserName() {
    // return userName;
    // }
    //
    // public int getId() {
    // return id;
    // }
    //
    // public long getAge() {
    // return age;
    // }

}
