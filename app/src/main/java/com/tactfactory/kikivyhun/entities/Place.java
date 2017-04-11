package com.tactfactory.kikivyhun.entities;

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
}
