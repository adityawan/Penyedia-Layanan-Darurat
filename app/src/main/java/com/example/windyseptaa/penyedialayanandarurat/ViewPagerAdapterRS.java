package com.example.windyseptaa.penyedialayanandarurat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapterRS extends FragmentStatePagerAdapter {

    private static int TAB_COUNT = 2;

    public ViewPagerAdapterRS(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return RumahSakitFragment.newInstance();
            case 1:
                return PuskesmasFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return RumahSakitFragment.TITLE;

            case 1:
                return PuskesmasFragment.TITLE;
        }
        return super.getPageTitle(position);
    }

}
