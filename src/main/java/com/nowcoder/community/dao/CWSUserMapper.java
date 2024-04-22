package com.nowcoder.community.dao;

import com.nowcoder.community.entity.CWSUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CWSUserMapper {

    @Select({
            "select * from cws.user"
    })
    List<CWSUser> selectAll();

    @Select({
            "select id, name, account, password, user_id, organization_id, level, created_at from cws.user where id = #{id}"
    })
    CWSUser selectById(int id);

    @Insert({
            "insert into cws.user(name, account, password, user_id, organization_id, level, created_at) " +
                    "values(#{name}, #{account}, #{password}, #{userId}, #{organizationId}, #{level}, #{createdAt})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertCWSUser(CWSUser cwsUser);

    @Update({
            "update cws.user set password = #{password} where id = #{id}"
    })
    int updatePassword(@Param("id") int id,@Param("password") String password);

    @Update({
            "update cws.user set level = #{level} where id = #{id}"
    })
    int updateLevel(@Param("id") int id,@Param("level") int level);

    @Delete({
            "delete from cws.user where id = #{id}"
    })
    int deleteCWSUser(int id);

}
