package com.test.kotlntest;


import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin on 2017/5/25.
 */
class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{

    private Context mContext;
    private List<String> list;


    public RvAdapter(Context context,List<String> list){
        this.mContext = context;
        this.list = list;
    }

    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v =LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_adapter_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RvAdapter.ViewHolder holder, final int position) {
        final View v=holder.mView;
        final TextView tv=holder.tv;
        tv.setText(list.get(position));
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,tv.getText(),Snackbar.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        public TextView tv;
        public ViewHolder(View view) {
            super(view);
            mView = view;
            tv  = (TextView) view.findViewById(R.id.textView);
        }
    }


}
