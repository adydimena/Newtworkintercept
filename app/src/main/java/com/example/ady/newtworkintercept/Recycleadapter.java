package com.example.ady.newtworkintercept;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.ady.newtworkintercept.AuxUtility.Item;
import com.example.ady.newtworkintercept.AuxUtility.MyApplication;
import com.example.ady.newtworkintercept.Model.Result;

import java.util.ArrayList;
import java.util.List;


public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.ViewHolder> {
    List<Result> list = new ArrayList<>() ;



    public Recycleadapter(List<Result> list) {

        this.list = list;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleviewlayout,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.get(position) != null) ;
            holder.firstname.setText(list.get(position).getName().getFirst());
            holder.LastName.setText(list.get(position).getName().getLast());


//        Glide.with(MyApplication.getAppContext())
            //              .load(list.get(position).getPhotourl())
            //            .into(holder.image);



    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView firstname;
        private final TextView LastName;


        public ViewHolder(View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.firstname);
            LastName = itemView.findViewById(R.id.lastName);




        }
    }


}
