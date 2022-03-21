package com.practice.bacd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class ThanksDonation extends AppCompatActivity {
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks_donation);
        ratingBar =(RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(ThanksDonation.this, "Stars: "+rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
