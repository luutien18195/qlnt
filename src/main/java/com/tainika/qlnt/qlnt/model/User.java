package com.tainika.qlnt.qlnt.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection="User")
public class User {
    @Id
    private String id;
    private String roleId;
    private String roleName;
    private String roomId;
    private String roomName;
    private String userName;
    private String password;
    private String salt;
    private String fullName;
    private String email;
    private Integer age;
    private String birthYear;
    private String phone;
    private String identityNumber;
    private String address;
    private String currentAddress;
    private String workPlace;
    private String avatarPath;
    private String identityImagePath;
    private Integer status;
    private Integer isBlackList;
    private Integer accepterId;
    private Date createTime;
    private Date updateTime;
}
