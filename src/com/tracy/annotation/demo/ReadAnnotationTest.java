/**
 * 
 */
package com.tracy.annotation.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author tracy.lu
 * @date:2016年5月18日 下午5:31:08
 * @version :
 */
public class ReadAnnotationTest {

    /**
     * @param args
     * @throws ClassNotFoundException
     */
    // CREATE TABLE `t_message_email` (
    // `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    // `sender` varchar(50) NOT NULL COMMENT '发件人',
    //
    // )
    private static final String SINGLE_QUOTE = "'";
    private static final String CRLE         = "\n\t";

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("com.tracy.annotation.demo.UserEntity");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
        TableNameAnnotation table = (TableNameAnnotation) clazz.getAnnotation(TableNameAnnotation.class);
        String tableName = table.value();
        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(SINGLE_QUOTE).append(tableName).append(SINGLE_QUOTE).append(" (").append(CRLE);
        Field[] fields = clazz.getDeclaredFields();
        int i = 0;
        for (Field field : fields) {
            FieldNameAnnotation fa = field.getAnnotation(FieldNameAnnotation.class);
            sb.append(" ").append(SINGLE_QUOTE).append(fa.fieldName()).append(SINGLE_QUOTE).append(" ").append(fa.fieldType()).append("(").append(fa.fieldLength()).append(") ").append("COMMENT ").append(SINGLE_QUOTE).append(fa.comment()).append(SINGLE_QUOTE);
            if (++i != fields.length) {
                sb.append(",").append(CRLE);
            }
        }
        sb.append(CRLE).append(")");

        System.out.println(sb.toString());

    }
}
