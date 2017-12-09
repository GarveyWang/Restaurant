package com.restaurant.dao;

import com.restaurant.entity.DiningTable;

import java.util.List;

public interface DiningTableDao {
    int deleteByPrimaryKey(Integer tId);

    int insert(DiningTable record);

    int insertSelective(DiningTable record);

    DiningTable selectByPrimaryKey(Integer tId);

    List<DiningTable> selectByGId(Integer gId);

    int updateByPrimaryKeySelective(DiningTable record);

    int updateByPrimaryKey(DiningTable record);
}