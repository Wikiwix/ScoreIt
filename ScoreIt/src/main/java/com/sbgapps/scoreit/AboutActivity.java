/*
 * Copyright (c) 2014 SBG Apps
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sbgapps.scoreit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;

import com.astuetz.PagerSlidingTabStrip;
import com.sbgapps.scoreit.fragment.DonateFragment;
import com.sbgapps.scoreit.fragment.InfoFragment;
import com.sbgapps.scoreit.fragment.TranslationsFragment;

import java.util.Locale;

public class AboutActivity extends BaseActivity {

    private DonateFragment mDonateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SectionsPagerAdapter sectionsPagerAdapter
                = new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(sectionsPagerAdapter);

        PagerSlidingTabStrip slidingTabLayout = (PagerSlidingTabStrip) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setViewPager(viewPager);

        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setTitle(getString(R.string.about));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_about;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!mDonateFragment.getBillingProcessor().handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = Fragment.instantiate(AboutActivity.this,
                            InfoFragment.class.getName());
                    break;
                case 1:
                    mDonateFragment = (DonateFragment) Fragment.instantiate(AboutActivity.this,
                            DonateFragment.class.getName());
                    fragment = mDonateFragment;
                    break;
                case 2:
                    fragment = Fragment.instantiate(AboutActivity.this,
                            TranslationsFragment.class.getName());
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.application).toUpperCase(l);
                case 1:
                    return getString(R.string.donate).toUpperCase(l);
                case 2:
                    return getString(R.string.translations).toUpperCase(l);
            }
            return null;
        }
    }
}
