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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Stéphane on 28/07/2014.
 */
public class ScoreFragment extends Fragment {

    public static final String TAG = ScoreFragment.class.getName();

    private ScoreListFragment mScoreListFragment;
    private ScoreGraphFragment mScoreGraphFragment;
    private HeaderFragment mHeaderFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, null);

        mHeaderFragment = new HeaderFragment();
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.header_container, mHeaderFragment)
                .commit();

        mScoreListFragment = new ScoreListFragment();
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.score_container, mScoreListFragment)
                .commit();

        return view;
    }

    public ScoreListFragment getScoreListFragment() {
        return mScoreListFragment;
    }

    public ScoreGraphFragment getScoreGraphFragment() {
        return mScoreGraphFragment;
    }

    public HeaderFragment getHeaderFragment() {
        return mHeaderFragment;
    }

    public void loadFragments() {
        mHeaderFragment = new HeaderFragment();
        mScoreListFragment = new ScoreListFragment();

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        ft.replace(R.id.header_container, mHeaderFragment, HeaderFragment.TAG)
                .commit();

        ft = getChildFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_down, R.anim.slide_out_up);
        ft.replace(R.id.score_container, mScoreListFragment, ScoreListFragment.TAG)
                .commit();
    }


    public void switchScoreViews() {
        if (null != mScoreGraphFragment && mScoreGraphFragment.isVisible()) {
            getChildFragmentManager().popBackStack();
            return;
        }

        if (null == mScoreGraphFragment)
            mScoreGraphFragment = new ScoreGraphFragment();

        getChildFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in_down,
                        R.anim.slide_out_up,
                        R.anim.slide_in_up,
                        R.anim.slide_out_down)
                .addToBackStack(null)
                .replace(R.id.score_container, mScoreGraphFragment, ScoreGraphFragment.TAG)
                .commit();
    }

    public void update() {
        if (null != mHeaderFragment)
            mHeaderFragment.update();
        if (null != mScoreListFragment && mScoreListFragment.isVisible())
            mScoreListFragment.update();
        if (null != mScoreGraphFragment && mScoreGraphFragment.isVisible())
            mScoreGraphFragment.update();
    }

    public void closeOpenedItems() {
        if (null != mScoreListFragment)
            mScoreListFragment.closeOpenedItems();
    }
}
