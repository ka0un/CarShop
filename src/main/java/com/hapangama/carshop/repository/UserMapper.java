package com.hapangama.carshop.repository;

import com.hapangama.carshop.domian.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User find(String username);

    void add(User user);

    void update(User user);


}
