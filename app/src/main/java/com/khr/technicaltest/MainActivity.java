package com.khr.technicaltest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.material.snackbar.Snackbar;

import com.google.android.material.navigation.NavigationView;
import com.khr.technicaltest.adapter.PayAdapter;
import com.khr.technicaltest.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;


    private RecyclerView recyclerView;
    private ArrayList<PayHistory> payArray;
    private PayAdapter payAdapter;
    private static final int VERTICAL_ITEM_SPACE = 28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar myActionbar = getSupportActionBar();
        myActionbar.setDisplayHomeAsUpEnabled(true);

        InitializeCardView();
    }

    private void InitializeCardView() {

        recyclerView = findViewById(R.id.recycleviewCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        payArray = PrefConfig.readListFromPref(this);
        if (payArray == null) {
            payArray = new ArrayList<>();
        }

        payAdapter = new PayAdapter(getApplicationContext(), payArray);
        recyclerView.setAdapter(payAdapter);

        recyclerView.addItemDecoration(new SpacingItemDecoration(VERTICAL_ITEM_SPACE));

        CreateDataForCard();
    }
    private void CreateDataForCard(){
        PayHistory payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);

        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);
        payHistory = new PayHistory("30 Oct 2021");
        payArray.add(payHistory);

    }

}