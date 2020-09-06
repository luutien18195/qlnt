package com.tainika.qlnt.qlnt.model;

import lombok.Data;

@Data
public class User {
    public String id;
    public String roleId;
    public String roleName;
    public String roomId;
    public String roomName;
    public String userName;
    public String password;
    public String salt;
    public String fullName;
    public String email;
    public Integer age;
    public String birthYear;
    public String phone;
    public String identityNumber;
    public String address;
    public String currentAddress;
    public String workPlace;
    public String avatarPath;
    public String identityImagePath;
    public Integer status;
    public Integer isBlackList;
    public String createTime;
    public String updateTime;
}
