package com.restaurant.dao;

import com.restaurant.entity.TableGroup;

import java.util.List;

public interface TableGroupDao {
    int deleteByPrimaryKey(Integer gId);

    int insert(TableGroup record);

    int insertSelective(TableGroup record);

    TableGroup selectByPrimaryKey(Integer gId);

    List<TableGroup> selectByRId(Integer rId);

    int updateByPrimaryKeySelective(TableGroup record);

    int updateByPrimaryKey(TableGroup record);
}