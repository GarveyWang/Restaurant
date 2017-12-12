package com.restaurant.service;

import com.restaurant.entity.DiningTable;
import com.restaurant.entity.TableGroup;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import java.util.List;

public interface DiningTableService {
    public int insertSelective(DiningTable record);

    List<DiningTable> selectByTgId(int tgId);

    DiningTable selectById(int tId);

    public LoginStateEnum validate(DiningTable table);

    public RegisterStateEnum register(DiningTable table);

    public int getRIdByTId(int tId);

    public DeleteStateEnum deleteById(int tId);

    public void deleteByTgId(int tgId);

    public UpdateStateEnum updateSelective(DiningTable table);

    public UpdateStateEnum updateGuestInfo(DiningTable table);

}
