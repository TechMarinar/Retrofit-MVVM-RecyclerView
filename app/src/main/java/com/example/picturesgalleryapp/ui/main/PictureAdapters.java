package com.example.picturesgalleryapp.ui.main;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Util;
import com.example.picturesgalleryapp.R;
import com.example.picturesgalleryapp.pojo.PicturesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created By Mohamed A. Dahab on 4/10/2021
 **/
public class PictureAdapters extends RecyclerView.Adapter<PictureAdapters.ItemViewHolder> {
    private static final String TAG = "PictureAdapters";

    private List<PicturesModel> picturesList= new ArrayList<>();
    private Context mContext;
    private RequestOptions options;

    public PictureAdapters() {
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.picture_list_item,parent,false);
        //set context
        mContext = parent.getContext();

        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final PicturesModel currentModel = picturesList.get(position);

        holder.picId.setText(""+currentModel.getId());
        holder.picTitle.setText(currentModel.getTitle());

        String imgUrl = currentModel.getUrl();

//        Toast.makeText(mContext, imgUrl, Toast.LENGTH_SHORT).show();

//        Glide.with(mContext)
//                .load(currentModel.getUrl())
//                .fitCenter()
//                .placeholder(R.drawable.pharaos)
//                .into(holder.imageView);

        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.pharaos)
                .error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH);

        Glide.with(mContext).load(imgUrl)
                .apply(options)
                .override(300,250)
                .into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        return picturesList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView picTitle , picId;
        private ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            picTitle = (TextView)itemView.findViewById(R.id.titleTv);
            picId = (TextView)itemView.findViewById(R.id.idTv);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewer);

        }
    }

    public void setPicturesList(List<PicturesModel> picturesList) {
        this.picturesList = picturesList;
        notifyDataSetChanged();
    }
}