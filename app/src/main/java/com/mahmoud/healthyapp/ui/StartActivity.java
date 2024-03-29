package com.mahmoud.healthyapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mahmoud.healthyapp.R;

import io.paperdb.Paper;

public class StartActivity extends AppCompatActivity {

    Button but_en,but_ar;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttech(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        but_ar=findViewById(R.id.but_ar);
        but_en=findViewById(R.id.but_en);

        Paper.init(this);

        but_en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().write("language","en");
                Context context=LocaleHelper.setLocale(StartActivity.this,"en");
                Resources resources=context.getResources();
                startActivity(new Intent(StartActivity.this,MainActivity.class));
            }
        });
        but_ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paper.book().write("language","ar");
                Context context=LocaleHelper.setLocale(StartActivity.this,"ar");
                Resources resources=context.getResources();
                startActivity(new Intent(StartActivity.this,MainActivity.class));
            }
        });
    }
}
