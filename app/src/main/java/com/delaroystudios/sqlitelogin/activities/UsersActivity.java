package com.delaroystudios.sqlitelogin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.delaroystudios.sqlitelogin.R;

/**
 * Created by delaroy on 3/27/17.
 */
public class UsersActivity extends AppCompatActivity {

    Button button2, button4;
    public void init() {

        button2 = (Button) findViewById(R.id.button2);
        button4 = (Button) findViewById(R.id.button4);

        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View view)
            {
                Intent i = new Intent(getApplicationContext(), PictureActivity.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v)
            {
                Intent b = new Intent(UsersActivity.this, PictureList.class);
                startActivity(b);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        init();
    }
}
