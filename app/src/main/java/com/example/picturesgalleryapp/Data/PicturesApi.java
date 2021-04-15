package com.example.picturesgalleryapp.Data;

import com.example.picturesgalleryapp.pojo.PicturesModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created By Mohamed A. Dahab on 4/10/2021
 **/
public interface PicturesApi {
    @GET("photos")
    public Call <List<PicturesModel>> getPicturesList();

}
