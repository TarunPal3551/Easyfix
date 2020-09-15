package com.ssoftwares.easyfix.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssoftwares.easyfix.R;
import com.ssoftwares.easyfix.adapters.MainBannerAdapter;
import com.ssoftwares.easyfix.models.MainBannerModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ViewPager viewPagerMainBanner;
    ArrayList<MainBannerModel> mainBannerModelArrayList = new ArrayList<>();
    MainBannerAdapter mainBannerAdapter;
    int pageBanner = 0;
    Context mContext;

    Timer mainBannerTimer;
    int delay = 5000, period = 5000;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        viewPagerMainBanner = (ViewPager) view.findViewById(R.id.mainViewpager);
        mContext = requireContext();
        setUpMainBanner();

        return view;

    }

    public void setUpMainBanner() {
        mainBannerModelArrayList = new ArrayList<>();
        mainBannerModelArrayList.add(new MainBannerModel(R.drawable.banner_demo));
        mainBannerModelArrayList.add(new MainBannerModel(R.drawable.banner_demo_2));
        mainBannerAdapter = new MainBannerAdapter(mContext, mainBannerModelArrayList);
        viewPagerMainBanner.setAdapter(mainBannerAdapter);
        mainBannerTimer = new Timer();
        mainBannerTimer.schedule(new MyTimerTaskBanner(), delay, period);

    }

    public class MyTimerTaskBanner extends TimerTask {
        int position = viewPagerMainBanner.getCurrentItem();

        @Override
        public void run() {
            if (getActivity() != null) {
                getActivity().runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                if (position >= pageBanner) {
                                    position = 0;
                                } else {
                                    position = position + 1;
                                }
                                //Toast.makeText(MainActivity.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
                                viewPagerMainBanner.setCurrentItem(position, true);

                            }
                        }
                );
            }
        }
    }
}