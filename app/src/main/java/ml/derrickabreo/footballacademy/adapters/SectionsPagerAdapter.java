package ml.derrickabreo.footballacademy.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ml.derrickabreo.footballacademy.fragments.tabbed.FinishedTabbedFragment;
import ml.derrickabreo.footballacademy.fragments.tabbed.TodayTabbedFragment;
import ml.derrickabreo.footballacademy.fragments.tabbed.UpcomingTabbedFragment;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new TodayTabbedFragment();

            case 1:
                return new UpcomingTabbedFragment();

            case 2:
                return new FinishedTabbedFragment();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        /*it will return values in tabbed layout*/
        switch (position) {
            case 0: return "Today";
            case 1: return "Upcoming";
            case 2: return "Finished";
        }
        return null;
    }
}
