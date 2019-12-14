package com.example.imagepatternusingrecyclerview.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagepatternusingrecyclerview.R;
import com.example.imagepatternusingrecyclerview.model.ImagePatternModel;


import java.util.ArrayList;

public class ImagePatternAdapter extends RecyclerView.Adapter<ImagePatternAdapter.ViewHolder>{
    ArrayList<ImagePatternModel> myImageList;
    Context ctx;
    public ImagePatternAdapter(Context ctx, ArrayList<ImagePatternModel> myImageList) {
        this.ctx = ctx;
        this.myImageList = myImageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v1= LayoutInflater.from(ctx).inflate(R.layout.raw_image_pattern, parent, false);
        return new ViewHolder(v1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        for (int i =0; i<myImageList.get(position).getNo().size(); i++){
            Log.d("i", String.valueOf(i));
            Log.d("position", String.valueOf(position));
            ImageView imageView = new ImageView(ctx);
            String imagename = myImageList.get(position).getNo().get(i);
            Log.d("imagename",imagename);
            int res = ctx.getResources().getIdentifier(imagename, "drawable", ctx.getPackageName());
            imageView.setImageResource(res);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
            imageView.setMaxHeight(20);
            imageView.setMaxWidth(20);
            holder.imageLayout.addView(imageView);
        }
    }

    @Override
    public int getItemCount()  {
        return myImageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout imageLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLayout = itemView.findViewById(R.id.imageLayout);
        }
    }
}
