package com.codepath.android.lollipopexercise.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.android.lollipopexercise.R;
import com.codepath.android.lollipopexercise.models.Contact;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACT = "EXTRA_CONTACT";
    public static final String BACKGROUND_COLOR = "BACKGROUND_COLOR";
    public static final String TEXT_COLOR = "TEXT_COLOR";
    private Contact mContact;
    private ImageView ivProfile;
    private TextView tvName;
    private TextView tvPhone;
    private View vPalette;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        vPalette = findViewById(R.id.vPalette);

        // Extract contact from bundle
        Intent i = getIntent();
        mContact = Parcels.unwrap(i.getParcelableExtra(EXTRA_CONTACT));
        int backgroundColor = i.getIntExtra(BACKGROUND_COLOR, 0);
        int textColor = i.getIntExtra(TEXT_COLOR, 0);

        // Fill views with data
        Glide.with(DetailsActivity.this).load(mContact.getThumbnailDrawable()).centerCrop().into(ivProfile);
        tvName.setText(mContact.getName());
        tvPhone.setText(mContact.getNumber());
        vPalette.setBackgroundColor(backgroundColor);
        tvName.setTextColor(textColor);
        tvPhone.setTextColor(textColor);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
