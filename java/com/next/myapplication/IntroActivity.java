package com.next.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.next.myapplication.adapter.ViewAdapter;

public class IntroActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewAdapter viewAdapter;

    MaterialButton btnIgnore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        viewPager=findViewById(R.id.view_pager);
        viewAdapter=new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);

        //ignore
        btnIgnore=findViewById(R.id.btnIgnore);
        btnIgnore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
              startActivity(new Intent(getBaseContext(),SignUpActivity.class));

            }
        });
    }
}