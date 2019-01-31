package com.example.android.magazines;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ShortSotriesActivity extends AppCompatActivity {

    private static final String TAG = "ShortSotriesActivity";
    private Context mContext;

    ArrayList<String> titleArrayList;
    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_short_sotries);

        mContext  =  ShortSotriesActivity.this;
        titleArrayList = new ArrayList <String>();

        titleArrayList.add(Constants.Jodi_Tor_Dak_Shune);
        titleArrayList.add(Constants.Amaro_Porano_Jaha_Chay);
        titleArrayList.add(Constants.Gramchara_oi_ranga_matir_poth);
        titleArrayList.add(Constants.Megher_Kole_Rod_Heseche);

        mRecycleView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Intent desIntent = new Intent(mContext, DescriptionActivity.class);
                desIntent.putExtra("titles", titleArrayList.get(position));
                startActivity(desIntent);


            }
        });

        mRecycleView.setAdapter(adapter);

    }
}
