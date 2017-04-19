package com.tactfactory.kikivyhun.entities;

import android.provider.BaseColumns;

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

    public Event(String title,String category_name, String address_city, Date start_date, Double lat, double lng){
        this(title,category_name, address_city, start_date);

        this.place.getAddress().setLat(lat);
        this.place.getAddress().setLng(lng);
    }

    public static class EventEntry {
        public static final String TABLE_NAME = "event";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_START_DATE = "start_date";
        public static final String COLUMN_NAME_END_DATE = "end_date";
        public static final String COLUMN_NAME_MAX_PARTICIPANTS = "max_participants";
        public static final String COLUMN_NAME_CATEGORY_ID = "category_id";
        public static final String COLUMN_NAME_PLACE_ID = "place_id";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + EventEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        EventEntry.COLUMN_NAME_TITLE + " TEXT," +
                        EventEntry.COLUMN_NAME_START_DATE + " NUMERIC," +
                        EventEntry.COLUMN_NAME_END_DATE + " NUMERIC," +
                        EventEntry.COLUMN_NAME_MAX_PARTICIPANTS + " INTEGER," +
                        EventEntry.COLUMN_NAME_CATEGORY_ID + " INTEGER," +
                        EventEntry.COLUMN_NAME_PLACE_ID + " INTEGER);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + EventEntry.TABLE_NAME + ";";
    }
}
