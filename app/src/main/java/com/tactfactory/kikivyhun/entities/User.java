package com.tactfactory.kikivyhun.entities;

import android.location.Location;
import android.provider.BaseColumns;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 11/04/17.
 */

public class User extends EntityBase {
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private Double lat;
    private Double lng;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public static class UserEntry {
        public static final String TABLE_NAME = "place";
        public static final String COLUMN_NAME_FIRSTNAME = "firstname";
        public static final String COLUMN_NAME_LASTNAME = "lastname";
        public static final String COLUMN_NAME_LOGIN = "login";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LNG = "lng";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        UserEntry.COLUMN_NAME_FIRSTNAME + " TEXT," +
                        UserEntry.COLUMN_NAME_LASTNAME + " TEXT," +
                        UserEntry.COLUMN_NAME_LOGIN + " TEXT," +
                        UserEntry.COLUMN_NAME_PASSWORD + " TEXT," +
                        UserEntry.COLUMN_NAME_LAT + " REAL," +
                        UserEntry.COLUMN_NAME_LNG + " REAL);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME + ";";

        public static final String[] PROJECTION = {
                EntityBase.EntityBaseEntry.COLUMN_NAME_ID,
                UserEntry.COLUMN_NAME_FIRSTNAME,
                UserEntry.COLUMN_NAME_LASTNAME,
                UserEntry.COLUMN_NAME_LOGIN,
                UserEntry.COLUMN_NAME_PASSWORD,
                UserEntry.COLUMN_NAME_LAT,
                UserEntry.COLUMN_NAME_LNG
        };
    }
}
