package com.restaurant.dao;

import com.restaurant.model.TableGroup;

public interface ITableGroupDao {
    int deleteByPrimaryKey(Integer gId);

    int insert(TableGroup record);

    int insertSelective(TableGroup record);

    TableGroup selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(TableGroup record);

    int updateByPrimaryKey(TableGroup record);
}