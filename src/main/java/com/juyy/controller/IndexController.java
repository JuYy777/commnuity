package com.juyy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @BelongsProject: community
 * @BelongsPackage: com.juyy.controller
 * @Author: JuYy
 * @CreateTime: 2021-03-13 16:40
 * @Description:
 */
@Controller
public class IndexController {

    @GetMapping("/index")
    public String hello() {
        return "index";
    }

}
