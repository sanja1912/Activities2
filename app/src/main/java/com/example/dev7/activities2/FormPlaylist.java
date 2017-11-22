package com.example.dev7.activities2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.net.URI;
import java.text.DateFormat;
import java.util.Calendar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

public class FormPlaylist extends AppCompatActivity  {
    Button addSong;
    Toolbar toolbar;
    Button btnDate;

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_playlist);
        toolbar=findViewById(R.id.toolbar);
        addSong=findViewById(R.id.button2);
        btnDate=findViewById(R.id.btn_datePicker);
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

                openDialog();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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



}

