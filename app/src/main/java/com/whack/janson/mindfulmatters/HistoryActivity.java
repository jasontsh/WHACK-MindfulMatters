package com.whack.janson.mindfulmatters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HistoryActivity extends AppCompatActivity {

    private final String[] titles = new String[]{"Mood", "Sleep", "Activity", "Nutrition"};

    protected class TabAdapter extends FragmentStatePagerAdapter {
        HistoryFragment[] fragments;

        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragments = new HistoryFragment[4];
            for (int i = 0; i < titles.length; i++) {
                HistoryFragment frag = new HistoryFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", titles[i]);
                frag.setArguments(bundle);
                fragments[i] = frag;
            }
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return titles.length;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.history_vp);

        final ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };
        for (int i = 0; i < titles.length; i++) {
            actionBar.addTab(
                    actionBar.newTab()
                        .setText(titles[i])
                        .setTabListener(tabListener)
            );
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
