package com.tactfactory.kikivyhun.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.tactfactory.kikivyhun.dao.base.DaoBase;
import com.tactfactory.kikivyhun.dao.daointerface.IDaoUser;
import com.tactfactory.kikivyhun.dao.daointerface.base.IDaoEntity;
import com.tactfactory.kikivyhun.entities.User;
import com.tactfactory.kikivyhun.entities.base.EntityBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tactfactory on 19/04/17.
 */

public class DaoUser extends DaoBase implements IDaoUser {

    private static final String TABLE = User.UserEntry.TABLE_NAME;
    private static final String[] PROJECTION = User.UserEntry.PROJECTION;

    public DaoUser(Context context) {
        super(context);
    }

    @Override
    public void insert(User item) {
        item.setId(super.insert(TABLE, getContentValues(item)));
    }

    @Override
    public User selectById(long id) {
        User user = new User();
        Cursor cursor = super.selectById(id, TABLE, PROJECTION);
        cursor.moveToNext();
        user = cursorToItem(cursor);
        return user;
    }

    @Override
    public List<User> select() {
        List<User> users = new ArrayList<User>();
        Cursor cursor = super.select(TABLE, PROJECTION);

        while (cursor.moveToNext()){
            users.add(cursorToItem(cursor));
        }

        return users;
    }

    @Override
    public void delete(User item) {
        super.delete(item.getId(),TABLE);
    }

    @Override
    public void update(User item) {
        super.update(item.getId(),TABLE,getContentValues(item));
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        super.db = dbHelper.getReadableDatabase();

        String selection = User.UserEntry.COLUMN_NAME_LOGIN + " = ?"
                + " AND "
                + User.UserEntry.COLUMN_NAME_PASSWORD + " = ?";
        String[] selectionArgs = {
                login,
                password
        };

        Cursor cursor = db.query(
                TABLE,
                PROJECTION,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        cursor.moveToNext();

        return cursorToItem(cursor);
    }

    public User cursorToItem(Cursor cursor){
        User user = new User();

        user.setId(cursor.getLong(
                cursor.getColumnIndexOrThrow(
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID)));
        user.setFirstname(cursor.getString(
                cursor.getColumnIndexOrThrow(User.UserEntry.COLUMN_NAME_FIRSTNAME)));
        user.setLastname(cursor.getString(
                cursor.getColumnIndexOrThrow(User.UserEntry.COLUMN_NAME_LASTNAME)));
        user.setLogin(cursor.getString(
                cursor.getColumnIndexOrThrow(User.UserEntry.COLUMN_NAME_LOGIN)));
        user.setPassword(cursor.getString(
                cursor.getColumnIndexOrThrow(User.UserEntry.COLUMN_NAME_PASSWORD)));
        user.setLat(cursor.getDouble(
                cursor.getColumnIndexOrThrow(User.UserEntry.COLUMN_NAME_LAT)));
        user.setLng(cursor.getDouble(
                cursor.getColumnIndexOrThrow(User.UserEntry.COLUMN_NAME_LNG)));

        cursor.close();

        return user;
    }

    @NonNull
    private ContentValues getContentValues(User item) {
        ContentValues values = new ContentValues();
        values.put(User.UserEntry.COLUMN_NAME_FIRSTNAME,item.getFirstname());
        values.put(User.UserEntry.COLUMN_NAME_LASTNAME,item.getLastname());
        values.put(User.UserEntry.COLUMN_NAME_LOGIN,item.getLogin());
        values.put(User.UserEntry.COLUMN_NAME_PASSWORD,item.getPassword());
        values.put(User.UserEntry.COLUMN_NAME_LAT,item.getLat());
        values.put(User.UserEntry.COLUMN_NAME_LNG,item.getLng());
        return values;
    }
}
