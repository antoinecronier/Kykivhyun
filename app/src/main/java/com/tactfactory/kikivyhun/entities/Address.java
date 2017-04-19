package com.tactfactory.kikivyhun.entities;

import android.location.Location;
import android.provider.BaseColumns;
import android.widget.ListView;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 11/04/17.
 */

public class Address extends EntityBase {
    private String num_way;
    private String name_way;
    private String postal_code;
    private String city;
    private Double lat;
    private Double lng;

    public String getNum_way() {
        return num_way;
    }

    public void setNum_way(String num_way) {
        this.num_way = num_way;
    }

    public String getName_way() {
        return name_way;
    }

    public void setName_way(String name_way) {
        this.name_way = name_way;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public static class AddressEntry {
        public static final String TABLE_NAME = "address";
        public static final String COLUMN_NAME_NUM_WAY = "num_way";
        public static final String COLUMN_NAME_NAME_WAY = "name_way";
        public static final String COLUMN_NAME_POSTAL_CODE = "postal_code";
        public static final String COLUMN_NAME_CITY = "city";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LNG = "lng";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + AddressEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        AddressEntry.COLUMN_NAME_NUM_WAY + " TEXT," +
                        AddressEntry.COLUMN_NAME_NAME_WAY + " TEXT," +
                        AddressEntry.COLUMN_NAME_POSTAL_CODE + " TEXT," +
                        AddressEntry.COLUMN_NAME_CITY + " TEXT," +
                        AddressEntry.COLUMN_NAME_LAT + " REAL," +
                        AddressEntry.COLUMN_NAME_LNG + " REAL);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + AddressEntry.TABLE_NAME + ";";
    }
}
