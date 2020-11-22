package com.tainika.qlnt.qlnt.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection="authority")
public class Authority {
    @Id
    private String id;
    private String name;
    @Indexed
    private String code;
    private Date createTime;
    private Date updateTime;

    public Authority(String code) {
        this.code = code;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
