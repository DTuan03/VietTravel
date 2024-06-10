package com.httt.test.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.httt.test.Model.Voucher;

import java.util.List;

@Dao
public interface VoucherDAO {
    @Insert
    void insertVoucher(Voucher voucher);

    @Insert
    void insertVouchers(List<Voucher> vouchers);

    @Delete
    void delete(Voucher voucher);

    @Query("SELECT * FROM voucher")
    List<Voucher> getListVoucher();
}
