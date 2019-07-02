package com.example.abdul.adpaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abdul.R;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    LayoutInflater mInflater;
    LinkedList<String> mWordList;
    public  static  String TAG = WordListAdapter.class.getSimpleName();
    public WordListAdapter(Context context,
                           LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override  // inflate one xml row -- empty wooden plank of menu
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View mItemView = mInflater.inflate(
                R.layout.list_row, viewGroup, false);
        Log.i(TAG,"onCreateViewHolder");
        return new WordViewHolder(mItemView, this);//you'll get this in onbindviewholder method
    }

    @Override  //populate data in inflated row
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int position) {
        String mCurrent = mWordList.get(position);
        wordViewHolder.wordItemView.setText(mCurrent);
        Log.i(TAG,"onBindViewHolder");


    }

    @Override //how many data count
    public int getItemCount() {
        return mWordList.size();
    }

    //wooden plank
    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        TextView wordItemView;
        WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            // Get the layout
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            // Associate with this adapter
            this.mAdapter = adapter;
            // Add click listener, if desired
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

        }
    }

}
