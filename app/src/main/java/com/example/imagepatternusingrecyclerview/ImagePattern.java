package com.example.imagepatternusingrecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagepatternusingrecyclerview.adapter.ImagePatternAdapter;
import com.example.imagepatternusingrecyclerview.model.ImagePatternModel;

import java.util.ArrayList;

public class ImagePattern extends AppCompatActivity {
    RecyclerView rvitempattern;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ImagePatternModel> myImageList = new ArrayList<>();
    ImagePatternAdapter imagePatternAdapter;
    ImagePatternModel temp;
    ArrayList<String> nolist;

    String[] img = {"india","turkey","china","us","brazil","europeanunion","france","singapor","southafrica","mexico","pakistan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pattern);

        rvitempattern = (RecyclerView)findViewById(R.id.rvitempattern);
        for(int i = 1; i < img.length; i++){
            temp = new ImagePatternModel();
            nolist = new ArrayList<>();
            for(int j = 1; j <= i; j++){
                nolist.add(img[i]+"");
            }
            temp.setNo(nolist);
            temp.setItemPattern(nolist.toString());
            myImageList.add(temp);
        }
        layoutManager = new LinearLayoutManager(ImagePattern.this,LinearLayoutManager.VERTICAL,false);
        rvitempattern.setLayoutManager(layoutManager);
        imagePatternAdapter = new ImagePatternAdapter(ImagePattern.this,myImageList);
        rvitempattern.setAdapter(imagePatternAdapter);
    }
}
