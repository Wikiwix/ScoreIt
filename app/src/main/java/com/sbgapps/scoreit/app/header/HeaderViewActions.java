package com.sbgapps.scoreit.app.header;

import android.support.annotation.ColorInt;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.sbgapps.scoreit.core.model.Player;

/**
 * Created by sbaiget on 21/12/2016.
 */

public interface HeaderViewActions extends MvpView {

    void setName(@Player.Players int player, String name);

    void setScore(@Player.Players int player, int score);

    void setColor(@Player.Players int player, @ColorInt int color);
}
