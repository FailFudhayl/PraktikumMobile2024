package com.example.cobashop.LocalDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shopping_app.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "user";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public static final String TABLE_CART = "cart";
    public static final String COLUMN_CART_ID = "cart_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_PRICE = "price";
    public static final String COLUMN_RATING = "rating";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_USER_ID_FK = "user_id";

    public static final String TABLE_TRANSACTION_HISTORY = "transaction_history";
    public static final String COLUMN_TRANSACTION_ID = "transaction_id";
    public static final String COLUMN_TRANSACTION_TITLE = "transaction_title";
    public static final String COLUMN_TRANSACTION_IMAGE = "transaction_image";
    public static final String COLUMN_TRANSACTION_DATE = "transaction_date";
    public static final String COLUMN_TRANSACTION_TOTAL_PRICE = "transaction_total_price";
    public static final String COLUMN_TRANSACTION_USER_ID_FK = "user_id";

    private static final String TABLE_CREATE_USER =
            "CREATE TABLE " + TABLE_USER + " (" +
                    COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_USERNAME + " TEXT, " +
                    COLUMN_PASSWORD + " TEXT" +
                    ");";

    private static final String TABLE_CREATE_CART =
            "CREATE TABLE " + TABLE_CART + " (" +
                    COLUMN_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_PRICE + " REAL, " +
                    COLUMN_RATING + " REAL, " +
                    COLUMN_IMAGE + " TEXT, " +
                    COLUMN_USER_ID_FK + " INTEGER, " +
                    "FOREIGN KEY (" + COLUMN_USER_ID_FK + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ")" +
                    ");";

    private static final String TABLE_CREATE_TRANSACTION_HISTORY =
            "CREATE TABLE " + TABLE_TRANSACTION_HISTORY + " (" +
                    COLUMN_TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TRANSACTION_TITLE + " TEXT, " +
                    COLUMN_TRANSACTION_IMAGE + " TEXT, " +
                    COLUMN_TRANSACTION_DATE + " TEXT, " +
                    COLUMN_TRANSACTION_TOTAL_PRICE + " REAL, " +
                    COLUMN_TRANSACTION_USER_ID_FK + " INTEGER, " +
                    "FOREIGN KEY (" + COLUMN_TRANSACTION_USER_ID_FK + ") REFERENCES " + TABLE_USER + "(" + COLUMN_USER_ID + ")" +
                    ");";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_USER);
        db.execSQL(TABLE_CREATE_CART);
        db.execSQL(TABLE_CREATE_TRANSACTION_HISTORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRANSACTION_HISTORY);
        onCreate(db);
    }

    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USER, null, values);
        db.close();
        return result != -1;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_USER_ID};
        String selection = COLUMN_USERNAME + " = ? AND " + COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count > 0;
    }
}


