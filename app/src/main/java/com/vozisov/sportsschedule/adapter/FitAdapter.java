package com.vozisov.sportsschedule.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.vozisov.sportsschedule.EventDetail;
import com.vozisov.sportsschedule.R;

import java.util.ArrayList;
import java.util.Map;

public class FitAdapter extends PagerAdapter {

    Context context;
    public static Map<Integer, ArrayList> sortedWeek;
    LayoutInflater inflater;
    String[] weeks;

    public FitAdapter(Map<Integer, ArrayList> sortedWeek, Context context) {

        weeks = context.getResources().getStringArray(R.array.weeks);
        this.context = context;
        this.sortedWeek = sortedWeek;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return weeks.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        final int dayNumber = position;

        View v;

        if (!sortedWeek.get(position).isEmpty()) {

            v = inflater.inflate(R.layout.day, container, false);

            ListView shedule = v.findViewById(R.id.shedule);
            shedule.setAdapter(new SheduleAdapter(sortedWeek.get(position), context));

            shedule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(context, EventDetail.class);
                    intent.putExtra("dayNumber", dayNumber);
                    intent.putExtra("pos", position);
                    context.startActivity(intent);
                }
            });
        } else {

            v = inflater.inflate(R.layout.no_events, container, false);
        }

        TextView day = v.findViewById(R.id.day);
        day.setText(weeks[position]);

        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == o;
    }
}
