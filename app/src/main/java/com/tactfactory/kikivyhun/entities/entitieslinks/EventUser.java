package com.tactfactory.kikivyhun.entities.entitieslinks;

import android.provider.BaseColumns;

import com.tactfactory.kikivyhun.entities.base.EntityBase;

/**
 * Created by tactfactory on 13/04/17.
 */

public class EventUser {

    public static class EventUserEntry implements BaseColumns {
        public static final String TABLE_NAME = "event_user";
        public static final String COLUMN_NAME_EVENT_ID = "event_id";
        public static final String COLUMN_NAME_USER_ID = "user_id";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + EventUserEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        EventUserEntry.COLUMN_NAME_EVENT_ID + " INTEGER," +
                        EventUserEntry.COLUMN_NAME_USER_ID + " INTEGER);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + EventUserEntry.TABLE_NAME + ";";
    }
}
