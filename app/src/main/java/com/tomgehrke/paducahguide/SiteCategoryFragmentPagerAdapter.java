package com.tomgehrke.paducahguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SiteCategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;
    private Context mContext;

    public SiteCategoryFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LocalColorFragment();
            case 1:
                return new DiningFragment();
            case 2:
                return new EntertainmentFragment();
            default:
                return new ParksFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab1_name);
            case 1:
                return mContext.getString(R.string.tab2_name);
            case 2:
                return mContext.getString(R.string.tab3_name);
            default:
                return mContext.getString(R.string.tab4_name);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}
