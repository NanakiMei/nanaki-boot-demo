package com.nanaki.apt.demo;

import com.nanaki.apt.processor.annotation.Apt;
import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/10/13
 */
@Component
@Apt(value = "apt1", version = "v1.0")
public class Apt1 {

}
