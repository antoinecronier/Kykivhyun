package com.tactfactory.kikivyhun.dao.daointerface.base;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

import java.util.List;

/**
 * Created by tactfactory on 19/04/17.
 */

public interface IDaoEntity<T extends EntityBase> {
    public void insert(T item);
    public T selectById(long id);
    public List<T> select();
    public void delete(T item);
    public void update(T item);
}
