package com.tactfactory.kikivyhun.dao.daointerface.base;

import android.content.ContentValues;
import android.database.Cursor;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 19/04/17.
 */

public interface IDaoBase {
    public long insert(String table, ContentValues values);
    public Cursor selectById(long id, String table, String[] projection);
    public Cursor select(String table, String[] projection);
    public void delete(long id, String table);
    public int update(long id, String table, ContentValues values);
}
