package com.tactfactory.kikivyhun.entities;

import android.provider.BaseColumns;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 11/04/17.
 */

public class Participant extends EntityBase {
    private User user;
    private Event event;
    private Boolean has_come;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Boolean getHas_come() {
        return has_come;
    }

    public void setHas_come(Boolean as_come) {
        this.has_come = has_come;
    }

    public static class ParticipantEntry {
        public static final String TABLE_NAME = "participant";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_EVENT_ID = "event_id";
        public static final String COLUMN_NAME_HAS_COME = "has_come";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + ParticipantEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        ParticipantEntry.COLUMN_NAME_USER_ID + " INTEGER," +
                        ParticipantEntry.COLUMN_NAME_EVENT_ID + " INTEGER," +
                        ParticipantEntry.COLUMN_NAME_HAS_COME + " NUMERIC);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + ParticipantEntry.TABLE_NAME + ";";
    }
}
