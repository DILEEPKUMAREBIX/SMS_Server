package com.sms.service;


import java.util.List;

import com.sms.entity.User;

public interface UserService {

    User save(User user);
    List<User> findAll();
    User findOne(long id);
    void delete(long id);
}
