package com.nowcoder.community.service;

import com.nowcoder.community.dao.CWSUserMapper;
import com.nowcoder.community.entity.CWSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CWSUserService {

    @Autowired
    private CWSUserMapper cwsUserMapper;

    public List<CWSUser> findAll(){
        return cwsUserMapper.selectAll();
    }

    public CWSUser findCWSUserById(int id){
        return cwsUserMapper.selectById(id);
    }

    public int increaseUser(CWSUser cwsUser){
        return cwsUserMapper.insertCWSUser(cwsUser);
    }

    public int modifyPassword(int id, String password){
        return cwsUserMapper.updatePassword(id, password);
    }

    public int modifyLevel(int id, int level){
        return cwsUserMapper.updateLevel(id, level);
    }

    public int removeCWSUser(int id){
        return cwsUserMapper.deleteCWSUser(id);
    }

}
