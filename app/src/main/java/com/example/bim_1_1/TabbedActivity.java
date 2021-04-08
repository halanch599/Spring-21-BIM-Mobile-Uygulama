package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.bim_1_1.model.VP2Adapter;
import com.google.android.material.tabs.TabLayout;

public class TabbedActivity extends AppCompatActivity {

    ViewPager2 vpMain;
    TabLayout tabLayoutMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        vpMain = findViewById(R.id.vpmain);
        tabLayoutMain = findViewById(R.id.tabLayout_main);

        VP2Adapter adapter = new VP2Adapter(this,tabLayoutMain.getTabCount());
        vpMain.setAdapter(adapter);

        tabLayoutMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpMain.setCurrentItem(tab.getPosition());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}