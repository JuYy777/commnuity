package com.juyy.dto;

/**
 * @BelongsProject: community
 * @BelongsPackage: com.juyy.dto
 * @Author: JuYy
 * @CreateTime: 2021-03-13 19:20
 * @Description:
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
