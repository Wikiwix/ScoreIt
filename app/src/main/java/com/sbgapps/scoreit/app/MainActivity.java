package com.sbgapps.scoreit.app;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;

import com.sbgapps.scoreit.app.base.BaseActivity;
import com.sbgapps.scoreit.app.header.HeaderFragment;
import com.sbgapps.scoreit.core.model.utils.ActivityUtils;
import com.sbgapps.scoreit.core.model.utils.GameHelper;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isFirstRun(savedInstanceState)) {
            GameHelper.init(this);

            FragmentManager fragmentManager = getSupportFragmentManager();
            ActivityUtils.replaceFragmentToActivity(fragmentManager,
                    HeaderFragment.newInstance(), R.id.header_container);
        } else {

        }
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
