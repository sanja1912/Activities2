package com.example.dev7.activities2;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FormMovie extends AppCompatActivity {
    Button add;
    Toolbar toolbar;
    Button btnDate;
    int year;
    int month;
    int day;
    private MovieDao movieDao;
    private EditText nameOfMovie;
    private EditText description;
    private Query<Movie>movieQuery;
    private AdapterSong adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_movie);

        toolbar=findViewById(R.id.toolbar);
        add=findViewById(R.id.button2);

        btnDate=findViewById(R.id.btn_datePicker);
        nameOfMovie=findViewById(R.id.edit_text_movie);
        description=findViewById(R.id.edit_text_description);

        final Movie objMovie = (Movie) getIntent().getSerializableExtra("obj");
        if(objMovie!=null) {
            nameOfMovie.setText(objMovie.getName());
            description.setText(objMovie.getDescription());
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

                DatePickerDialog pickerDialog=new DatePickerDialog(FormMovie.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    }
                }, year, month, day);
                pickerDialog.show();


            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaoSession daoSession=((App)getApplication()).getDaoSession();
                movieDao=daoSession.getMovieDao();

                if(objMovie==null){
                    Movie movie=new Movie();
                    movie.getId();
                    movieDao.getKey(movie);
                    movie.setName(nameOfMovie.getText().toString());
                    movie.setDescription(description.getText().toString());
                    movieDao.insert(movie);

                }
                if(objMovie==null){
                    Movie movie=new Movie();
                    movie.getId();
                    movieDao.getKey(movie);
                    movie.setName(nameOfMovie.getText().toString());
                    movie.setDescription(description.getText().toString());
                    movieDao.insert(movie);

                } else{

                    objMovie.setName(nameOfMovie.getText().toString());
                    objMovie.setDescription(description.getText().toString());
                    movieDao.update(objMovie);

                }
                openDialog();




            }
        });

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        if(id==android.R.id.home){
            this.finish();

        } return super.onOptionsItemSelected(item);
    }

    private void openDialog() {

        Log.d("CHECK_DIALOG", "openDialog: ");

        AlertDialog.Builder builder=new AlertDialog.Builder(FormMovie.this);
        builder.setTitle("Save movie?");
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Movie successfully saved",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        });

        AlertDialog alert=builder.create();
       alert.show();

    }
}
