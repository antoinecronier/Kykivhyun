package com.tactfactory.kikivyhun.dao.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tactfactory.kikivyhun.dao.daointerface.base.IDaoBase;
import com.tactfactory.kikivyhun.entities.base.EntityBase;
import com.tactfactory.kikivyhun.utils.database.DatabaseHelper;

/**
 * Created by tactfactory on 19/04/17.
 */

public abstract class DaoBase implements IDaoBase{

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DaoBase(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public long insertData(String table, ContentValues values){
        db = dbHelper.getWritableDatabase();

        long newRowId = db.insert(table, null, values);

        return newRowId;
    }

    public Cursor selectById(long id, String table, String[] projection){
        db = dbHelper.getReadableDatabase();

        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = {
                String.valueOf(id)
        };

        Cursor cursor = db.query(
                table,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        return cursor;
    }

    public Cursor select(String table, String[] projection){
        db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                table,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }

    public void delete(long id, String table){
        db = dbHelper.getReadableDatabase();

        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";

        String[] selectionArgs = { String.valueOf(id) };

        db.delete(table, selection, selectionArgs);
    }

    public int update(long id, String table, ContentValues values){
        db = dbHelper.getReadableDatabase();

        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";

        String[] selectionArgs = { String.valueOf(id) };

        int count = db.update(
                table,
                values,
                selection,
                selectionArgs);

        return  count;
    }
}
