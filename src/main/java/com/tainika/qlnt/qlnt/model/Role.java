package com.tainika.qlnt.qlnt.model;

import lombok.Data;

@Data
public class Role {
    public String id;
    public String name;
    public String code;
    public Integer status;
    public String createTime;
    public String updateTime;
    public String authorities;
}
