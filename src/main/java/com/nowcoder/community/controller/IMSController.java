package com.nowcoder.community.controller;

import com.nowcoder.community.entity.CWSUser;
import com.nowcoder.community.service.CWSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IMSController {

    @Autowired
    private CWSUserService cwsUserService;

    @RequestMapping("/test")
    @ResponseBody
    public String getUser() {
        return "a user";
    }

    @GetMapping("/cwsusers")
    @ResponseBody
    public List<CWSUser> getUsers() {
        return cwsUserService.findAll();
    }

    @RequestMapping(path = "/cwsuser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CWSUser getUser(@PathVariable("id") int id) {
        return cwsUserService.findCWSUserById(id);
    }

    @RequestMapping(path = "/cwsusers", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(@ModelAttribute("user") CWSUser cwsUser) {
        System.out.println(cwsUser);
        return cwsUserService.increaseUser(cwsUser);
    }

    @RequestMapping(path = "/cwsuser/ps/{id}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public int alterPassword(@PathVariable("id") int id, @PathVariable("password") String password) {
        return cwsUserService.modifyPassword(id, password);
    }

    @GetMapping("/cwsuser/level/{id}/{level}")
    @ResponseBody
    public int alterLevel(@PathVariable("id") int id, @PathVariable("level") int level){
        return cwsUserService.modifyLevel(id, level);
    }

    @RequestMapping(path = "/cwsuser/de/{id}", method = RequestMethod.GET)
    @ResponseBody
    public int exciseUser(@PathVariable("id") int id){
        return cwsUserService.removeCWSUser(id);
    }


}
