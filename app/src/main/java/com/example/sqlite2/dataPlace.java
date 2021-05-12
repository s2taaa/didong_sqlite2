package com.example.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dataPlace extends SQLiteOpenHelper {
    public dataPlace(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE place ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addUser(Place place){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",place.getName());

        db.insert("place",null,values);
    }
    public List<Place> getAll(){
        List<Place>  list = new ArrayList<>();
        String sql="select *from place";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Place place = new Place();
                place.setId(cursor.getInt(0));
                place.setName(cursor.getString(1));
                list.add(place);
            }while(cursor.moveToNext());

        }
        cursor.close();
        db.close();
        return  list;
    }
    public int removePlace(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        return db.delete("Place", "ID =?",
                new String[] {String.valueOf(id)});
    }
}
