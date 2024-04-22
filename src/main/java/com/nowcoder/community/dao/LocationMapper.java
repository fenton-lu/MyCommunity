package com.nowcoder.community.dao;

import com.nowcoder.community.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {

    @Select({
            "select id, ruid, username, domain, contact, received, expires, user_agent, socket from location"
    })
    List<Location> selectAll();

    @Select({
            "select id, ruid, username, domain, contact, received, expires, user_agent, socket from location where id = #{id}"
    })
    Location selectById(int id);


}
