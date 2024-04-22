package com.nowcoder.community.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Location {
    private int id;
    private String ruid;
    private String username;
    private String domain;
    private String contact;
    private String received;
    private Date expires;
    private String userAgent;
    private String socket;



}
