package com.httt.test.DatabaseRoom;

import android.content.Context;
import android.service.autofill.UserData;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.httt.test.DAO.TourDAO;
import com.httt.test.Model.Tour;

@Database(entities = {Tour.class}, version = 1)
public abstract class TourDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "tours.db";

    private static TourDatabase instance;

    public abstract TourDAO tourDAO();
    public static synchronized TourDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TourDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
