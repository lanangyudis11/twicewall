package com.mantabs.twicewall;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {
    String nama [] = {"Wallpaper", "Game", "Video", "Sticker", "Song"};
    int gambar[] = {R.drawable.ic_launcher,
                    R.drawable.l_1,
                    R.drawable.l_2,
                    R.drawable.l_3,
                    R.drawable.l_4};
    String detail[] = {"Wallpaper", "Game", "Video", "Sticker", "Song"};

    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter (Context context){
        this.context = context;
        layoutInflater = layoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_menu,parent,false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyHolder holder, final int position) {
        holder.txt.setText(nama[position]);
        holder.img.setImageResource(gambar[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent kirimData = new Intent(context, DetailActivity.class);
                kirimData.putExtra("Nama", nama[position]);
                kirimData.putExtra("IMG", gambar[position]);
                kirimData.putExtra("DET", detail[position]);

                context.startActivity(kirimData);

            }

        });
    }

            @Override
    public int getItemCount() {
        return nama.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.imgMenu);
            txt =  itemView.findViewById(R.id.txtdetail);
        }
    }
        }

