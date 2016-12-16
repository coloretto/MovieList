package com.neiliner.mymovie.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * Created by vam on 2016/12/13.
 */

public class BaseActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void showToast(String str){
        Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
    }
}
