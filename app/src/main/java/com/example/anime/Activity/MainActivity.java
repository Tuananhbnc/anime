package com.example.anime.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anime.Adapter.MainViewPagerAdapter;
import com.example.anime.Fragment.Fragment_Share;
import com.example.anime.Fragment.Fragment_Home;
import com.example.anime.Fragment.Fragment_Personal;
import com.example.anime.Fragment.Fragment_Thongbao;
import com.example.anime.Model.Account;
import com.example.anime.Model.Token;
import com.example.anime.R;
import com.example.anime.Service.APIService;
import com.example.anime.Service.Dataservice;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    public static Token token;
    Account account_this;
    CircleImageView circleImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataIntent();
        anhxa();
        init();
        if(token != null && !token.getIdToken().equals("")){
            GetDataAccount(token.getIdToken());
        }
    }

    private void DataIntent() {
        Intent i = getIntent();
        if(i != null){
            if(i.hasExtra("token")){
                token = (Token) i.getSerializableExtra("token");
            }
        }
    }

    private void anhxa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
        toolbar = findViewById(R.id.toolbar_search);
        circleImageView = findViewById(R.id.logoAvatar);
    }

    private void init() {
        //actionBar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setLogo(R.drawable.icon_actionbar_user);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);

        //tablayout
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Personal(),"Cá Nhân");
        mainViewPagerAdapter.addFragment(new Fragment_Home(),"Home");
        mainViewPagerAdapter.addFragment(new Fragment_Share(),"Share");
        mainViewPagerAdapter.addFragment(new Fragment_Thongbao(),"Thông báo");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.avatar);
        tabLayout.getTabAt(1).setIcon(R.drawable.restart);
        tabLayout.getTabAt(2).setIcon(R.drawable.share);
        tabLayout.getTabAt(3).setIcon(R.drawable.notification);
        tabLayout.getTabAt(1).select();

        tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(android.R.color.holo_purple), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(3).getIcon().setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(android.R.color.holo_purple), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(android.R.color.black), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void GetDataAccount(String token){
        String authHeader = "Bearer " + token;

        Dataservice dataservice = APIService.getService();
        Call<Account> call = dataservice.Getaccount(authHeader);
        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                account_this = response.body();
                if(account_this != null && !account_this.getImageUrl().equals("")){
                    setValueInAvatar(account_this.getImageUrl());
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error Nhân Phẩm :)", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setValueInAvatar(String url_avatar){
        //try {
          //  URL url = new URL(url_avatar);
          //  Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
          //  BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(),bitmap);
              //actionBar
          //  toolbar.setLogo(bitmapDrawable);

        //} catch (MalformedURLException e) {
          //  e.printStackTrace();
        //} catch (IOException e) {
          //  e.printStackTrace();
        //}

        Picasso.with(this).load(url_avatar).into(circleImageView);

    }

    //ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.search:
                Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(this, "Setting button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "Logout button selected", Toast.LENGTH_SHORT).show();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }

//
}
