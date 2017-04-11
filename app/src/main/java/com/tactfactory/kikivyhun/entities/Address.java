package com.tactfactory.kikivyhun.entities;

import android.location.Location;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 11/04/17.
 */

public class Address extends EntityBase {
    private String num_way;
    private String name_way;
    private String postal_code;
    private String city;
    private Location gps;

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

    public Location getGps() {
        return gps;
    }

    public void setGps(Location gps) {
        this.gps = gps;
    }
}
