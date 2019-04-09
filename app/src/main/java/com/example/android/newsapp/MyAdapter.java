package com.example.android.newsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    List<Result> newsArrayList;

    public MyAdapter(Context context) {
        this.context = context;
        this.newsArrayList = new ArrayList<>();
    }

    public void clearData(){
        newsArrayList.clear();
        notifyDataSetChanged();
    }

    public void addNewData(List<Result> arrayList){
        this.newsArrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Result result = newsArrayList.get(position);

        holder.mTitle.setText(result.getWebTitle());
        holder.mSection.setText(result.getSectionName());
        holder.mDate.setText(result.getWebPublicationDate());
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, mSection, mDate;
        LinearLayout mContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.titleID);
            mSection = itemView.findViewById(R.id.sectionNameID);
            mDate = itemView.findViewById(R.id.dateID);

            mContainer = itemView.findViewById(R.id.container_ID);
            mContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Result currentNews = newsArrayList.get(getAdapterPosition());
                    Uri newsUri = Uri.parse(currentNews.getWebUrl());

                    Intent webSiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);
                    context.startActivity(webSiteIntent);

                }
            });
        }
    }
}
