package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Result;

import java.util.ArrayList;



public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>  {

      private ArrayList<Result> resultArrayList;


    public CountryAdapter(ArrayList<Result> resultArrayList) {
        this.resultArrayList = resultArrayList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

       View view = layoutInflater.inflate(R.layout.country_item,parent,false);




        return  new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
          holder.countyNameTextView.setText(resultArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }


    class CountryViewHolder extends RecyclerView.ViewHolder{
        TextView countyNameTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            countyNameTextView = itemView.findViewById(R.id.countyNameTextView);
        }
    }
}
