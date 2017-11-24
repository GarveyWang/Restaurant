package com.restaurant.service;

import com.restaurant.model.TableGroup;

public interface ITableGroupService {
    int insertSelective(TableGroup record);
    int insert(TableGroup record);
}
