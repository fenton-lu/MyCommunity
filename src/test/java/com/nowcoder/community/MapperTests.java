package com.nowcoder.community;


import com.nowcoder.community.dao.CWSUserMapper;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LocationMapper;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.CWSUser;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.Location;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CWSUserMapper cwsUserMapper;

    @Autowired
    private LocationMapper locationMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectuser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder24@sina.com");
        System.out.println(user);

        user = userMapper.selectByName("aaa");
        System.out.println(user);

    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("Jack");
        user.setPassword("123jack456");
        user.setSalt("jack");
        user.setEmail("jack@126.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/111t.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(153, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(153, "http://images.nowcoder.com/head/100t.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(153, "test123456789");
        System.out.println(rows);
    }

    @Test
    public void testSelectCWS(){
        CWSUser cwsUser = cwsUserMapper.selectById(12);
        System.out.println(cwsUser);
    }

    @Test
    public void testLocationMapper(){
        List<Location> list = locationMapper.selectAll();
        System.out.println(list);
    }

    @Test
    public void testInsertCWS(){
        CWSUser cwsUser = new CWSUser();
        cwsUser.setName("斯坦特芬");
        cwsUser.setAccount("BNSC");
        cwsUser.setPassword("bnsc1234");
        cwsUser.setUserId(UUID.randomUUID().toString());
        cwsUser.setOrganizationId(UUID.randomUUID().toString());
        cwsUser.setLevel(100);
        cwsUser.setCreatedAt(new Date());

        int res = cwsUserMapper.insertCWSUser(cwsUser);
        System.out.println(res);
    }

    @Test
    public void testUpdateCWSUser(){
        int rows = cwsUserMapper.updatePassword(68, "123456789");
        System.out.println(rows);

        cwsUserMapper.updateLevel(68, 80);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post: discussPosts){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }

}