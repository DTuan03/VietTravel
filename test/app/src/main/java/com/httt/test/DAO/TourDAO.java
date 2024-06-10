package com.httt.test.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.httt.test.Model.Tour;

import java.util.List;

@Dao
public interface TourDAO {
    @Insert
    void insertTour(Tour tour);

    @Insert
    void insertTours(List<Tour> tours);

    @Delete
    void delete(Tour tour);

    @Query("SELECT * FROM tour")
    List<Tour> getListTour();
}
