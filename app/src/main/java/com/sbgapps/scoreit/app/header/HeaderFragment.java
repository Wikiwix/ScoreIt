package com.sbgapps.scoreit.app.header;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

import com.sbgapps.scoreit.app.base.BaseFragment;
import com.sbgapps.scoreit.core.model.Player;

/**
 * Created by sbaiget on 21/12/2016.
 */

public class HeaderFragment extends BaseFragment<HeaderViewActions, HeaderPresenter>
        implements HeaderViewActions {

    public static HeaderFragment newInstance() {
        Bundle args = new Bundle();
        HeaderFragment fragment = new HeaderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResource() {
        return 0;
    }

    @Override
    @NonNull
    public HeaderPresenter createPresenter() {
        return new HeaderPresenter();
    }

    @Override
    public void setName(@Player.Players int player, String name) {

    }

    @Override
    public void setScore(@Player.Players int player, int score) {

    }

    @Override
    public void setColor(@Player.Players int player, @ColorInt int color) {

    }
}
