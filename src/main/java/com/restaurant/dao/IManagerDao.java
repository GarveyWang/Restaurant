package com.restaurant.dao;

import com.restaurant.model.Manager;

public interface IManagerDao {
    int deleteByPrimaryKey(Integer mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}