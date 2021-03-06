package com.example.ourvedic.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.ourvedic.ListAdapter;
import com.example.ourvedic.R;
import com.example.ourvedic.ViewPagerAdapter;
import com.example.ourvedic.item;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {


    LinearLayout SliderDots;
    private int dotscount;
    private ImageView dots[];
    ViewPager viewPager;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        ArrayList<item> items = new ArrayList<>();
        items.add(new item(101, "Agarbatti", "Incense stick",R.drawable.h101));
        items.add(new item(102, "Ghee", "Ghee",R.drawable.h102));
        items.add(new item(103, "Kumkuma", "Kumkuma",R.drawable.h103));
        items.add(new item(104, "phool", "Flowers",R.drawable.h104));
        items.add(new item(105, "Rudraksha", "Rudraksha",R.drawable.h105));
        items.add(new item(106, "chandan", "Sandalwood",R.drawable.h106));
        items.add(new item(107, "Sindoor", "Vermilion red",R.drawable.h107));
        items.add(new item(108, "Tulasi", "Tulasi",R.drawable.h108));
        items.add(new item(109, "haldee", "Turmeric",R.drawable.h109));
        items.add(new item(110, "Vibhuti", "Vibhuti",R.drawable.h110));
        items.add(new item(111, "Panchagavya", "Panchagavya ",R.drawable.h111));
        items.add(new item(112, "Dhaga", "Red Thread",R.drawable.h112));
        items.add(new item(113, "cheenee", "Sugar",R.drawable.h113));
        items.add(new item(114, "Prasad", "Prasad",R.drawable.h114));

        ListAdapter itemsAdapter = new ListAdapter(getActivity(), items);
        ListView listView = root.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);


        viewPager = root.findViewById(R.id.viewPager);
        SliderDots = root.findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];
        for(int i = 0; i < dotscount; i++){
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.non_active_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            SliderDots.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i < dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new myTimeTask(), 2000,4000);

        return root;
    }

    public class myTimeTask extends TimerTask{

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }
                    else if (viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }
                    else if (viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }
                    else if (viewPager.getCurrentItem()==3){
                        viewPager.setCurrentItem(4);
                    }
                    else if (viewPager.getCurrentItem()==4){
                        viewPager.setCurrentItem(5);
                    }
                    else if (viewPager.getCurrentItem()==5){
                        viewPager.setCurrentItem(6);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }


}