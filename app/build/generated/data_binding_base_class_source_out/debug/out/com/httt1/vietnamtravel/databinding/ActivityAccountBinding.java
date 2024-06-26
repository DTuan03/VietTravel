// Generated by view binder compiler. Do not edit!
package com.httt1.vietnamtravel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.httt1.vietnamtravel.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAccountBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CircleImageView activityAccountImg;

  @NonNull
  public final ImageView activityAccountImgBack;

  @NonNull
  public final TextView activityAccountTvEditCountry;

  @NonNull
  public final TextView activityAccountTvEditDate;

  @NonNull
  public final TextView activityAccountTvEditEmail;

  @NonNull
  public final TextView activityAccountTvEditImg;

  @NonNull
  public final TextView activityAccountTvEditName;

  @NonNull
  public final TextView activityAccountTvEditPhone;

  @NonNull
  public final TextView activityAccountTvShowCountry;

  @NonNull
  public final TextView activityAccountTvShowDate;

  @NonNull
  public final TextView activityAccountTvShowEmail;

  @NonNull
  public final TextView activityAccountTvShowName;

  @NonNull
  public final TextView activityAccountTvShowPhone;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView textView25;

  @NonNull
  public final TextView textView42;

  @NonNull
  public final TextView textView44;

  @NonNull
  public final TextView textView448;

  @NonNull
  public final TextView textView449;

  @NonNull
  public final TextView textView474;

  @NonNull
  public final TextView textView50;

  @NonNull
  public final View view4;

  @NonNull
  public final View view432;

  @NonNull
  public final View view45;

  @NonNull
  public final View view78;

  @NonNull
  public final View view8;

  @NonNull
  public final View view9;

  private ActivityAccountBinding(@NonNull ConstraintLayout rootView,
      @NonNull CircleImageView activityAccountImg, @NonNull ImageView activityAccountImgBack,
      @NonNull TextView activityAccountTvEditCountry, @NonNull TextView activityAccountTvEditDate,
      @NonNull TextView activityAccountTvEditEmail, @NonNull TextView activityAccountTvEditImg,
      @NonNull TextView activityAccountTvEditName, @NonNull TextView activityAccountTvEditPhone,
      @NonNull TextView activityAccountTvShowCountry, @NonNull TextView activityAccountTvShowDate,
      @NonNull TextView activityAccountTvShowEmail, @NonNull TextView activityAccountTvShowName,
      @NonNull TextView activityAccountTvShowPhone, @NonNull LinearLayout linearLayout,
      @NonNull ConstraintLayout main, @NonNull TextView textView25, @NonNull TextView textView42,
      @NonNull TextView textView44, @NonNull TextView textView448, @NonNull TextView textView449,
      @NonNull TextView textView474, @NonNull TextView textView50, @NonNull View view4,
      @NonNull View view432, @NonNull View view45, @NonNull View view78, @NonNull View view8,
      @NonNull View view9) {
    this.rootView = rootView;
    this.activityAccountImg = activityAccountImg;
    this.activityAccountImgBack = activityAccountImgBack;
    this.activityAccountTvEditCountry = activityAccountTvEditCountry;
    this.activityAccountTvEditDate = activityAccountTvEditDate;
    this.activityAccountTvEditEmail = activityAccountTvEditEmail;
    this.activityAccountTvEditImg = activityAccountTvEditImg;
    this.activityAccountTvEditName = activityAccountTvEditName;
    this.activityAccountTvEditPhone = activityAccountTvEditPhone;
    this.activityAccountTvShowCountry = activityAccountTvShowCountry;
    this.activityAccountTvShowDate = activityAccountTvShowDate;
    this.activityAccountTvShowEmail = activityAccountTvShowEmail;
    this.activityAccountTvShowName = activityAccountTvShowName;
    this.activityAccountTvShowPhone = activityAccountTvShowPhone;
    this.linearLayout = linearLayout;
    this.main = main;
    this.textView25 = textView25;
    this.textView42 = textView42;
    this.textView44 = textView44;
    this.textView448 = textView448;
    this.textView449 = textView449;
    this.textView474 = textView474;
    this.textView50 = textView50;
    this.view4 = view4;
    this.view432 = view432;
    this.view45 = view45;
    this.view78 = view78;
    this.view8 = view8;
    this.view9 = view9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAccountBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_account, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAccountBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.activity_account_img;
      CircleImageView activityAccountImg = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountImg == null) {
        break missingId;
      }

      id = R.id.activity_account_img_back;
      ImageView activityAccountImgBack = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountImgBack == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_edit_country;
      TextView activityAccountTvEditCountry = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvEditCountry == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_edit_date;
      TextView activityAccountTvEditDate = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvEditDate == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_edit_email;
      TextView activityAccountTvEditEmail = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvEditEmail == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_edit_img;
      TextView activityAccountTvEditImg = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvEditImg == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_edit_name;
      TextView activityAccountTvEditName = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvEditName == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_edit_phone;
      TextView activityAccountTvEditPhone = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvEditPhone == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_show_country;
      TextView activityAccountTvShowCountry = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvShowCountry == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_show_date;
      TextView activityAccountTvShowDate = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvShowDate == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_show_email;
      TextView activityAccountTvShowEmail = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvShowEmail == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_show_name;
      TextView activityAccountTvShowName = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvShowName == null) {
        break missingId;
      }

      id = R.id.activity_account_tv_show_phone;
      TextView activityAccountTvShowPhone = ViewBindings.findChildViewById(rootView, id);
      if (activityAccountTvShowPhone == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.textView25;
      TextView textView25 = ViewBindings.findChildViewById(rootView, id);
      if (textView25 == null) {
        break missingId;
      }

      id = R.id.textView42;
      TextView textView42 = ViewBindings.findChildViewById(rootView, id);
      if (textView42 == null) {
        break missingId;
      }

      id = R.id.textView44;
      TextView textView44 = ViewBindings.findChildViewById(rootView, id);
      if (textView44 == null) {
        break missingId;
      }

      id = R.id.textView448;
      TextView textView448 = ViewBindings.findChildViewById(rootView, id);
      if (textView448 == null) {
        break missingId;
      }

      id = R.id.textView449;
      TextView textView449 = ViewBindings.findChildViewById(rootView, id);
      if (textView449 == null) {
        break missingId;
      }

      id = R.id.textView474;
      TextView textView474 = ViewBindings.findChildViewById(rootView, id);
      if (textView474 == null) {
        break missingId;
      }

      id = R.id.textView50;
      TextView textView50 = ViewBindings.findChildViewById(rootView, id);
      if (textView50 == null) {
        break missingId;
      }

      id = R.id.view4;
      View view4 = ViewBindings.findChildViewById(rootView, id);
      if (view4 == null) {
        break missingId;
      }

      id = R.id.view432;
      View view432 = ViewBindings.findChildViewById(rootView, id);
      if (view432 == null) {
        break missingId;
      }

      id = R.id.view45;
      View view45 = ViewBindings.findChildViewById(rootView, id);
      if (view45 == null) {
        break missingId;
      }

      id = R.id.view78;
      View view78 = ViewBindings.findChildViewById(rootView, id);
      if (view78 == null) {
        break missingId;
      }

      id = R.id.view8;
      View view8 = ViewBindings.findChildViewById(rootView, id);
      if (view8 == null) {
        break missingId;
      }

      id = R.id.view9;
      View view9 = ViewBindings.findChildViewById(rootView, id);
      if (view9 == null) {
        break missingId;
      }

      return new ActivityAccountBinding((ConstraintLayout) rootView, activityAccountImg,
          activityAccountImgBack, activityAccountTvEditCountry, activityAccountTvEditDate,
          activityAccountTvEditEmail, activityAccountTvEditImg, activityAccountTvEditName,
          activityAccountTvEditPhone, activityAccountTvShowCountry, activityAccountTvShowDate,
          activityAccountTvShowEmail, activityAccountTvShowName, activityAccountTvShowPhone,
          linearLayout, main, textView25, textView42, textView44, textView448, textView449,
          textView474, textView50, view4, view432, view45, view78, view8, view9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
