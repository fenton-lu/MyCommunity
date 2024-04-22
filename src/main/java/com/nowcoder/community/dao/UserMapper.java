package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select({
            "select id, username, password, salt, email, type, status, activation_code, header_url, create_time " +
                    " from user where id = #{id}"
    })
    User selectById(int id);

    @Select({
            "select id, username, password, salt, email, type, status, activation_code, header_url, create_time " +
                    " from user where username = #{name}"
    })
    User selectByName(String name);

    @Select({
            "select id, username, password, salt, email, type, status, activation_code, header_url, create_time " +
                    " from user where email = #{email}"
    })
    User selectByEmail(String mail);

    @Insert({
            "insert into user (username, password, salt, email, type, status, activation_code, header_url, create_time) " +
                    "values (#{username}, #{password}, #{salt}, #{email}, #{type}, #{status}, #{activationCode}, #{headerUrl}, #{createTime})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    @Update({
            "update user set status = #{status} where id = #{id}"
    })
    int updateStatus(@Param("id") int id, @Param("status") int status);

    @Update({
            "update user set header_url = #{headerUrl} where id = #{id}"
    })
    int updateHeader(@Param("id")int id, @Param("headerUrl")String headerUrl);

    @Update({
            "update user set password = #{password} where id = #{id}"
    })
    int updatePassword(@Param("id")int id, @Param("password")String password);

}
