package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //当要查询我的贴子时，拼接userId进行SQL查询，当等于0时，就是查询所有贴子
    //所以这个是动态SQL，动态的拼接userId
    @Select({
            "<script> ",
            "select id, user_id, title, content, type, status, create_time, comment_count, score ",
            "from discuss_post where status != 2 ",
            "<if test=\"userId != 0\">",
            " and user_id = #{userId} ",
            "</if>",
            "order by type desc, create_time desc ",
            "limit #{offset}, #{limit}",
            "</script>"
    })
    List<DiscussPost> selectDiscussPosts(@Param("userId") int userId, @Param("offset") int offset, @Param("limit") int limit);

    // @Param注解用于给参数取别名
    // 如果要动态拼接一个参数，并且在<if>里使用，有且只有一个参数，则必须取别名
    //查询贴子的行数，用于分页
    @Select({
            "<script> ",
            "select count(id) ",
            "from discuss_post  where status != 2 ",
            "<if test=\"userId!=0\"> ",
                "and user_id = #{userId}",
            "</if>",
            "</script>"
    })
    int selectDiscussPostRows(@Param("userId") int userId);

}
