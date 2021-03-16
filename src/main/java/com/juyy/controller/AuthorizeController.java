package com.juyy.controller;

import com.juyy.dto.AccessTokenDTO;
import com.juyy.dto.GithubUser;
import com.juyy.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setClient_secret(clientSecret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);//获取到accessToken
        GithubUser user = githubProvider.getUser(accessToken);//使用access获取到用户信息
        System.out.println("用户名:" + user.getName());

        if (user.getName() != null) {
            //登录成功 设置cokie和session
            request.getSession().setAttribute("user", user);
            return "redirect:/";
        } else {
            //登录失败  跳转回index页面
            request.getSession().setAttribute("user", null);
            return "redirect:/";
        }
    }
}
