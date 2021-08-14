package com.example.alonzo_carsakto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {

    //Creating Database and Table
    public static final String database_name = "dbCarsakto.db";

    public static final String table_Reservation = "tblReservation";

    //define table columns
    /*public static final String COL_USER_ID = "col_user_id";
    public static final String COL_FULLNAME = "col_fullname";
    public static final String COL_PASSWORD = "col_password";
    public static final String COL_EMAIL = "col_email";
    public static final String COL_CONTACT = "col_contact";*/

    public static final String COL_RESERVATIONID = "col_reservation_id";
    public static final String COL_FDESTINATION = "col_fdestination";
    public static final String COL_TDESTINATION = "col_tdestination";
    public static final String COL_MANY = "col_many";
    public static final String COL_DATE = "col_date";
    public static final String COL_TIME = "col_time";
    public static final String COL_VEHICLE = "col_vehicle";

    //define reservation table columns

    private static final String createtableReservation = ("CREATE TABLE " + table_Reservation + " ( " + COL_RESERVATIONID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_FDESTINATION + " TEXT, " + COL_TDESTINATION + " TEXT, " + COL_MANY + " TEXT, " + COL_DATE + " TEXT, " + COL_TIME + " TEXT, " + COL_VEHICLE + " TEXT)");



    public DbHelper(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // private static final String createtableReservation = ("CREATE TABLE "+table_Reservation+ " ( " + COL_RESERVATIONID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_FDESTINATION + " TEXT, " + COL_TDESTINATION + " TEXT, " + COL_MANY + " TEXT, " + COL_DATE + " TEXT, " + COL_TIME + " TEXT, " + COL_VEHICLE + " TEXT)");
        //private static final String createTable = "CREATE TABLE "+ table_name+ "(" + COL_USER_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT, " + COL_FULLNAME + " TEXT, " + COL_PASSWORD + " TEXT, " + COL_EMAIL + " TEXT, " + COL_CONTACT + "  TEXT)";


        db.execSQL(createtableReservation);

        String admin = "CREATE TABLE admin (admin_id INTEGER PRIMARY KEY AUTOINCREMENT, admin_name TEXT, admin_pass TEXT, admin_contact TEXT)";
        db.execSQL(admin);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + table_Reservation);
        onCreate(db);
    }


    public boolean addReservation(reservationDetails reser) {


        SQLiteDatabase dbl = this.getWritableDatabase();

        ContentValues jk = new ContentValues();

        //jk.put(COL_RESERVATION_ID, reserv.getId());
        jk.put(COL_FDESTINATION, reser.getFromDestination());
        jk.put(COL_TDESTINATION, reser.getToDestination());
        jk.put(COL_MANY, reser.getMany());
        jk.put(COL_DATE, reser.getDate());
        jk.put(COL_TIME, reser.getTime());
        jk.put(COL_VEHICLE, reser.getVehicle());

        long rst = dbl.insert(table_Reservation, null, jk);
        dbl.close();

        if (rst == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean deleteOne(reservationDetails op) {

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + table_Reservation + " WHERE " + COL_RESERVATIONID + " = " + op.getId();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }

    }


    public List<reservationDetails> getCar() {

        List<reservationDetails> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + table_Reservation;

        SQLiteDatabase jk = this.getReadableDatabase();

        Cursor cursor = jk.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int reservationID = cursor.getInt(0);
                String fDestination = cursor.getString(1);
                String tDestination = cursor.getString(2);
                String Many = cursor.getString(3);
                String Date = cursor.getString(4);
                String Time = cursor.getString(5);
                String Vehicle = cursor.getString(6);

                reservationDetails res = new reservationDetails(reservationID, fDestination, tDestination, Many, Date, Time, Vehicle);
                returnList.add(res);

            } while (cursor.moveToNext());
        } else {

        }
        cursor.close();
        jk.close();
        return returnList;
    }




    public Boolean updateReservation(int id, String fdestination, String tdestination, String many, String date, String time, String car) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_RESERVATIONID, id);
        contentValues.put(COL_FDESTINATION, fdestination);
        contentValues.put(COL_TDESTINATION, tdestination);
        contentValues.put(COL_MANY, many);
        contentValues.put(COL_DATE, date);
        contentValues.put(COL_TIME, time);
        contentValues.put(COL_VEHICLE, car);

        String queryString = " SELECT * FROM " + table_Reservation + " WHERE " + COL_RESERVATIONID + " = " + id;
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.getCount() > 0) {

            long result = db.update(" tblReservation ", contentValues, " col_reservation_id = ? ", new String[]{"" + id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    //UserSide Database


}

