package com.tactfactory.kikivyhun.utils.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tactfactory.kikivyhun.entities.Address;
import com.tactfactory.kikivyhun.entities.base.EntityBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tactfactory on 12/04/17.
 */

public class DatabaseManager {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public DatabaseManager(Context context){
        dbHelper = new DatabaseHelper(context);
    }

    public long insertAddressData(Address address){
        db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Address.AddressEntry.COLUMN_NAME_NUM_WAY, address.getNum_way());
        values.put(Address.AddressEntry.COLUMN_NAME_NAME_WAY, address.getName_way());
        values.put(Address.AddressEntry.COLUMN_NAME_POSTAL_CODE, address.getPostal_code());
        values.put(Address.AddressEntry.COLUMN_NAME_CITY, address.getCity());
        values.put(Address.AddressEntry.COLUMN_NAME_LAT, address.getLat());
        values.put(Address.AddressEntry.COLUMN_NAME_LNG, address.getLng());

        long newRowId = db.insert(Address.AddressEntry.TABLE_NAME, null, values);
        address.setId(newRowId);

        return newRowId;
    }

    public Address selectAddressById(long id){
        db = dbHelper.getReadableDatabase();

        String[] projection = {
                EntityBase.EntityBaseEntry.COLUMN_NAME_ID,
                Address.AddressEntry.COLUMN_NAME_NUM_WAY,
                Address.AddressEntry.COLUMN_NAME_NAME_WAY,
                Address.AddressEntry.COLUMN_NAME_POSTAL_CODE,
                Address.AddressEntry.COLUMN_NAME_CITY,
                Address.AddressEntry.COLUMN_NAME_LAT,
                Address.AddressEntry.COLUMN_NAME_LNG
        };

        // Filter results WHERE clause
        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";
        String[] selectionArgs = {
                String.valueOf(id)
        };

        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                FeedEntry.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor cursor = db.query(
                Address.AddressEntry.TABLE_NAME,          // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        cursor.moveToNext();

        Address address = new Address();
        address.setId(cursor.getLong(
                cursor.getColumnIndexOrThrow(
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID)));
        address.setNum_way(cursor.getString(
                cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_NUM_WAY)));
        address.setName_way(cursor.getString(
                cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_NAME_WAY)));
        address.setPostal_code(cursor.getString(
                cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_POSTAL_CODE)));
        address.setCity(cursor.getString(
                cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_CITY)));
        address.setLat(cursor.getDouble(
                cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LAT)));
        address.setLng(cursor.getDouble(
                cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LNG)));

        cursor.close();

        return address;
    }

    public List<Address> selectAddresses(){
        db = dbHelper.getReadableDatabase();

        String[] projection = {
                EntityBase.EntityBaseEntry.COLUMN_NAME_ID,
                Address.AddressEntry.COLUMN_NAME_NUM_WAY,
                Address.AddressEntry.COLUMN_NAME_NAME_WAY,
                Address.AddressEntry.COLUMN_NAME_POSTAL_CODE,
                Address.AddressEntry.COLUMN_NAME_CITY,
                Address.AddressEntry.COLUMN_NAME_LAT,
                Address.AddressEntry.COLUMN_NAME_LNG
        };

        Cursor cursor = db.query(
                Address.AddressEntry.TABLE_NAME,          // The table to query
                projection,                               // The columns to return
                null,                                     // The columns for the WHERE clause
                null,                                     // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        List<Address> addresses = new ArrayList<>();

        while(cursor.moveToNext()) {
            Address address = new Address();
            address.setId(cursor.getLong(
                    cursor.getColumnIndexOrThrow(EntityBase.EntityBaseEntry.COLUMN_NAME_ID)));
            address.setNum_way(cursor.getString(
                    cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_NUM_WAY)));
            address.setNum_way(cursor.getString(
                    cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_NAME_WAY)));
            address.setNum_way(cursor.getString(
                    cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_POSTAL_CODE)));
            address.setNum_way(cursor.getString(
                    cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_CITY)));
            address.setNum_way(cursor.getString(
                    cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LAT)));
            address.setNum_way(cursor.getString(
                    cursor.getColumnIndexOrThrow(Address.AddressEntry.COLUMN_NAME_LNG)));

            addresses.add(address);
        }

        return addresses;
    }

    public void deleteAddress(long id){
        db = dbHelper.getReadableDatabase();

        // Define 'where' part of query.
        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { String.valueOf(id) };
        // Issue SQL statement.
        db.delete(Address.AddressEntry.TABLE_NAME, selection, selectionArgs);
    }

    public int updateAddress(Address address){
        db = dbHelper.getReadableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(Address.AddressEntry.COLUMN_NAME_NUM_WAY, address.getNum_way());
        values.put(Address.AddressEntry.COLUMN_NAME_NAME_WAY, address.getName_way());
        values.put(Address.AddressEntry.COLUMN_NAME_POSTAL_CODE, address.getPostal_code());
        values.put(Address.AddressEntry.COLUMN_NAME_CITY, address.getCity());
        values.put(Address.AddressEntry.COLUMN_NAME_LAT, address.getLat());
        values.put(Address.AddressEntry.COLUMN_NAME_LNG, address.getLng());

        // Which row to update, based on the title
        String selection = EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " = ?";

        String[] selectionArgs = { String.valueOf(address.getId()) };

        int count = db.update(
                Address.AddressEntry.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        return  count;
    }
}
