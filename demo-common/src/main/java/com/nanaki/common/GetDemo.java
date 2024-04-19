package com.nanaki.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/4/3
 */
public class GetDemo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setA("a");
        foo.setB("b");
        System.out.println(foo.getA());
        System.out.println(foo.getB());
    }


    @Getter
    @Setter
    static class Foo {

        private String a;

        private String b;

        public String getB() {
            return "c";
        }
    }

}
