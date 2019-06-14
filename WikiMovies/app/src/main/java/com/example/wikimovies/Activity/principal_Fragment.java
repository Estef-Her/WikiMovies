package com.example.wikimovies.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wikimovies.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class principal_Fragment extends Fragment {
    CarouselView carouselView;

    int[] sampleImages = {R.drawable.poster1, R.drawable.poster2, R.drawable.poster3};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        final View root =inflater.inflate(R.layout.fragment_principal, container, false);

        carouselView = (CarouselView) root.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {

            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

            }
        });
    return root;}
}
