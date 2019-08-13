package com.example.unsplashmvvm.Model.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.unsplashmvvm.Model.Network.PhotoApi;
import com.example.unsplashmvvm.Model.Network.RetrofitInstance;
import com.example.unsplashmvvm.Model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoRepository {
    private static PhotoRepository sRepository;
    private MutableLiveData<List<Photo>> mMutableLiveData;
    private MutableLiveData<String> mMutableLiveDataError;
    private PhotoApi mApi;

    private PhotoRepository(MutableLiveData<List<Photo>> mutableLiveData, MutableLiveData<String> mMutableLiveDataError) {
        this.mMutableLiveDataError = mMutableLiveDataError;
        this.mMutableLiveData = mutableLiveData;
        mApi = RetrofitInstance.getRetrofit().create(PhotoApi.class);
    }

    public static PhotoRepository getRepository(MutableLiveData<List<Photo>> mutableLiveData, MutableLiveData<String> mMutableLiveDataError) {
        if (sRepository == null) {
            synchronized (PhotoRepository.class) {
                sRepository = new PhotoRepository(mutableLiveData, mMutableLiveDataError);
            }
        }
        return sRepository;
    }

    public void getPhotoList() {
        Call<List<Photo>> call = mApi.LIST_CALL_PHOTOS("1" ,"715a7843be566956d79de69cea66b60fdbc59e11fd406667552630eb4fa4cf58" );
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response != null) {
                    mMutableLiveData.setValue(response.body());
                } else {
                    mMutableLiveDataError.setValue("An Error Occurred");
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                mMutableLiveDataError.setValue(t.getMessage());
            }
        });
    }
}
