package com.poly.dao;

import com.poly.entity.User;
import java.util.List;

public interface UserDAO {
    List<User> findAll();
    User findById(String id);
    User create(User entity);
    User update(User entity);
    void deleteById(String id);
}
