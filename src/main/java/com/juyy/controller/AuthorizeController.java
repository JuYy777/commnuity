package com.juyy.controller;

import com.juyy.dto.AccessTokenDTO;
import com.juyy.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @BelongsProject: community
 * @BelongsPackage: com.juyy.controller
 * @Author: JuYy
 * @CreateTime: 2021-03-13 16:50
 * @Description:
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("https://github.com/login/oauth/access_token");
        accessTokenDTO.setClient_id("2a9bd8a40ff8ef8d9727");
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/github/callback");
        accessTokenDTO.setClient_secret("691646b69c322a0b12d1e2240678779677ae9076");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
