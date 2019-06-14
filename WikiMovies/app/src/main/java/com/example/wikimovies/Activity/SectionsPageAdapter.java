package com.example.wikimovies.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTittleList= new ArrayList<>();
    private FragmentManager fm;

    public FragmentManager getFm() {
        return fm;
    }

    public void setFm(FragmentManager fm) {
        this.fm = fm;
    }

    public void addFragment(Fragment fragment, String title){
        mFragmentTittleList.add(title);
        mFragmentList.add(fragment);
    }
    public SectionsPageAdapter(FragmentManager fm){
        super(fm);
        this.fm=fm;
    }
    public void clearAll(){
        for(int i=0;i<mFragmentList.size();i++){
            fm.beginTransaction().remove(mFragmentList.get(1)).commit();
            mFragmentList.clear();
            mFragmentList= new ArrayList<Fragment>();
            notifyDataSetChanged();
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mFragmentTittleList.get(position);
    }
    @Override
    public Fragment getItem(int position){
        return mFragmentList.get(position);
    }
    public void setItem(Fragment f ,int position){
         mFragmentList.set(position,f);
    }
    @Override
    public int getCount(){
        return mFragmentList.size();
    }
}
