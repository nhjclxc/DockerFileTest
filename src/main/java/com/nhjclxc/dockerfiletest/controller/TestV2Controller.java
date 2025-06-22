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
@RequestMapping("/dockerfile/v2")
public class TestV2Controller {

    @Value("${app.version}")
    private String version;
    @Value("${spring.profiles.active}")
    private String env;

    @GetMapping("/test2")
    public Object test2() {

        String desc = String.format("当前接口版本 = V2V2, 当前启动环境是 = %s, 当前版本是 = %s", env, version);

        System.out.println(desc);

        return desc;
    }

}
