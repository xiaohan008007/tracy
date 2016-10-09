package com.tracy.jdk6.complier;

import java.io.File;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Compiler {
         public static void main(String args[]) {
                   try {
                            JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
                            StandardJavaFileManager sjfm = jc.getStandardFileManager(null, null, null);


 
                            File javaFile = new File("D:\\workspace\\tracy\\src\\com\\tracy\\jdk6\\complier\\Hello.java");
                            Iterable fileObjects = sjfm.getJavaFileObjects(javaFile);
                            jc.getTask(null, sjfm, null, null, null, fileObjects).call();
                            // Add more compilation tasks
                            sjfm.close();
                   } catch (Exception e) {
                            e.printStackTrace();
                   }
         }
}