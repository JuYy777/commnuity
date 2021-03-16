package com.juyy.provider;

import com.alibaba.fastjson.JSON;
import com.juyy.dto.AccessTokenDTO;
import com.juyy.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @BelongsProject: community
 * @BelongsPackage: com.juyy.provider
 * @Author: JuYy
 * @CreateTime: 2021-03-13 17:10
 * @Description:
 */
@Component
public class GithubProvider {
    //获取github的access_token
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")//调用github的access_token接口获取到access_token
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //获取github用户信息
    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        //获取到access_token之后再去github调用github的user接口拿到user的全部信息
        Request request = new Request.Builder().url("https://api.github.com/user?access_token=" + accessToken)//获取到access_token之后再去github调用github的user接口拿到user的全部信息
                .header("Authorization", "token " + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
        }
        return null;
    }

}
