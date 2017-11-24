package com.restaurant.dao;

import com.restaurant.model.Kitchen;

public interface IKitchenDao {
    int deleteByPrimaryKey(Integer kId);

    int insert(Kitchen record);

    int insertSelective(Kitchen record);

    Kitchen selectByPrimaryKey(Integer kId);

    int updateByPrimaryKeySelective(Kitchen record);

    int updateByPrimaryKey(Kitchen record);
}