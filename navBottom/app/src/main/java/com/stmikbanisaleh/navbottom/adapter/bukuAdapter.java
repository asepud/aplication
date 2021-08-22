package com.stmikbanisaleh.navbottom.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.api.retrofitClient;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.ui.buku.EditActivity;
import com.stmikbanisaleh.navbottom.ui.buku.SettingFragment;

import java.util.ArrayList;
import java.util.List;

public class bukuAdapter extends RecyclerView.Adapter<bukuAdapter.bukuviewHolder>{
    private SettingFragment contex;
    private List<buku_m> list = new ArrayList<>();
    private View.OnClickListener listener;
    private EditText editjudul, editpenulis, editjenis, edittahun;
    private String judul, penulis, jenis, tahun;

    public bukuAdapter(SettingFragment contex, List<buku_m> list,  SettingFragment setting1) {
        this.contex = contex;
        this.list = list;
    }



    @NonNull
    @Override
    public bukuviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        view.setOnClickListener(listener);
        bukuviewHolder holder = new bukuviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull bukuviewHolder holder, final int position) {
        buku_m buku = list.get(position);
        holder.tv_judul.setText(buku.getJudul());
        holder.tv_penulis.setText(buku.getPenulis());
        holder.tv_jenis.setText(buku.getJenis());
        holder.tv_tahun.setText(buku.getTahun());
        Glide.with(holder.image_buku.getContext())
                .load(retrofitClient.IMAGE_URL + list.get(position).getImage())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.image_buku);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditActivity.class);
                intent.putExtra("id", list.get(position).getId());
                intent.putExtra("judul", list.get(position).getJudul());
                intent.putExtra("penulis", list.get(position).getPenulis());
                intent.putExtra("jenis", list.get(position).getJenis());
                intent.putExtra("tahun", list.get(position).getTahun());
                intent.putExtra("image", list.get(position).getImage());
                view.getContext().startActivity(intent);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class bukuviewHolder extends RecyclerView.ViewHolder{
        ImageView image_buku = null;
        TextView tv_judul, tv_penulis, tv_jenis, tv_tahun;
        View viewStatus = null;

        public bukuviewHolder(@NonNull View view) {
            super(view);
            tv_judul = view.findViewById(R.id.tv_judul);
            tv_penulis = view.findViewById(R.id.tv_penulis);
            tv_tahun = view.findViewById(R.id.tv_tahun);
            tv_jenis = view.findViewById(R.id.tv_jenis);
            image_buku = view.findViewById(R.id.image_buku);

        }
    }
}
