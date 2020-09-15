package com.ssoftwares.easyfix.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.ssoftwares.easyfix.R;
import com.ssoftwares.easyfix.models.MainBannerModel;

import java.util.ArrayList;

public class MainBannerAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<MainBannerModel> bannersArrayList;

    public MainBannerAdapter(Context context, ArrayList<MainBannerModel> bannersArrayList) {
        this.context = context;
        this.bannersArrayList = bannersArrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return bannersArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.layout_mainbanner, container, false);
//            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.mainbanner_Image);
        imageView.setImageResource(R.drawable.banner_demo);
        imageView.setImageResource(bannersArrayList.get(position).getImageUrl());

        Log.d("CustomPagerAdapter", "instantiateItem: ");
//        Glide.with(context)
//                .asBitmap().
//                load(Constant.IMG_BASE_URL + "/" + bannersArrayList.get(position)
//                        .getUrl())
//                .placeholder(R.drawable.banner_demo).into(imageView);
//        container.addView(itemView);
//        //listening to image click
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Preferences preferences = new Preferences(context);
//                preferences.setProductDetails(bannersArrayList.get(position).getProduct());
//                if (bannersArrayList.get(position).getIs_active()) {
//                    Intent intent = new Intent(context, ProductDetailsActivity.class);
//                    intent.putExtra("Flash_Sale", "active");
//                    intent.putExtra("id", bannersArrayList.get(position).getId());
//                    context.startActivity(intent);
//                } else {
//                    Intent intent = new Intent(context, ProductDetailsActivity.class);
//                    intent.putExtra("Flash_Sale", "inactive");
//                    intent.putExtra("id", bannersArrayList.get(position).getId());
//                    context.startActivity(intent);
//                }
//
//
//            }
//        });
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
