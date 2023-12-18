package com.kelompok4.uts.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import com.kelompok4.uts.AboutDisaster;
import com.kelompok4.uts.model.Disaster;
import com.kelompok4.uts.R;
import com.kelompok4.uts.controller.ListDisasterAdapter;

import java.util.ArrayList;

public class DisasterActivity extends AppCompatActivity {
    private RecyclerView rvDisasters;
    private ArrayList<Disaster> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disaster);
        rvDisasters = findViewById(R.id.rv_disasters);
        rvDisasters.setHasFixedSize(true);

        list.addAll(getListDisasters());
        showRecyclerList();
    }

    public ArrayList<Disaster> getListDisasters() {
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray(R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<Disaster> listDisaster = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Disaster disaster = new Disaster();
            disaster.setName(dataName[i]);
            disaster.setDescription(dataDescription[i]);
            disaster.setPhoto(dataPhoto.getResourceId(i, -1));
            listDisaster.add(disaster);
        }
        return listDisaster;
    }

    private void showRecyclerList(){
        rvDisasters.setLayoutManager(new LinearLayoutManager(this));
        ListDisasterAdapter listDisasterAdapter = new ListDisasterAdapter(list);
        rvDisasters.setAdapter(listDisasterAdapter);

        listDisasterAdapter.setOnItemClickCallback(this::showSelectedDisaster);
    }

    private void showSelectedDisaster(Disaster disaster){
        Intent intent = new Intent(DisasterActivity.this, AboutDisaster.class);

        intent.putExtra("disaster_name", disaster.getName());
        intent.putExtra("disaster_description", disaster.getDescription());
        intent.putExtra("disaster_photo", disaster.getPhoto());

        startActivity(intent);
        Toast.makeText(this, "Kamu memilih " + disaster.getName(), Toast.LENGTH_SHORT).show();
    }
}