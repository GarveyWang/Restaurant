package com.restaurant.service;

import com.restaurant.entity.TableGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface TableGroupService {
    int insertSelective(TableGroup record);

    int insert(TableGroup record);

    TableGroup selectById(int tgId);

    List<TableGroup> selectByRId(int rId);

    RegisterStateEnum register(TableGroup tableGroup);

    int getTableCount(List<TableGroup> tableGroupList);

    int getRIdByTgId(int tgId);

    DeleteStateEnum deleteByTgId(int tgId);

    UpdateStateEnum update(TableGroup tableGroup);
}
