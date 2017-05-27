package com.test.kotlntest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/26.
 */

public class MyCollapsingToolbarLayout extends AppCompatActivity{
    FloatingActionButton fb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_coordinator_layout_activity);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        List<String> list = new ArrayList<String>();
        for (int a= 0 ; a<50;a++)
            list.add("  "+a);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new RvAdapter(this,list));
        fb = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        rv.addOnScrollListener(sl);

        NestedScrollView nsv = (NestedScrollView) findViewById(R.id.nestedScrollView);
        nsv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Log.i("ssss","ssss scrollY = "+ scrollY +" oldScrollY = "+oldScrollY);
                boolean b=oldScrollY>scrollY;
                if (b){
                    fb.show();
                }else{
                    fb.hide();
                }
            }
        });

    }

    RecyclerView.OnScrollListener sl = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
//            Log.i("ssss","ssss onScrollStateChanged "+newState);
        }
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Log.i("ssss","ssss onScrolled dy = "+dy +" dx = "+dx);


            super.onScrolled(recyclerView, dx, dy);
        }
    };


}
