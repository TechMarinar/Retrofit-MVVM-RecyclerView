package com.example.picturesgalleryapp.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.picturesgalleryapp.Data.PicturesApi;
import com.example.picturesgalleryapp.Data.PicturesClient;
import com.example.picturesgalleryapp.pojo.PicturesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created By Mohamed A. Dahab on 4/10/2021
 **/
public class PicturesViewModel extends ViewModel {

    private static final String TAG = "PicturesViewModel";
    public MutableLiveData<List<PicturesModel>> listMutableLiveData= new MutableLiveData<>();

    public void getPicturesList(){

        PicturesClient.getINSTANCE().getPicturesList().enqueue(new Callback<List<PicturesModel>>() {
            @Override
            public void onResponse(Call<List<PicturesModel>> call, Response<List<PicturesModel>> response) {

                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PicturesModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });

    }
}
