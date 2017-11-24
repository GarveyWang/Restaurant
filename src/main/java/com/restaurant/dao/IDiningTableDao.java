package com.restaurant.dao;

import com.restaurant.model.DiningTable;

public interface IDiningTableDao {
    int deleteByPrimaryKey(Integer tId);

    int insert(DiningTable record);

    int insertSelective(DiningTable record);

    DiningTable selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(DiningTable record);

    int updateByPrimaryKey(DiningTable record);
}