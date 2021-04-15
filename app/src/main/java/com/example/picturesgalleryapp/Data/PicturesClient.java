package com.example.picturesgalleryapp.Data;

import com.example.picturesgalleryapp.pojo.PicturesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By Mohamed A. Dahab on 4/10/2021
 **/
public class PicturesClient {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static PicturesClient INSTANCE;
    private PicturesApi picturesInterface;

    public PicturesClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        picturesInterface = retrofit.create(PicturesApi.class);

    }

    public Call<List<PicturesModel>>getPicturesList(){
        return picturesInterface.getPicturesList();
    }

    //the instance
    public static PicturesClient getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new PicturesClient();
        }
        return INSTANCE;
    }
}
