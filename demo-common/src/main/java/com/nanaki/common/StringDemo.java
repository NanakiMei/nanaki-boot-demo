package com.nanaki.common;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/6/6
 */
public class StringDemo {

    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "a";
        String str3 = new String("a");
        String str4 = new StringBuilder("a").toString();
        String str5 = new StringBuffer("a").toString();

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str5);

        System.out.println(str3 == str4);
        System.out.println(str3 == str5);

        System.out.println(str4 == str5);
    }

}
