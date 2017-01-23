package com.octagonproject.octagon.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.octagonproject.octagon.vo.CartItemVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vikesh on 23-01-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "CART_MANAGER";

    // Contacts table name
    private static final String TABLE_CART = "CART";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PRICE = "price";
    private static final String KEY_QUANTITY = "quantity";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CART + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PRICE + " INTEGER," + KEY_QUANTITY + "INTEGER" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);

        // Create tables again
        onCreate(db);
    }

    public void addCartItem(CartItemVO cartItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, cartItem.getName());
        values.put(KEY_PRICE, cartItem.getPrice());
        values.put(KEY_QUANTITY, cartItem.getQuantity());

        // Inserting Row
        db.insert(TABLE_CART, null, values);
        db.close(); // Closing database connection
    }

    public CartItemVO getCartItem(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CART, new String[]{KEY_ID,
                        KEY_NAME, KEY_PRICE, KEY_QUANTITY}, KEY_NAME + "=?",
                new String[]{name}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        CartItemVO item = new CartItemVO(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
        // return contact
        return item;
    }


    public List<CartItemVO> getAllCartItems() {
        List<CartItemVO> itemList = new ArrayList<CartItemVO>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CART;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CartItemVO item = new CartItemVO();
                item.setID(Integer.parseInt(cursor.getString(0)));
                item.setName(cursor.getString(1));
                item.setPrice(cursor.getInt(2));
                item.setQuantity(cursor.getInt(3));
                // Adding items to list
                itemList.add(item);
            } while (cursor.moveToNext());
        }

        return itemList;
    }

    public int getCartItemsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CART;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public int updateCartItem(CartItemVO item) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, item.getName());
        values.put(KEY_PRICE, item.getPrice());
        values.put(KEY_QUANTITY, item.getQuantity());

        // updating row
        return db.update(TABLE_CART, values, KEY_NAME + " = ?",
                new String[]{item.getName()});
    }

    public void deleteContact(CartItemVO item) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, KEY_NAME + " = ?",
                new String[]{item.getName()});
        db.close();
    }
}
