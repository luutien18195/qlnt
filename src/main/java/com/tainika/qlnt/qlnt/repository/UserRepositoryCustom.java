package com.tainika.qlnt.qlnt.repository;

import com.tainika.qlnt.qlnt.model.User;

public interface UserRepositoryCustom {

    boolean isExistedUserName(String userName);

    boolean isExistedEmail(String email);
}
