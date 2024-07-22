package com.nanaki.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2024/4/25
 */
@RestController
@RequestMapping
public class DemoController {

    @PostMapping("/post/{param}")
    public String postDemo(@PathVariable(required = false) String param) {
        return param + "";
    }

    @GetMapping("/get/{param}")
    public String getDemo(@PathVariable(required = false) String param) {
        return param;
    }
    @GetMapping("/getboolean/{param}")
    public Boolean getDemo(@PathVariable(required = false) Boolean param) {
        return param;
    }


}
