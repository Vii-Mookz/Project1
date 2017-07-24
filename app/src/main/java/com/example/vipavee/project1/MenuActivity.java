package com.example.vipavee.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MenuActivity extends AppCompatActivity {
    private ListView ListViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ListViewData = (ListView) findViewById(R.id.list_menu);

        final int[] intsPic = new int[]{
                R.drawable.cars_3,
                R.drawable.boderland,
                R.drawable.crew,
                R.drawable.dragonball,
                R.drawable.overcook,
                R.drawable.farcry,
                R.drawable.assasin

        };

        final String[] stringName = getResources().getStringArray(R.array.data_main); //เรียกข้อมูลชื่อ bakery array
        final String[] stringsDetail = getResources().getStringArray(R.array.data_detail);
        final String[] stringsPrice = getResources().getStringArray(R.array.data_price);

        MainAdapter mainAdapter = new MainAdapter(this,intsPic,stringName,stringsDetail);
        ListViewData.setAdapter(mainAdapter);

        ListViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuActivity.this , DetailActivity.class);
                intent.putExtra("Name", stringName[position]);
                intent.putExtra("Description", stringsDetail[position]);
                intent.putExtra("Pic", intsPic[position]);
                intent.putExtra("Price", stringsPrice[position]);
                intent.putExtra("index", position);

                startActivity(intent);
            }
        });
    }
}
