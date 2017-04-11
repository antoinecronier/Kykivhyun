package com.tactfactory.kikivyhun.entities.base;

import java.io.Serializable;

/**
 * Created by tactfactory on 11/04/17.
 */

public abstract class EntityBase implements Serializable {
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
