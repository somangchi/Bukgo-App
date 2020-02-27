package com.example.newone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private long time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        FragmentHome fragmenthome = new FragmentHome();
        transaction.replace(R.id.frame, fragmenthome);
        transaction.commit();
    }

    public void OnHomepageClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bukpyeong.gwe.hs.kr/main.do"));
        startActivity(intent);
    }
    public void OnFacebookClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko-kr.facebook.com/bukpyeonghs/"));
        startActivity(intent);
    }
    public void OnLunchClicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EB%B6%81%ED%8F%89%EA%B3%A0%EB%93%B1%ED%95%99%EA%B5%90+%EA%B8%89%EC%8B%9D"));
        startActivity(intent);
    }
    public void OnBusClicked(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragmentbus fragmentbus = new Fragmentbus();
        transaction.replace(R.id.frame, fragmentbus);
        transaction.commit();
    }
    public void OnStation1Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bus.dh.go.kr/index.php?mt=content&cm=road&cp=road&oxid=1&cmd=detailstop&subcmd=info&id=34999&day=3&sdate=20200226&mode=print&busid="));
        startActivity(intent);
    }
    public void OnStation2Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bus.dh.go.kr/index.php?mt=content&cm=road&cp=road&oxid=1&cmd=detailstop&subcmd=info&id=39768&day=3&sdate=20200226&mode=print&busid="));
        startActivity(intent);
    }
    public void OnStation3Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bus.dh.go.kr/index.php?mt=content&cm=road&cp=road&oxid=1&cmd=detailstop&subcmd=info&id=35001&day=3&sdate=20200226&mode=print&busid="));
        startActivity(intent);
    }
    public void OnStation4Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bus.dh.go.kr/index.php?mt=content&cm=road&cp=road&oxid=1&cmd=detailstop&subcmd=info&id=35202&day=3&sdate=20200226&mode=print&busid="));
        startActivity(intent);
    }
    public void OnStation5Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bus.dh.go.kr/index.php?mt=content&cm=road&cp=road&oxid=1&cmd=detailstop&subcmd=info&id=34946&day=3&sdate=20200226&mode=print&busid="));
        startActivity(intent);
    }
    public void OnStation6Clicked(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://bus.dh.go.kr/index.php?mt=content&cm=road&cp=road&oxid=1&cmd=detailstop&subcmd=info&id=35147&day=3&sdate=20200226&mode=print&busid="));
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (System.currentTimeMillis() > time + 2000) {
            time = System.currentTimeMillis();
            Toast.makeText(this, "'뒤로' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG).show();
        } else{
            super.onBackPressed();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            FragmentHome fragmenthome = new FragmentHome();
            transaction.replace(R.id.frame, fragmenthome);
            transaction.commit();
            Toast.makeText(this.getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
        } else if (id== R.id.nav_school) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragmentschool fragmentschool = new Fragmentschool();
            transaction.replace(R.id.frame, fragmentschool);
            transaction.commit();
        } else if (id== R.id.nav_rule) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragmentrule fragmentrule = new Fragmentrule();
            transaction.replace(R.id.frame, fragmentrule);
            transaction.commit();
        } else if (id== R.id.nav_schedule) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragmentschedule fragmentschedule = new Fragmentschedule();
            transaction.replace(R.id.frame, fragmentschedule);
            transaction.commit();
        } else if (id== R.id.nav_club) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            Fragmentclub fragmentclub = new Fragmentclub();
            transaction.replace(R.id.frame, fragmentclub);
            transaction.commit();

        } else if (id== R.id.nav_send) {

        }
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

