package com.tracy.classloader.testHotLoad_20160927;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.tracy.classloader.testHotLoad_20160927.entity.BaseManager;

public class ManagerFactory {

    /**
     * 记录热加载类的加载信息
     */
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();

    public static final String                 CLASS_PATH  = "D:/aworkspace/tracy/bin/";

    public static final String                 MY_MANAGER  = "com.tracy.classloader.testHotLoad_20160927.entity.MyManager";

    public static BaseManager getManager(String className) {
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();
        // 查看是否被家再过 ,如果没有被家再过则加载
        if (loadTimeMap.get(className) == null) {
            System.out.println("===:" + lastModified);
            load(className, lastModified);
        } else if (loadTimeMap.get(className).getLoadTime() != lastModified) {// 如果被加载过，查看加载时间，如果该类已经被修改，则重新加载
            System.out.println("+++:" + lastModified);
            load(className, lastModified);
        }

        return loadTimeMap.get(className).getManager();
    }

    private static void load(String className, long lastModified) {

        MyClassLoader myLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myLoader.loadClass1(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo2 = new LoadInfo(myLoader, lastModified);
        loadInfo2.setManager(manager);
        loadTimeMap.put(className, loadInfo2);
    }

    private static BaseManager newInstance(Class<?> cls) {
        try {
            return (BaseManager) cls.getConstructor(new Class[] {}).newInstance(new Object[] {});
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }
}
