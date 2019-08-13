package com.example.unsplashmvvm.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.unsplashmvvm.Model.Photo;
import com.example.unsplashmvvm.Model.Repository.PhotoRepository;

import java.util.List;

public class PhotoViewModel extends ViewModel {
    MutableLiveData<String> mStringMutableLiveDataError;
    MutableLiveData<List<Photo>> mListMutableLiveDataPhoto;
    PhotoRepository mRepository;
    public PhotoViewModel() {
        mStringMutableLiveDataError = new MutableLiveData<>();
        mListMutableLiveDataPhoto = new MutableLiveData<>();
        mRepository = PhotoRepository.getRepository(mListMutableLiveDataPhoto,mStringMutableLiveDataError);
    }

    public void ReqGetAllPhoto(){
        mRepository.getPhotoList();
    }

    public LiveData<List<Photo>> getPhotos(){
        return mListMutableLiveDataPhoto;
    }

    public LiveData<String> getError(){
        return mStringMutableLiveDataError;
    }
}
