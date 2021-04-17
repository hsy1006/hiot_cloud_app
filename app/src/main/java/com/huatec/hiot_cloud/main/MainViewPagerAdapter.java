package com.huatec.hiot_cloud.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.huatec.hiot_cloud.utils.Constans;

/**
 * viewpager适配器
 */
class MainViewPagerAdapter extends FragmentPagerAdapter {

    public MainViewPagerAdapter() {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case Constans.MAIN_VIEWPAGER_INDEX_MESSAGE:
                //创建message的fragment todo
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_EQUIPMENT:
                //创建equipment的fragment
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_SCENE:
                //创建scene的fragment
                break;
            case Constans.MAIN_VIEWPAGER_INDEX_MINE:
                //创建mine的fragment
                break;
            default:
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Constans.MAIN_FRAGMENT_COUNT;
    }
}
