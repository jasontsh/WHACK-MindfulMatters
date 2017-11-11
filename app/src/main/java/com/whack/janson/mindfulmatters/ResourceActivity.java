package com.whack.janson.mindfulmatters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by MLH-Admin on 11/11/2017.
 */

public class ResourceActivity extends AppCompatActivity {

    protected class TabAdapter extends FragmentStatePagerAdapter {
        ResourceFragment[] fragments;
        public TabAdapter(FragmentManager fm) {
            super(fm);
            fragments = new ResourceFragment[2];

            ResourceFragment frag = new ResourceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("number", 0);
            frag.setArguments(bundle);
            fragments[0] = frag;

            ResourceFragment frag2 = new ResourceFragment();
            Bundle bundle2 = new Bundle();
            bundle.putInt("number", 1);
            frag2.setArguments(bundle2);
            fragments[1] = frag2;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.history_vp);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager()));

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
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Lifestyle")
                        .setTabListener(tabListener)
        );
        actionBar.addTab(
                actionBar.newTab()
                        .setText("Online Resources")
                        .setTabListener(tabListener)
        );

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
