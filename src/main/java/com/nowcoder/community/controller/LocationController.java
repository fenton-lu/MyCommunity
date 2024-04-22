package com.nowcoder.community.controller;

import com.nowcoder.community.entity.Location;
import com.nowcoder.community.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    @ResponseBody
    public List<Location> getLocations(){
        return locationService.findAll();
    }

    @GetMapping("/location/{id}")
    @ResponseBody
    public Location getLocationById(@PathVariable("id") int id){
        return locationService.findLocationById(id);
    }


}
