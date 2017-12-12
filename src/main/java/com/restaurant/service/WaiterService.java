package com.restaurant.service;

import com.restaurant.entity.Waiter;
import com.restaurant.enums.DeleteStateEnum;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import com.restaurant.enums.UpdateStateEnum;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface WaiterService {
    public int insertSelective(Waiter record);

    public Waiter selectById(int wId);

    public List<Waiter> selectByRId(int rId);

    public LoginStateEnum validate(Waiter waiter);

    public RegisterStateEnum register(Waiter waiter);

    public int getRIdByWId(int wId);

    public DeleteStateEnum deleteById(int wId);

    public UpdateStateEnum update(Waiter waiter);
}
