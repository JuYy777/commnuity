package com.juyy.community.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @BelongsProject: community
 * @BelongsPackage: com.juyy.community.community
 * @Author: JuYy
 * @CreateTime: 2021-02-27 16:29
 * @Description:
 */
@Controller
public class HelloController {

    @GetMapping("/index")
    public String hello() {
        return "index";
    }
}
