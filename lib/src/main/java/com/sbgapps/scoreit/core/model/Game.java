/*
 * Copyright (c) 2016 SBG Apps
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

package com.sbgapps.scoreit.core.model;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbaiget on 26/06/2014.
 */
public class Game<T extends Lap> {

    public static final int UNIVERSAL = 0;
    public static final int TAROT = 1;
    public static final int BELOTE = 2;
    public static final int COINCHE = 3;

    private final ArrayList<T> mLaps;
    private final ArrayList<Player> mPlayers;

    public Game(ArrayList<Player> players, ArrayList<T> laps) {
        mPlayers = players;
        mLaps = laps;
        initScores();
    }

    public List<T> getLaps() {
        return mLaps;
    }

    public List<Player> getPlayers() {
        return mPlayers;
    }

    private void initScores() {
        for (Lap lap : mLaps) lap.computeScores();
    }

    @IntDef({UNIVERSAL, TAROT, BELOTE, COINCHE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Games {
    }
}
