package com.nanaki.common;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/4/12
 */
public class ReflectDemo {

    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.setUsername("Admin");
        foo.setPassword("Admin@123");
        Foo foo2 = new Foo();
        BeanUtils.copyProperties(foo, foo2);
        System.out.println(foo);
        System.out.println(foo2);
    }

    @Getter
    @Setter
    @ToString
    static class Foo {

        private String username;

        private String password;

        public String getPassword() {
            return password.toLowerCase();
        }
    }
}
