package com.example.th1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MyGirdView extends Activity {
    GridView simpleGrid;
    int logos[] = {R.drawable.vietnam, R.drawable.china, R.drawable.malaysia, R.drawable.france,
            R.drawable.japan, R.drawable.korea, R.drawable.chile, R.drawable.japan, R.drawable.france,
            R.drawable.china, R.drawable.brazil, R.drawable.china, R.drawable.vietnam};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_girdview);
        simpleGrid = (GridView) findViewById(R.id.simpleGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapterGird customAdapter = new CustomAdapterGird(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        simpleGrid.setOnItemClickListener(new OnItemClickListener() {
            @Override
             public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            // TODO Auto-generated method stub
            // set an Intent to Another Activity
            Intent intent = new Intent(MyGirdView.this, ActivitySecond.class);
            intent.putExtra("image", logos[arg2]); // put image data in Intent
            startActivity(intent); // start Intent
        }
        });
    }
}
