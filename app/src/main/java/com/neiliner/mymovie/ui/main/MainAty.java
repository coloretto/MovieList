package com.neiliner.mymovie.ui.main;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.neiliner.mymovie.R;
import com.neiliner.mymovie.base.BaseActivity;
import com.neiliner.mymovie.ui.discover.SearchFragment;
import com.neiliner.mymovie.ui.mine.MineFragment;
import com.neiliner.mymovie.ui.user.UserFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vam on 2016/11/21.
 */
public class MainAty extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    @BindView(R.id.layout_frame)
    FrameLayout frameLayout;
    @BindView(R.id.rg_tab)
    RadioGroup radioGroup;

    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    List<Fragment> fragmentList;


    int tabId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        ButterKnife.bind(this);


        initFragments();

        radioGroup.setOnCheckedChangeListener(this);
    }


    public void initFragments(){
        fragmentManager = getSupportFragmentManager();

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new SearchFragment());
        fragmentList.add(new MineFragment());
        fragmentList.add(new UserFragment());

        transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.layout_frame, fragmentList.get(0));
        transaction.commit();
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        transaction = fragmentManager.beginTransaction();

        for(int i = 0 ;i < radioGroup.getChildCount(); i++){

            if(radioGroup.getChildAt(i).getId() == checkedId){  // 得到点击的按钮的index

                Fragment toFragment = fragmentList.get(i);    // 将要去的fragment
                Fragment fromFragment = fragmentList.get(tabId);  // 当前的fragment

                transaction.hide(fromFragment); // 隐藏当前的

                if(toFragment.isAdded()){
                    transaction.show(toFragment);
                }else {
                    transaction.add(R.id.layout_frame, toFragment);
                }
                tabId = i;
            }
        }
        transaction.commit();
    }


}
