package com.tactfactory.kikivyhun.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tactfactory.kikivyhun.R;
import com.tactfactory.kikivyhun.adapter.EventAdapter;
import com.tactfactory.kikivyhun.entities.Event;

import java.util.ArrayList;
import java.util.Date;

public class EventActivity extends AppCompatActivity {

    ListView eventList;
    EventAdapter eventAdapter;
//    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        eventList = (ListView) findViewById(R.id.eventListView);

        ArrayList<Event> events = setUpTestingEvents();

        eventAdapter = new EventAdapter(EventActivity.this,events);

//        bar = (ProgressBar) this.findViewById(R.id.progressBar);
//        ProgressTask task = new ProgressTask();
//        task.execute();

        eventList.setAdapter(eventAdapter);

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(EventActivity.this, DetailEventActivity.class));
            }
        });

        eventList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Event item = eventAdapter.getItem(position);
                Toast.makeText(EventActivity.this,"long click on item " + item.getTitle(),Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }

    private ArrayList<Event> setUpTestingEvents() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("event11","party","kerlan",new Date()));
        events.add(new Event("event21","bubble party","kerlan",new Date()));
        events.add(new Event("event12","party","kerlan",new Date()));
        events.add(new Event("event22","bubble party","kerlan",new Date()));
        events.add(new Event("event13","party","kerlan",new Date()));
        events.add(new Event("event23","bubble party","kerlan",new Date()));
        events.add(new Event("event14","party","kerlan",new Date()));
        events.add(new Event("event24","bubble party","kerlan",new Date()));
        events.add(new Event("event15","party","kerlan",new Date()));
        events.add(new Event("event25","bubble party","kerlan",new Date()));
        events.add(new Event("event16","party","kerlan",new Date()));
        events.add(new Event("event26","bubble party","kerlan",new Date()));
        events.add(new Event("event17","party","kerlan",new Date()));
        events.add(new Event("event27","bubble party","kerlan",new Date()));
        events.add(new Event("event18","party","kerlan",new Date()));
        events.add(new Event("event28","bubble party","kerlan",new Date()));
        events.add(new Event("event19","party","kerlan",new Date()));
        events.add(new Event("event29","bubble party","kerlan",new Date()));
        events.add(new Event("event10","party","kerlan",new Date()));
        events.add(new Event("event20","bubble party","kerlan",new Date()));
        events.add(new Event("event101","party","kerlan",new Date()));
        events.add(new Event("event201","bubble party","kerlan",new Date()));
        return events;
    }

//    private class ProgressTask extends AsyncTask<Integer, Void, Integer[]> {
//        @Override
//        protected void onPreExecute(){
//            bar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected Integer[] doInBackground(Integer... arg0) {
//            //my stuff is here
//            for(int i = 0; i < 100000 ; i++){
//
//            }
//            return arg0;
//        }
//
//        @Override
//        protected void onPostExecute(Integer[] result) {
//            bar.setVisibility(View.GONE);
//        }
//    }
}
