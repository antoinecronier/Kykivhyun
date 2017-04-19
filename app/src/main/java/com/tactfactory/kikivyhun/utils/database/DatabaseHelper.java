package com.tactfactory.kikivyhun.utils.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.tactfactory.kikivyhun.entities.Address;
import com.tactfactory.kikivyhun.entities.Category;
import com.tactfactory.kikivyhun.entities.Event;
import com.tactfactory.kikivyhun.entities.Participant;
import com.tactfactory.kikivyhun.entities.Place;
import com.tactfactory.kikivyhun.entities.User;
import com.tactfactory.kikivyhun.entities.base.EntityBase;
import com.tactfactory.kikivyhun.entities.entitieslinks.EventUser;

/**
 * Created by tactfactory on 12/04/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "kikivyhun.db";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        executeBatchSql(db, SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        executeBatchSql(db, SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void executeBatchSql(SQLiteDatabase db, String[] statements){
        // use something like StringTokenizer to separate sql statements
        for(String sql : statements){
            db.execSQL(sql);
        }
    }

    private final static String[] SQL_CREATE_ENTRIES = {
            Address.AddressEntry.SQL_CREATE_ENTRIES
            , Category.CategoryEntry.SQL_CREATE_ENTRIES
            , Event.EventEntry.SQL_CREATE_ENTRIES
            , Participant.ParticipantEntry.SQL_CREATE_ENTRIES
            , Place.PlaceEntry.SQL_CREATE_ENTRIES
            , User.UserEntry.SQL_CREATE_ENTRIES
            , EventUser.EventUserEntry.SQL_CREATE_ENTRIES};

    private final static String[] SQL_DELETE_ENTRIES = {
            Address.AddressEntry.SQL_DELETE_ENTRIES
            , Category.CategoryEntry.SQL_DELETE_ENTRIES
            , Event.EventEntry.SQL_DELETE_ENTRIES
            , Participant.ParticipantEntry.SQL_DELETE_ENTRIES
            , Place.PlaceEntry.SQL_DELETE_ENTRIES
            , User.UserEntry.SQL_DELETE_ENTRIES
            , EventUser.EventUserEntry.SQL_DELETE_ENTRIES};
}

        /*userDao = new UserDao(this);
        User user = new User();
        user.setFirstname("test");
        user.setLastname("test");
        user.setLogin("log");
        user.setPassword("pass");
        user.setLat(1.0);
        user.setLng(1.0);
        userDao.insert(user);*/