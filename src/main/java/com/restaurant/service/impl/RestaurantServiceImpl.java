package com.restaurant.service.impl;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.entity.Restaurant;
import com.restaurant.enums.LoginStateEnum;
import com.restaurant.enums.RegisterStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("restaurantService")
public class RestaurantServiceImpl implements com.restaurant.service.RestaurantService {
    @Autowired
    private RestaurantDao restaurantDao;

    @Override
    public Restaurant selectById(int id) {
        return restaurantDao.selectById(id);
    }

    @Override
    public boolean isRestaurantExists(int id) {
        int count=restaurantDao.getRestaurantCount(id);
        if(count == 0)
            return false;
        return true;
    }

    @Override
    public int insert(Restaurant restaurant) {
        return restaurantDao.insert(restaurant);
    }

    @Override
    public LoginStateEnum validate(Restaurant rest) {
        if(rest ==null|| rest.getrId()==null||"".equals(rest.getrId())
                || rest.getPassword()==null||"".equals(rest.getPassword().trim())){
            return LoginStateEnum.IMCOMPLETE;
        }
        Restaurant restFromDB=restaurantDao.selectById(rest.getrId());
        if( restFromDB==null|| !restFromDB.getPassword().equals(rest.getPassword())){
            return LoginStateEnum.INFO_ERROR;
        }
        return LoginStateEnum.SUCCESS;
    }

    @Override
    public RegisterStateEnum register(Restaurant rest) {
        if(rest==null||rest.getName()==null||"".equals(rest.getName())
                ||rest.getrId()==null||"".equals(rest.getrId())
                ||rest.getPassword()==null||"".equals(rest.getPassword())){
            return RegisterStateEnum.IMCOMPLETE;
        }

        int insertCount=restaurantDao.insert(rest);
        if(insertCount<1){
            return RegisterStateEnum.ID_REPEAT;
        }

        return RegisterStateEnum.SUCCESS;
    }
}
