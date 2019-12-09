package com.czr.customer.mapper;


import com.czr.customer.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    //按照各属性查询
    List<User> selectByElement(User user);

    int updateByPrimaryKey(User record);
}