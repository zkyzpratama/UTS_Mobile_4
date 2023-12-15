package com.kelompok4.uts;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutDisaster extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_disaster);

        int photoResource = getIntent().getIntExtra("disaster_photo", 0);
        String name = getIntent().getStringExtra("disaster_name");
        String description = getIntent().getStringExtra("disaster_description");

        ImageView imageview = findViewById(R.id.img_item_photo);
        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView descTextView = findViewById(R.id.tv_item_description);

        imageview.setImageResource(photoResource);
        nameTextView.setText(name);
        descTextView.setText(description);
    }
}
