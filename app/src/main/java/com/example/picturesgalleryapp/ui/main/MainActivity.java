package com.example.picturesgalleryapp.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.picturesgalleryapp.Data.PicturesClient;
import com.example.picturesgalleryapp.R;
import com.example.picturesgalleryapp.pojo.PicturesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private PicturesViewModel picturesViewModel ;
    private RecyclerView recyclerView ;
    private PictureAdapters adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapters = new PictureAdapters();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //init the View Model
        picturesViewModel = new ViewModelProvider(this).get(PicturesViewModel.class);
        picturesViewModel.getPicturesList();

        //set the adapter
        recyclerView.setAdapter(adapters);

        picturesViewModel.listMutableLiveData.observe(this, new Observer<List<PicturesModel>>() {
            @Override
            public void onChanged(List<PicturesModel> picturesModels) {
                adapters.setPicturesList(picturesModels);
            }
        });
    }
}