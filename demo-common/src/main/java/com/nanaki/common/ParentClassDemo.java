package com.nanaki.common;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/4/1
 */
public class ParentClassDemo {

    interface A {
        A getKey();

        default String getValue() {

//            return getKey().getClass().getName();
            return this.getClass().getName();
        }

    }

    public static void main(String[] args) {
        System.out.println(B.AENUM.getValue());
    }


    enum B implements A {

        AENUM,

        ;

        @Override
        public A getKey() {
            return null;
        }
    }

}
