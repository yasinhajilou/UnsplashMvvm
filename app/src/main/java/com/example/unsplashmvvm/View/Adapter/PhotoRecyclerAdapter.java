package com.example.unsplashmvvm.View.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unsplashmvvm.Model.Photo;
import com.example.unsplashmvvm.R;

import java.util.List;

public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.PhotoViewHolder> {

    List<Photo> mPhotoList;

    public void setData (List<Photo> photoList){
        mPhotoList = photoList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo_list , parent , false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.bindData(mPhotoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotoList!=null ? mPhotoList.size() : 0;
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imgPhotoItem);
        }

        void bindData(Photo photo){
            Glide.with(mImageView.getContext()).load(photo.getUrls().getThumb()).into(mImageView);
        }
    }
}
