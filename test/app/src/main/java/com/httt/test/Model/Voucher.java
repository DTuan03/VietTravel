package com.httt.test.Model;

import android.net.Uri;
import android.widget.TextView;

import java.io.Serializable;

public class Voucher implements Serializable {
    public int img_voucher;
    public String tv_title_voucher;
    public String tv_description_voucher;

    public Voucher(int img_voucher, String tv_title_voucher, String tv_description_voucher) {
        this.img_voucher = img_voucher;
        this.tv_title_voucher = tv_title_voucher;
        this.tv_description_voucher = tv_description_voucher;
    }

    public int getImg_voucher() {
        return img_voucher;
    }

    public void setImg_voucher(int img_voucher) {
        this.img_voucher = img_voucher;
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
