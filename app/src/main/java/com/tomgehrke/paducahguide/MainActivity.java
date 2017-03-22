package com.tomgehrke.paducahguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe site category fragments
        ViewPager mainViewPager = (ViewPager) findViewById(R.id.main_viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SiteCategoryFragmentPagerAdapter siteCategoryFragmentPagerAdapter = new SiteCategoryFragmentPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        mainViewPager.setAdapter(siteCategoryFragmentPagerAdapter);

        // Handle TabLayout
        TabLayout categoryTabLayout = (TabLayout) findViewById(R.id.site_category_tablayout);
        categoryTabLayout.setupWithViewPager(mainViewPager);
    }
}
