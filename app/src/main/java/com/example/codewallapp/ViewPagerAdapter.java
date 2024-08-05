package com.example.codewallapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int image[]={
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider3
    };


    int headings []={
            R.string.boarding_firstHeader,
            R.string.boarding_secHeader,
            R.string.boarding_thirdHeader
    };
    int description[]={
            R.string.boarding_first_txt,
            R.string.boarding_sec_txt,
            R.string.boarding_third_txt
    };


    public ViewPagerAdapter (Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view=layoutInflater.inflate(R.layout.slider_layout,container,false);


        ImageView slideImageView=(ImageView) view.findViewById(R.id.boarding_img);
        TextView slideHeader=(TextView) view.findViewById(R.id.header_txt);
        TextView slideDescription=(TextView) view.findViewById(R.id.description);


        slideImageView.setImageResource(image[position]);
        slideHeader.setText(headings[position]);
        slideDescription.setText(description[position]);


        container.addView(view);



        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout) object);

    }
}
