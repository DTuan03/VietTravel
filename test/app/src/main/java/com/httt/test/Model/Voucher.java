package com.httt.test.Model;

import android.net.Uri;
import android.widget.TextView;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "voucher")
public class Voucher implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IDVoucher")
    public int id_voucher;
    @ColumnInfo(name = "ImageVoucher")
    public String img_voucher;
    @ColumnInfo(name = "TitleOfVoucher")
    public String tv_title_voucher;
    @ColumnInfo(name = "DescriptionOfVoucher")
    public String tv_description_voucher;

    public Voucher(){

    }

    public Voucher(String img_voucher, String tv_title_voucher, String tv_description_voucher) {
        this.img_voucher = img_voucher;
        this.tv_title_voucher = tv_title_voucher;
        this.tv_description_voucher = tv_description_voucher;
    }

    public String getImg_voucher() {
        return img_voucher;
    }

    public void setImg_voucher(String img_voucher) {
        this.img_voucher = img_voucher;
    }

    public int getId_voucher() {
        return id_voucher;
    }

    public void setId_voucher(int id_voucher) {
        this.id_voucher = id_voucher;
    }

    public String getTv_title_voucher() {
        return tv_title_voucher;
    }

    public void setTv_title_voucher(String tv_title_voucher) {
        this.tv_title_voucher = tv_title_voucher;
    }

    public String getTv_description_voucher() {
        return tv_description_voucher;
    }

    public void setTv_description_voucher(String tv_description_voucher) {
        this.tv_description_voucher = tv_description_voucher;
    }
}
