package com.tainika.qlnt.qlnt.model;

import lombok.Data;

@Data
public class Room {
    public String id;
    public String name;
    public String price;
    public Integer quantityPerson;
    public String garbagePrice;
    public String waterPrice;
    public String electricPrice;
    public String internetPrice;
    public Integer status;
    public String createTime;
    public String updateTime;
}
