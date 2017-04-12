package com.tactfactory.kikivyhun.entities;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by tactfactory on 11/04/17.
 */

public class Event extends EntityBase {
    private String title;
    private Date start_date;
    private Date end_date;
    private int max_participants;
    private ArrayList<User> users;
    private ArrayList<Participant> participants;
    private Category category;
    private Place place;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getMax_participants() {
        return max_participants;
    }

    public void setMax_participants(int nb_participants) {
        this.max_participants = nb_participants;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Event(){
        this.users = new ArrayList<User>();
        this.participants = new ArrayList<Participant>();
    }

    public Event(String title,String category_name, String address_city, Date start_date){
        this.title = title;
        this.category = new Category();
        this.category.setName(category_name);
        this.start_date = start_date;
        this.place = new Place();
        this.place.setAddress(new Address());
        this.place.getAddress().setCity(address_city);

        this.users = new ArrayList<User>();
        this.participants = new ArrayList<Participant>();
    }
}
