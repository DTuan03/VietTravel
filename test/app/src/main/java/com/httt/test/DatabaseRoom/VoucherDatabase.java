package com.httt.test.DatabaseRoom;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.httt.test.DAO.TourDAO;
import com.httt.test.DAO.VoucherDAO;
import com.httt.test.Model.Tour;
import com.httt.test.Model.Voucher;

@Database(entities = {Voucher.class}, version = 1)
public abstract class VoucherDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "vouchers.db";

    private static VoucherDatabase instance;

    public abstract VoucherDAO voucherDAO();
    public static synchronized VoucherDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), VoucherDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}