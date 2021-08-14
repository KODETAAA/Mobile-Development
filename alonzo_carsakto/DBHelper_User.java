package com.example.alonzo_carsakto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper_User extends SQLiteOpenHelper {
    public static final String database_name = "dbCarsaktoUsers.db";

    public static final String TBL_USERS = "tblUsers";


    public static final String COL_USER_ID = "col_user_id";
    public static final String COL_FULLNAME = "col_fullname";
    public static final String COL_PASSWORD = "col_password";
    public static final String COL_EMAIL = "col_email";
    public static final String COL_CONTACT = "col_contact";

    private static final String createTable = "CREATE TABLE " + TBL_USERS + " ( " + COL_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_FULLNAME +
            " TEXT, " + COL_PASSWORD + " TEXT, " + COL_EMAIL + " TEXT, " + COL_CONTACT +  " TEXT )";

    public DBHelper_User(@Nullable Context context) {
        super(context, database_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_USERS);
        onCreate(db);
    }

    public boolean createUser(UserAcct user) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        //cv.put(COL_USER_ID, user.getId());
        cv.put(COL_FULLNAME, user.getFname());
        cv.put(COL_PASSWORD, user.getPass());
        cv.put(COL_EMAIL, user.getEmail());
        cv.put(COL_CONTACT, user.getContact());

        long result = db.insert(TBL_USERS, null, cv);
        db.close();

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

   /* public boolean checkUser(String email, String password) {
        // array of columns to fetch
        String[] columns = {COL_USER_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COL_EMAIL + " = ?" + " AND " + COL_PASSWORD + " = ?";
        //String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';

        Cursor cursor = db.query(TBL_USERS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }*/

    public Boolean checkEmailsandPassword(String email, String password){

        SQLiteDatabase you = this.getWritableDatabase();
        Cursor cursor = you.rawQuery("SELECT * FROM " + TBL_USERS + " WHERE " + COL_EMAIL + "= ?" + " AND " + COL_PASSWORD + "= ? ", new String[] {email, password});
       
        if (cursor.getCount()>0){
            return true;
        }else{
            return false;
        }

    }

    /*public Boolean checkEmailsandPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(" Select * from tblUsers where col_email = ? and col_password = ?", new String[] {email,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }*/
}
