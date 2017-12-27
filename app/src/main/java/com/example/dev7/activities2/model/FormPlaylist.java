package com.example.dev7.activities2.model;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dev7.activities2.R;
import com.example.dev7.activities2.database.AppDatabase;
import com.example.dev7.activities2.events.GeneralEvents;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FormPlaylist extends AppCompatActivity  {
    Button addSong;
    Toolbar toolbar;
    Button btnDate;
    int year;
    int month;
    int day;
    private EditText songEdit;
    private EditText singerEdit;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_playlist);
        toolbar=findViewById(R.id.toolbar);
        addSong=findViewById(R.id.button2);
        btnDate=findViewById(R.id.btn_datePicker);
        songEdit=findViewById(R.id.edit_text_song);
        singerEdit=findViewById(R.id.edit_text_singer);
        EventBus.getDefault().register(this);
        db= Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"movie_and_song")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        final Song objSong = (Song) getIntent().getSerializableExtra("obj");
        if(objSong!=null){
            songEdit.setText(objSong.getSong());
            singerEdit.setText(objSong.getSinger());
        }
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM  dd, yyyy h:mm a");
        String dateString = sdf.format(date);

        btnDate.setText(dateString);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                day=calendar.get(Calendar.DAY_OF_MONTH);
                month=calendar.get(Calendar.MONTH);
                year=calendar.get(Calendar.YEAR);
                DatePickerDialog pickerDialog=new DatePickerDialog(FormPlaylist.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    }
                }, year, month, day);
                pickerDialog.show();
            }
        });

        addSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(objSong==null){
                    Song song=new Song();
                    song.setSong(songEdit.getText().toString());
                    song.setSinger(singerEdit.getText().toString());
                    db.songDao().insertAll(song);
                } else{
                    objSong.setSong(songEdit.getText().toString());
                    objSong.setSinger(singerEdit.getText().toString());
                    db.songDao().updateAll(objSong);
                }
                openDialog();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        GeneralEvents.ToolbarEventSong toolbarEvent = new GeneralEvents.ToolbarEventSong();
        toolbarEvent.name=objSong.getSong();
        toolbarEvent.singer=objSong.getSinger();
        EventBus.getDefault().post(toolbarEvent);

    }



    private void openDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(FormPlaylist.this);
        builder.setTitle("Save song?");
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Song successfully saved",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            this.finish();
        } return super.onOptionsItemSelected(item);
    }

   @Subscribe(threadMode = ThreadMode.MAIN)
      public void setToolbar(GeneralEvents.ToolbarEventSong event){
        getSupportActionBar().setTitle(event.name+"-"+event.singer);

    }



}

