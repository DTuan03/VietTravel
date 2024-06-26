// Generated by view binder compiler. Do not edit!
package com.httt1.vietnamtravel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.httt1.vietnamtravel.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBookTourBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button activityBookTourBtnBooking;

  @NonNull
  public final EditText activityBookTourEtEmail;

  @NonNull
  public final EditText activityBookTourEtEndDay;

  @NonNull
  public final EditText activityBookTourEtNumberPeople;

  @NonNull
  public final EditText activityBookTourEtPhonenumber;

  @NonNull
  public final EditText activityBookTourEtStartDay;

  @NonNull
  public final EditText activityBookTourEtUsername;

  @NonNull
  public final ShapeableImageView activityBookTourImg;

  @NonNull
  public final ImageView activityBookTourImgBack;

  @NonNull
  public final Spinner activityBookTourSpPaymentMethod;

  @NonNull
  public final Spinner activityBookTourSpVoucher;

  @NonNull
  public final TextView activityBookTourTvPrice;

  @NonNull
  public final TextView activityBookTourTvTitle;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final ScrollView scrollView2;

  @NonNull
  public final TextView text;

  private ActivityBookTourBinding(@NonNull RelativeLayout rootView,
      @NonNull Button activityBookTourBtnBooking, @NonNull EditText activityBookTourEtEmail,
      @NonNull EditText activityBookTourEtEndDay, @NonNull EditText activityBookTourEtNumberPeople,
      @NonNull EditText activityBookTourEtPhonenumber, @NonNull EditText activityBookTourEtStartDay,
      @NonNull EditText activityBookTourEtUsername, @NonNull ShapeableImageView activityBookTourImg,
      @NonNull ImageView activityBookTourImgBack, @NonNull Spinner activityBookTourSpPaymentMethod,
      @NonNull Spinner activityBookTourSpVoucher, @NonNull TextView activityBookTourTvPrice,
      @NonNull TextView activityBookTourTvTitle, @NonNull RelativeLayout main,
      @NonNull ScrollView scrollView2, @NonNull TextView text) {
    this.rootView = rootView;
    this.activityBookTourBtnBooking = activityBookTourBtnBooking;
    this.activityBookTourEtEmail = activityBookTourEtEmail;
    this.activityBookTourEtEndDay = activityBookTourEtEndDay;
    this.activityBookTourEtNumberPeople = activityBookTourEtNumberPeople;
    this.activityBookTourEtPhonenumber = activityBookTourEtPhonenumber;
    this.activityBookTourEtStartDay = activityBookTourEtStartDay;
    this.activityBookTourEtUsername = activityBookTourEtUsername;
    this.activityBookTourImg = activityBookTourImg;
    this.activityBookTourImgBack = activityBookTourImgBack;
    this.activityBookTourSpPaymentMethod = activityBookTourSpPaymentMethod;
    this.activityBookTourSpVoucher = activityBookTourSpVoucher;
    this.activityBookTourTvPrice = activityBookTourTvPrice;
    this.activityBookTourTvTitle = activityBookTourTvTitle;
    this.main = main;
    this.scrollView2 = scrollView2;
    this.text = text;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBookTourBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBookTourBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_book_tour, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBookTourBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.activity_book_tour_btn_booking;
      Button activityBookTourBtnBooking = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourBtnBooking == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_et_email;
      EditText activityBookTourEtEmail = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourEtEmail == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_et_end_day;
      EditText activityBookTourEtEndDay = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourEtEndDay == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_et_number_people;
      EditText activityBookTourEtNumberPeople = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourEtNumberPeople == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_et_phonenumber;
      EditText activityBookTourEtPhonenumber = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourEtPhonenumber == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_et_start_day;
      EditText activityBookTourEtStartDay = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourEtStartDay == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_et_username;
      EditText activityBookTourEtUsername = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourEtUsername == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_img;
      ShapeableImageView activityBookTourImg = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourImg == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_img_back;
      ImageView activityBookTourImgBack = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourImgBack == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_sp_payment_method;
      Spinner activityBookTourSpPaymentMethod = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourSpPaymentMethod == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_sp_voucher;
      Spinner activityBookTourSpVoucher = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourSpVoucher == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_tv_price;
      TextView activityBookTourTvPrice = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourTvPrice == null) {
        break missingId;
      }

      id = R.id.activity_book_tour_tv_title;
      TextView activityBookTourTvTitle = ViewBindings.findChildViewById(rootView, id);
      if (activityBookTourTvTitle == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.scrollView2;
      ScrollView scrollView2 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView2 == null) {
        break missingId;
      }

      id = R.id.text;
      TextView text = ViewBindings.findChildViewById(rootView, id);
      if (text == null) {
        break missingId;
      }

      return new ActivityBookTourBinding((RelativeLayout) rootView, activityBookTourBtnBooking,
          activityBookTourEtEmail, activityBookTourEtEndDay, activityBookTourEtNumberPeople,
          activityBookTourEtPhonenumber, activityBookTourEtStartDay, activityBookTourEtUsername,
          activityBookTourImg, activityBookTourImgBack, activityBookTourSpPaymentMethod,
          activityBookTourSpVoucher, activityBookTourTvPrice, activityBookTourTvTitle, main,
          scrollView2, text);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
