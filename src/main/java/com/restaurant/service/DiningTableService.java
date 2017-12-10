package com.restaurant.service;

import com.restaurant.entity.DiningTable;

import java.util.List;

public interface DiningTableService {
    public int insertSelective(DiningTable record);

    List<DiningTable> selectByTgId(int tgId);

    DiningTable selectById(int tId);
}
