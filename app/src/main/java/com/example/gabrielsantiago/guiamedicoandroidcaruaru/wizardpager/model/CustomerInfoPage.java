package com.example.gabrielsantiago.guiamedicoandroidcaruaru.wizardpager.model;

/**
 * Created by gabriel.santiago on 12/11/2015.
 */
import com.example.gabrielsantiago.guiamedicoandroidcaruaru.wizardpager.ui.CustomerInfoFragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * A page asking for a name and an email.
 */
public class CustomerInfoPage extends Page {
    public static final String NAME_DATA_KEY = "name";
    public static final String EMAIL_DATA_KEY = "email";

    public CustomerInfoPage(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Fragment createFragment() {
        return CustomerInfoFragment.create(getKey());
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem("Seu nome", mData.getString(NAME_DATA_KEY), getKey(), -1));
        dest.add(new ReviewItem("Seu email", mData.getString(EMAIL_DATA_KEY), getKey(), -1));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(NAME_DATA_KEY));
    }
}