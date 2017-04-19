package com.tactfactory.kikivyhun.entities;

import android.provider.BaseColumns;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 11/04/17.
 */

public class Place extends EntityBase {
    private String name;
    private int max_people;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class PlaceEntry {
        public static final String TABLE_NAME = "place";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_MAX_PEOPLE = "max_people";
        public static final String COLUMN_NAME_ADDRESS_ID = "address_id";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + PlaceEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        PlaceEntry.COLUMN_NAME_NAME + " TEXT," +
                        PlaceEntry.COLUMN_NAME_MAX_PEOPLE + " INTEGER," +
                        PlaceEntry.COLUMN_NAME_ADDRESS_ID + " INTEGER);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + PlaceEntry.TABLE_NAME + ";";
    }
}
