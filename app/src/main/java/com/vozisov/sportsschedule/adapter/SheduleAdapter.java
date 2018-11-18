package com.vozisov.sportsschedule.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vozisov.sportsschedule.R;
import com.vozisov.sportsschedule.model.EventItem;

import java.util.ArrayList;

class SheduleAdapter extends BaseAdapter {

    ArrayList arrayList;
    LayoutInflater lInflater;

    public SheduleAdapter(ArrayList arrayList, Context context) {
        this.arrayList = arrayList;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        EventItem event = (EventItem) arrayList.get(position);

        ((TextView) view.findViewById(R.id.name)).setText(event.getName());
        ((TextView) view.findViewById(R.id.time1)).setText(event.getStartTime());
        ((TextView) view.findViewById(R.id.time2)).setText(event.getEndTime());
        ((TextView) view.findViewById(R.id.place)).setText(event.getPlace());
        ((TextView) view.findViewById(R.id.teacher)).setText(event.getTeacher());

        return view;
    }
}
