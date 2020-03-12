package com.racofix.things.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IDataRepository dataStore = DataRepository.getInstance();
        dataStore.devices(new DataCallback<List<String>>() {
            @Override
            public void data(List<String> data) {

            }
        });
    }
}
