package com.hapangama.carshop.repository;

import com.hapangama.carshop.domian.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByUsername(String username);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);


}
