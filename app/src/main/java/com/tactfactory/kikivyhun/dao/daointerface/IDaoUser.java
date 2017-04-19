package com.tactfactory.kikivyhun.dao.daointerface;

import com.tactfactory.kikivyhun.dao.daointerface.base.IDaoEntity;
import com.tactfactory.kikivyhun.entities.User;

/**
 * Created by tactfactory on 19/04/17.
 */

public interface IDaoUser extends IDaoEntity<User> {
    public User getUserByLoginAndPassword(String login, String password);
}
