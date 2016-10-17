package com.example.administrator.studentsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.studentsystem.Fragment_Main.LandFragment;
import com.example.administrator.studentsystem.Fragment_Main.RegisterFragment;
import com.example.administrator.studentsystem.SqlFH.InsertDialog;
import com.example.administrator.studentsystem.SqlFH.MainActivity;
import com.example.administrator.studentsystem.Video.LocalVideo;
import com.example.administrator.studentsystem.Video.OnlineVideo;

public class MainActivityT extends AppCompatActivity implements View.OnClickListener{

    private FragmentManager mangager;
    private FragmentTransaction transaction;
    private LandFragment landF;
    private RegisterFragment registerF;
    private TextView landT,registerT;
    private DrawerLayout Draw_activity;
    private ImageView main_img;
    private TextView main_textView_permissions,main_textView_userName;
    private RecyclerView main_recyclerView;
    private MyRecyclerAdapter adapter = new MyRecyclerAdapter();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maint);
        initView();
        mangager = getSupportFragmentManager();
        transaction = mangager.beginTransaction();

        landF = new LandFragment();
        registerF = new RegisterFragment();

        transaction.add(R.id.fragment_main,landF).add(R.id.fragment_main,registerF);
        transaction.hide(landF).hide(registerF);
        transaction.show(landF);
        transaction.commit();

    }
    private void initView() {
        Draw_activity= (DrawerLayout) findViewById(R.id.Draw_activity);
        main_textView_permissions= (TextView) findViewById(R.id.main_textView_permissions);
        main_textView_userName= (TextView) findViewById(R.id.main_textView_userName);
        main_recyclerView= (RecyclerView) findViewById(R.id.main_recyclerView);
        main_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        main_recyclerView.setAdapter(adapter);
        //跳转到功能界面和本地视频以及在线视频
        adapter.setOnItemClickListener(new MyRecyclerAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View v) {
                switch (v.getId()){
                    case R.id.myFunction:
                        Intent intent = new Intent(MainActivityT.this,MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.local_video:
                        Intent intent1 = new Intent(MainActivityT.this, LocalVideo.class);
                        startActivity(intent1);
                        break;
                    case R.id.online_video:
                        Intent intent2 = new Intent(MainActivityT.this, OnlineVideo.class);
                        startActivity(intent2);
                        break;
                }
            }
        });


        main_img= (ImageView) findViewById(R.id.main_img);
        Toolbar toolbar= (Toolbar) findViewById(R.id.tb);
        toolbar.setTitle("学生管理系统");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuTtemId=item.getItemId();
                if(menuTtemId==R.id.exit){
                   finish();
                    return true;
                }else if (menuTtemId == R.id.cancellation){

                }
                return true;
            }
        });
        setSupportActionBar(toolbar);

        landT = (TextView) findViewById(R.id.land_main);
        registerT = (TextView) findViewById(R.id.register_main);
        landT.setOnClickListener(this);
        registerT.setOnClickListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,Draw_activity,toolbar,R.string.app_name,R.string.app_name);
        toggle.syncState();
        Draw_activity.addDrawerListener(toggle);
        main_textView_permissions.setText(SharedUitl.getInstance(this).getSPitem2());
        main_textView_userName.setText(SharedUitl.getInstance(this).getSPData());
//        tx.setText(SharedUitl.getInstance(this).getSPData());
//        tx_quanxian.setText(SharedUitl.getInstance(this).getSPitem2());
//        Intent intent = new Intent(MainActivityT.this, MainActivity.class);
//                        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        //设置右上角的填充菜单
        getMenuInflater().inflate(R.menu.base_toobler_menu,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        transaction = mangager.beginTransaction();
        switch (v.getId()){
            case R.id.land_main:
                transaction.hide(registerF).hide(landF);
                transaction.show(landF);
                break;
            case R.id.register_main:
                transaction.hide(registerF).hide(landF);
                transaction.show(registerF);
                break;
        }
        transaction.commit();
    }

}
