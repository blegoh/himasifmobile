package com.example.brianr.himasifmobile;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.viewContainer);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new HimasifToday1Fragment(),"Info Himasif");
        adapter.addFragment(new HimasifToday2Fragment(),"Artikel");
        adapter.addFragment(new HimasifToday3Fragment(),"Info Lowongan");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentsList = new ArrayList<>();
        private final List<String>mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentsList.size();
        }
        public void addFragment(Fragment fragment,String title){
            mFragmentsList.add(fragment);
            mFragmentTitleList.add(title);
        }
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

}
