package com.vozisov.sportsschedule;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vozisov.sportsschedule.adapter.FitAdapter;
import com.vozisov.sportsschedule.model.EventItem;

public class EventDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        TextView name, time1, time2, place, desc, tName, tPos;
        ImageView tPhoto;

        name = findViewById(R.id.name);
        time1 = findViewById(R.id.time1);
        time2 = findViewById(R.id.time2);
        place = findViewById(R.id.place);
        desc = findViewById(R.id.desc);
        tName = findViewById(R.id.t_name);
        tPos = findViewById(R.id.t_pos);
        tPhoto = findViewById(R.id.t_photo);

        int dayNumber = getIntent().getIntExtra("dayNumber", 0);
        int pos = getIntent().getIntExtra("pos", 0);

        EventItem eventItem = (EventItem) FitAdapter.sortedWeek.get(dayNumber).get(pos);

        name.setText(eventItem.getName());
        time1.setText(eventItem.getStartTime());
        time2.setText(eventItem.getEndTime());
        place.setText(eventItem.getPlace());
        desc.setText(eventItem.getDescription());

        tName.setText(eventItem.getTeacherV2().getName());
        tPos.setText(eventItem.getTeacherV2().getPosition());

        Picasso.with(getApplicationContext())
                .load(eventItem.getTeacherV2().getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(tPhoto);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
