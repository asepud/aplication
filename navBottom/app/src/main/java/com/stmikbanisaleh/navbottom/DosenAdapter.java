package com.stmikbanisaleh.navbottom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stmikbanisaleh.navbottom.ui.notifications.NotificationsFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DosenAdapter extends RecyclerView.Adapter<DosenAdapter.DosenviewHolder> implements Filterable {
    private NotificationsFragment context;
    private List<Dosen> list = new ArrayList<>();
    private List<Dosen> filteredList = new ArrayList<>();
    private Map<String, String> initialColor = new HashMap<>();

    public DosenAdapter(NotificationsFragment context, List<Dosen> list){
        this.context = context;
        this.list= list;
        this.filteredList = list;
        initialColor.put("M", "#00aaaa");
        initialColor.put("S", "#0000aa");
        initialColor.put("H", "#aa0000");
        initialColor.put("R", "#aaaa00");
        initialColor.put("N", "#aa00aa");
        initialColor.put("T", "#00aa00");
    }
    @NonNull
    @Override
    public DosenviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        DosenviewHolder holder = new DosenviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DosenviewHolder holder, int position) {
        Dosen dosen = list.get(position);
        holder.textNama.setText(dosen.getNama());
        holder.textkompetensi.setText(dosen.getKomptensi());
        String textstatus = (dosen.isStatus()? " " : "Tidak") + "Hadir";
        String colorstatus = (dosen.isStatus()?"#00aa00": "#aa0000");
        holder.textstatus.setText(textstatus);
        String initial = dosen.getNama().substring(0,1);
        holder.textInitial.setText(initial);
        holder.viewInitial.getBackground().setColorFilter(Color.parseColor(initialColor.get(initial)), PorterDuff.Mode.SRC_ATOP);
        holder.viewStatus.getBackground().setColorFilter(Color.parseColor(colorstatus), PorterDuff.Mode.SRC_ATOP);

    }

    @Override
    public int getItemCount() {
       return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence Constraint) {
                String search = Constraint.toString();
                List<Dosen> listFilter = new ArrayList<>();
                for (Dosen dosen : list){
                    if (dosen.getNama().toLowerCase().contains(search.toLowerCase())){
                        listFilter.add(dosen);
                    }
                }
                filteredList = listFilter;
                FilterResults results = new FilterResults();
                results.values = listFilter;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                filteredList = (List<Dosen>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class DosenviewHolder extends RecyclerView.ViewHolder{
        LinearLayout viewInitial = null;
        TextView textNama, textkompetensi, textstatus, textInitial;
        View viewStatus = null;

        public DosenviewHolder(@NonNull View view) {
            super(view);
            viewInitial = view.findViewById(R.id.viewInitial);
            textNama = view.findViewById(R.id.textNama);
            textkompetensi = view.findViewById(R.id.textkompetensi);
            textInitial = view.findViewById(R.id.textInitial);
            textstatus = view.findViewById(R.id.textstatus);
            viewStatus = view.findViewById(R.id.view);
        }
    }
}
