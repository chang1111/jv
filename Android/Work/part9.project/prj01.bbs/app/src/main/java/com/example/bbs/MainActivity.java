package com.example.bbs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Intent;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // 상수 
    private static final int REQUEST_CODE_LOGIN = 9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        
        
        // Preference 객체 얻기. 파일이름은 Settings.xml
        SharedPreferences pref = getSharedPreferences( CommonCode.FILE_PREFERECE, MODE_PRIVATE);
        boolean loginStatus = pref.getBoolean( CommonCode.LOGIN_STATUS, false);
        setShowHideNavigation( loginStatus );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        } else if (id == R.id.action_pref) {
            return true;
        } else if (id == R.id.action_pref2) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_login) {
            // Context 얻는 3가지 방법.
            // 1. getApplicationContext()
            // 2. getContext()
            // 3. MainActivity.this

            // 새창 띄우기
            Intent i = new Intent( /* context */ MainActivity.this  ,  /* class 이름 */ LoginActivity.class);
            startActivityForResult( i, REQUEST_CODE_LOGIN );

        } else if (id == R.id.nav_logout) {
            setShowHideNavigation( false );
        }
        else if (id == R.id.nav_manage) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // requestCode == REQUEST_CODE_LOGIN
        // resultCode  == RESULT_OK
        // data   == 처리된 결과 정보가 들어 있다.

        // 결과 확인
        if( requestCode == REQUEST_CODE_LOGIN && resultCode == RESULT_OK ){
            // 로그인에 성공했을 때.
            boolean loginStatus = data.getBooleanExtra(CommonCode.LOGIN_STATUS, false);
            // menu 보이고 감추기..
            NavigationView navView = findViewById(R.id.nav_view);
            setShowHideNavigation( true );

        }
    }

    /**
     *
     * @param isVisible : 로그인이 안되어 있으면 false 인자로
     *                    로그인이 되어 있는 true를 인자로 받는다.
     */
    private void setShowHideNavigation(boolean isVisible) {
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        if (navView != null) {
            Menu menu = navView.getMenu();
            menu.findItem(R.id.nav_login   ).setVisible(!isVisible);
            menu.findItem(R.id.nav_register).setVisible(!isVisible);
            menu.findItem(R.id.nav_logout  ).setVisible( isVisible);
            menu.findItem(R.id.nav_memedit ).setVisible( isVisible);
        }
    }
}
