package com.nowcoder.community.service;

import com.nowcoder.community.dao.LocationMapper;
import com.nowcoder.community.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    public List<Location> findAll(){
        return locationMapper.selectAll();
    }

    public Location findLocationById(int id){
        return locationMapper.selectById(id);
    }


}
