package com.restaurant.service;

import com.restaurant.entity.TableGroup;

import java.util.List;

public interface TableGroupService {
    int insertSelective(TableGroup record);

    int insert(TableGroup record);

    List<TableGroup> selectByRId(int rId);
}
