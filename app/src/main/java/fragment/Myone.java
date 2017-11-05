package fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import test.bwie.com.myonedemo2.R;


public class Myone extends Fragment {

    String[] strings = new String[]{"陆生","板块","指数","更多"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_myone, container, false);
        InitView(v);
        return v;
    }

    private void InitView(View v) {
         tabLayout = v.findViewById(R.id.tab_item_iv);
          viewPager = v.findViewById(R.id.vp);
    //    Arrays.asList(strings).forEach(x -> tabLayout.addTab(tabLayout.newTab().setText(strings[Integer.parseInt(x)])));

        for(int  i=0 ; i < strings.length; i++){
            tabLayout.addTab(tabLayout.newTab().setText(strings[i]));
        }

        viewPager.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment w = null;
                switch (strings[position]){
                    case "陆生":
                        w = new MyTwo();
                        break;
                    case "板块":
                        w = new MyTwo();
                        break;
                    case "指数":
                        w = new MyTwo();
                        break;
                    case "更多":
                        w = new MyTwo();
                        break;
                }
                return w;
            }

            @Override
            public int getCount() {
                return strings.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return strings[position];
            }
        });



        tabLayout.setupWithViewPager(viewPager);
    }

}
