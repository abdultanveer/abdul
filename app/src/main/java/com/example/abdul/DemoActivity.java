package com.example.abdul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abdul.adpaters.WordListAdapter;

import java.util.LinkedList;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        LinkedList<String> mWordList = new LinkedList<>();
        mWordList.add("android");
        mWordList.add("recycler view");
        mWordList.add("demo");
        mWordList.add("sageit");
        mWordList.add("abdul");

        RecyclerView  mRecyclerView = (RecyclerView)
                findViewById(R.id.recyclerview);
        WordListAdapter mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new
                LinearLayoutManager(this));


    }
}
