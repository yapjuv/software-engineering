package com.example.viceseethee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME ="register.db";
    public static final String TABLE_NAME ="registeruser";
    public static final String TABLE_STAT = "userstat";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="username";
    public static final String COL_3 ="password";
    public static final String column1 = "log";
    public static final String column2 = "datevice";
    public static final String column3 = "cig";
    public static final String column4 = "cigcost";
    public static final String column5 = "beer";
    public static final String column6 = "beercost";
    public static final String column7 = "registeruser_ID";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE registeruser (ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT UNIQUE, password TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE userstat (log INTEGER PRIMARY KEY AUTOINCREMENT, datevice VARCHAR, cig VARCHAR,cigcost VARCHAR, beer VARCHAR, beercost VARCHAR,registeruser_ID INTEGER, FOREIGN KEY(registeruser_ID) REFERENCES registeruser(ID) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_STAT);
        onCreate(sqLiteDatabase);
    }

    public long addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return  res;
    }

    public boolean checkUser(String username, String password){
        String[] columns = { COL_1 };
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0)
            return  true;
        else
            return  false;
    }

    public long insertData(String datevice, String cig, String cigcost, String beer, String beercost){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(column2,datevice);
        contentValues.put(column3,cig);
        contentValues.put(column4,cigcost);
        contentValues.put(column5,beer);
        contentValues.put(column6,beercost);
        long result = db.insert("userstat", null,contentValues);
        db.close();
        return result;

    }
}
