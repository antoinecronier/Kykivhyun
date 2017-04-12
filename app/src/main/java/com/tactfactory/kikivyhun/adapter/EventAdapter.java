package com.tactfactory.kikivyhun.adapter;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.tactfactory.kikivyhun.MyApplication;
import com.tactfactory.kikivyhun.R;
import com.tactfactory.kikivyhun.activities.EventActivity;
import com.tactfactory.kikivyhun.entities.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by tactfactory on 12/04/17.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private Context context;

    public EventAdapter(@NonNull Context context, @NonNull List<Event> objects) {
        super(context, 0, objects);

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_row, parent, false);
        }

        EventViewHolder viewHolder = (EventViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EventViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.textViewEventRowTitle);
            viewHolder.category = (TextView) convertView.findViewById(R.id.textViewEventRowCategorie);
            viewHolder.start_date = (TextView) convertView.findViewById(R.id.textViewEventRowStartDate);
            viewHolder.city = (TextView) convertView.findViewById(R.id.textViewEventRowCity);
            viewHolder.participation = (Switch) convertView.findViewById(R.id.switchEventRowParticipation);
            convertView.setTag(viewHolder);
        }

        Event event = getItem(position);

        viewHolder.title.setText(event.getTitle());
        viewHolder.category.setText(event.getCategory().getName());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        viewHolder.start_date.setText(df.format(event.getStart_date()));

        viewHolder.city.setText(event.getPlace().getAddress().getCity());
        //viewHolder.participation.setChecked();


        viewHolder.participation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(EventAdapter.this.context,"checked " + isChecked,Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

    private class EventViewHolder{
        public TextView title;
        public TextView category;
        public TextView start_date;
        public TextView city;
        public Switch participation;
    }
}
