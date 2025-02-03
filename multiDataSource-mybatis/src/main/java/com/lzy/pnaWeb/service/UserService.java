package com.lzy.pnaWeb.service;

import com.lzy.pnaWeb.entity.User1;

import java.util.List;

public interface UserService {
    List<User1> findList();

    void insertOne();
}
