package com.tainika.qlnt.qlnt.service;

import com.tainika.qlnt.qlnt.common.Result;
import com.tainika.qlnt.qlnt.model.User;

import java.util.List;

public interface SettingService {
    Result<List<User>> getAllUser();
}
