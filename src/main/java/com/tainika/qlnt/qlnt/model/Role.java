package com.tainika.qlnt.qlnt.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection="role")
public class Role {
    @Id
    private String id;
    private String name;
    @Indexed
    private String code;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private List<Authority> authorities;
}
