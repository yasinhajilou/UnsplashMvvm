package com.example.unsplashmvvm.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.unsplashmvvm.Model.Photo;
import com.example.unsplashmvvm.R;
import com.example.unsplashmvvm.View.Adapter.PhotoRecyclerAdapter;
import com.example.unsplashmvvm.ViewModel.PhotoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PhotoViewModel mPhotoViewModel;
    Button mButton;
    private String TAG = MainActivity.class.getSimpleName();
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rvPhotoList);

        final PhotoRecyclerAdapter adapter = new PhotoRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2 ));

        mPhotoViewModel = ViewModelProviders.of(this).get(PhotoViewModel.class);

        mPhotoViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                Log.d(TAG, s);
            }
        });
        mPhotoViewModel.getPhotos().observe(MainActivity.this, new Observer<List<Photo>>() {
            @Override
            public void onChanged(List<Photo> photos) {
                adapter.setData(photos);
            }
        });

        mPhotoViewModel.ReqGetAllPhoto();
    }

}
