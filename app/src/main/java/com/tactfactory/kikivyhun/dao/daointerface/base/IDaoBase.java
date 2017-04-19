package com.tactfactory.kikivyhun.dao.daointerface.base;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by tactfactory on 19/04/17.
 */

public interface IDaoBase {
    public long insertData(String table, ContentValues values);
    public Cursor selectById(long id, String table, String[] projection);
    public Cursor select(String table, String[] projection);
    public void delete(long id, String table);
    public int update(long id, String table, ContentValues values);
}
