package com.example.dev7.activities2;


import android.support.design.widget.FloatingActionButton;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    Button fragment;
    FloatingActionButton mMovieButton;
    FloatingActionButton mPlayListButton;
    FloatingActionButton mfab;
    private boolean fabExpanded=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        mfab=findViewById(R.id.fab);
        mMovieButton=findViewById(R.id.fab_movie);
        mPlayListButton=findViewById(R.id.fab_playlist);
        final LinearLayout mMovieLayout=findViewById(R.id.movie_layout);
        final LinearLayout mPlaylistLayout=findViewById(R.id.playlist_layout);
        mfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fabExpanded==true){
                   closeSubMenusFab();
                } else{
                   openSubMenusFab();

                }
            }
        });
       closeSubMenusFab();

        mMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMovie=new Intent(MainActivity.this,FormMovie.class);
                startActivity(intentMovie);
                closeSubMenusFab();
            }
        });

        mPlayListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPlaylist = new Intent(MainActivity.this, FormPlaylist.class);
                startActivity(intentPlaylist);
                closeSubMenusFab();
            }
        });

        tabLayout=findViewById(R.id.tab_id);
        tabLayout.addTab(tabLayout.newTab().setText("Movies"));
        tabLayout.addTab(tabLayout.newTab().setText("Songs"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager=findViewById(R.id.view_pager_id);
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        drawerLayout=findViewById(R.id.drawer);
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.Open,R.string.Close);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final  NavigationView nav_view=findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                displaySelectedScreen(id);
                return true;
            }
        });

    }

    private void displaySelectedScreen(int id){
        switch(id){
            case R.id.movie:
                viewPager.setCurrentItem(0);
                break;

            case R.id.Songs:
               viewPager.setCurrentItem(1);
                break;

            case R.id.add_movie:
                Intent intentMovie=new Intent(MainActivity.this,FormMovie.class);
                startActivity(intentMovie);
                break;

            case R.id.add_playlist:
                Intent intentPlaylist=new Intent(MainActivity.this,FormPlaylist.class);
                startActivity(intentPlaylist);
                break;
        }
        DrawerLayout drawer=findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);

    }

    private  void openSubMenusFab(){
        mMovieButton.setVisibility(View.VISIBLE);
        mPlayListButton.setVisibility(View.VISIBLE);
        fabExpanded=true;
    }

    private  void closeSubMenusFab(){
        mMovieButton.setVisibility(View.INVISIBLE);
        mPlayListButton.setVisibility(View.INVISIBLE);
        fabExpanded=false;

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);
    }

}
