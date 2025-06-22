package com.nhjclxc.dockerfiletest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuoXianchao
 * @since 2025/06/22 16:07
 */

@RestController
@RequestMapping("/dockerfile/v1")
public class TestV1Controller {

    @Value("${app.version}")
    private String version;
    @Value("${spring.profiles.active}")
    private String env;

    @GetMapping("/test1")
    public Object test1() {

        String desc = String.format("当前接口版本 = v1, 当前启动环境是 = %s, 当前版本是 = %s", env, version);

        System.out.println(desc);

        return desc;
    }

}
