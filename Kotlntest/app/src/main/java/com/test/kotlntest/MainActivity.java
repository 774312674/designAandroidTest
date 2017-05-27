package com.test.kotlntest;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    TextInputLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_avigation_view_lyout);
        TextView tv= (TextView) findViewById(R.id.tv_text);
        tv.setText("2 + 5 = "+OneKt.sumtesto(2,5)+"  "+
                OneKt.sumtesto(2,5)+"+3="+OneKt.sumtextt(OneKt.sumtesto(2,5),3)+""+
                OneKt.sumstring(2,6)+" "+"大小: "+OneKt.maxInt(3,4)+"  "+
                OneKt.initdata()
        );




        EditText et= (EditText) findViewById(R.id.editText_et);
        tl= (TextInputLayout) findViewById(R.id.input_layout);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length()>3){
//                    tl.setErrorEnabled(true);
                    tl.setError("账号错误");
                }else{
                    tl.setError(null);
//                    tl.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        FloatingActionButton fb= (FloatingActionButton) findViewById(R.id.floatingActionButton);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(tl,"snackbar make ", Snackbar.LENGTH_LONG).setAction("显示", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"action onclick",Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });

//        ViewPager vp = (ViewPager) findViewById(R.id.view_pager);
        ViewPager vp = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(vp);


        NavigationView nv = (NavigationView) findViewById(R.id.nv_main_navigation);
        nv.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Log.i("ssss","ssss NavigationItem "+ item.getTitle());

        switch (item.getItemId()){
            case R.id.nav_home:
                startActivity(new Intent(this,MyCollapsingToolbarLayout.class));
                break;
        }

        return false;
    }



    private void setupViewPager(ViewPager vp){
        TabLayout tl= (TabLayout) findViewById(R.id.tl_tab_layout);
        List<String> titles = new ArrayList<>();
        titles.add("One");
        titles.add("Two");
        titles.add("Three");
        titles.add("four");
        titles.add("five");
        titles.add("six");
        titles.add("seve");
        tl.addTab(tl.newTab().setText(titles.get(0)));
        tl.addTab(tl.newTab().setText(titles.get(1)));
        tl.addTab(tl.newTab().setText(titles.get(2)));
        tl.addTab(tl.newTab().setText(titles.get(3)));
        tl.addTab(tl.newTab().setText(titles.get(4)));
        tl.addTab(tl.newTab().setText(titles.get(5)));
        tl.addTab(tl.newTab().setText(titles.get(6)));
        tl.setTabTextColors(ContextCompat.getColor(this, R.color.colorAccentA),ContextCompat.getColor(this, R.color.colorAccent));
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new MyFragment().setString(titles.get(0)));
        fragments.add(new MyFragment().setString(titles.get(1)));
        fragments.add(new MyFragment().setString(titles.get(2)));
        fragments.add(new MyFragment().setString(titles.get(3)));
        fragments.add(new MyFragment().setString(titles.get(4)));
        fragments.add(new MyFragment().setString(titles.get(5)));
        fragments.add(new MyFragment().setString(titles.get(6)));
        FragmentAdapter adapter =
                new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);





    }



}
