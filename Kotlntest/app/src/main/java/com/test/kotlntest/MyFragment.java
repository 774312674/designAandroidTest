package com.test.kotlntest;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/25.
 */

public class MyFragment extends Fragment{

    private RecyclerView rv;
    private List<String> list;
    private String string;


    public String getString() {
        return string;
    }

    public MyFragment setString(String string) {
        this.string = string;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rv = (RecyclerView) inflater.inflate(R.layout.my_fragment_layout,container,false).findViewById(R.id.recycler_view);
        if (list == null)
            list = new ArrayList<String>();
        for (int a= 0 ; a<5;a++)
            list.add(string+ "  "+a);

        rv.setLayoutManager(new LinearLayoutManager(rv.getContext(),LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new RvAdapter(getActivity(),list));

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.i("ssss","ssss onScrolled dy = "+dy);
            }
        });


        return rv;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
