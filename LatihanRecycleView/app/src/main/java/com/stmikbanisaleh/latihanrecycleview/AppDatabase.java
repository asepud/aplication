package com.stmikbanisaleh.latihanrecycleview;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import javax.xml.namespace.QName;

@Database(entities = {Dosen.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DosenDao dosenDao();

    public static AppDatabase db;

    public static AppDatabase getDb(Context context){
        if(db == null){
            db = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "db_dosen")
                    .enableMultiInstanceInvalidation()
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
            Log.i("Database Initialized", "Database Initialized");
        }
        return db;
    }

}
