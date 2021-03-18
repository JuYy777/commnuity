package com.juyy.mapper;

import com.juyy.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: community
 * @BelongsPackage: com.juyy.mapper
 * @Author: JuYy
 * @CreateTime: 2021-03-16 19:50
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
