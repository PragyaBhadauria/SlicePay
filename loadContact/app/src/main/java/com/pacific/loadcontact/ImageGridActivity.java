package com.pacific.loadcontact;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import java.util.ArrayList;

public class ImageGridActivity extends AppCompatActivity {GridView simpleList;
    ArrayList flowerList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        simpleList = (GridView) findViewById(R.id.simpleGridView);
        flowerList.add(new Item("Flower 1",R.drawable.flower1));
        flowerList.add(new Item("Flower 2",R.drawable.flower2));
        flowerList.add(new Item("Flower 3",R.drawable.flower3));
        flowerList.add(new Item("Flower 4",R.drawable.flower4));
        flowerList.add(new Item("Flower 5",R.drawable.flower5));
        flowerList.add(new Item("Flower 6",R.drawable.flower6));
        flowerList.add(new Item("Flower 7",R.drawable.flower7));
        flowerList.add(new Item("Flower 8",R.drawable.flower8));
        flowerList.add(new Item("Flower 9",R.drawable.flower9));
        flowerList.add(new Item("Flower 10",R.drawable.flower10));
        flowerList.add(new Item("Flower 11",R.drawable.flower11));
        flowerList.add(new Item("Flower 12",R.drawable.flower12));
        flowerList.add(new Item("Flower 13",R.drawable.flower13));
        flowerList.add(new Item("Flower 14",R.drawable.flower14));
        flowerList.add(new Item("Flower 15",R.drawable.flower15));
        flowerList.add(new Item("Flower 16",R.drawable.flower16));
        flowerList.add(new Item("Flower 17",R.drawable.flower17));
        flowerList.add(new Item("Flower 18",R.drawable.flower18));
        flowerList.add(new Item("Flower 19",R.drawable.flower19));
        flowerList.add(new Item("Flower 20",R.drawable.flower20));

        MyAdapter myAdapter=new MyAdapter(this,R.layout.grid_view_items,flowerList);
        simpleList.setAdapter(myAdapter);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.d("PVN", "--------------> onConfigCHange");
        super.onConfigurationChanged(newConfig);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            simpleList.setNumColumns(3);
        } else {
            simpleList.setNumColumns(2);
        }
    }
}
