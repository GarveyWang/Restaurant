package com.restaurant.dao;

import com.restaurant.entity.Kitchen;

import java.util.List;

public interface KitchenDao {
    int deleteByPrimaryKey(Integer kId);

    int insert(Kitchen record);

    int insertSelective(Kitchen record);

    Kitchen selectByPrimaryKey(Integer kId);

    List<Kitchen> selectByRId(Integer rId);

    int updateByPrimaryKeySelective(Kitchen record);

    int updateByPrimaryKey(Kitchen record);
}