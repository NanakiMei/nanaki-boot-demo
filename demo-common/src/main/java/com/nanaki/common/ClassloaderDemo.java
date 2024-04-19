package com.nanaki.common;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/3/28
 */
public class ClassloaderDemo {

    public static void main(String[] args) {
        // JDK Extendsions目录
        System.out.println(System.getProperty("java.ext.dirs"));
        // 类路径，默认为当前工作目录，可以通过"-classpath"或"-cp"变量修改
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("---");
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // sun.misc.Launcher$ExtClassLoader@33833882
        printClassLoaderTree(new Md5Demo());
        System.out.println("---");
        // 因为Object是BootstrapClassLoader加载，所以不会打印
        printClassLoaderTree(new Object());
    }

    private static void printClassLoaderTree(Object target) {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Thread thread = Thread.currentThread();
        ClassLoader contextClassLoader = thread.getContextClassLoader();
        System.out.println(thread.getName() + " - " + contextClassLoader);

        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }

}
