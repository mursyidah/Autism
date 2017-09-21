package com.delaroystudios.sqlitelogin.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import com.delaroystudios.sqlitelogin.R;
import com.delaroystudios.sqlitelogin.helper.PictureAdapter;
import com.delaroystudios.sqlitelogin.model.UserPicture;

import java.util.ArrayList;

/**
 * Created by mursyidah on 20/09/2017.
 */

public class PictureList extends AppCompatActivity {

    ListView listView;
    GridView gridView;
    ArrayList<UserPicture> list;
    PictureAdapter adapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_list_activity);

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new PictureAdapter(this, R.layout.picture_item, list);
        listView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = PictureActivity.sqLiteHelper.getData("SELECT * FROM FOOD");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new UserPicture(name, price, image, id));
        }
        adapter.notifyDataSetChanged();
    }


}