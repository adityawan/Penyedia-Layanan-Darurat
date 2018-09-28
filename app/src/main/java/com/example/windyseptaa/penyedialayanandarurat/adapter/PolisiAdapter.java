package com.example.windyseptaa.penyedialayanandarurat.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windyseptaa.penyedialayanandarurat.R;
import com.example.windyseptaa.penyedialayanandarurat.model.Polisi;

import java.util.ArrayList;

public class PolisiAdapter extends RecyclerView.Adapter<PolisiAdapter.ViewHolder> {

    private ArrayList<Polisi> polisi;

    public PolisiAdapter(ArrayList<Polisi> polisi) {
        this.polisi = polisi;
    }

    @Override
    public PolisiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_polisi,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PolisiAdapter.ViewHolder holder, int position) {
        holder.txtnama.setText(polisi.get(position).getNama());
        holder.txtalamat.setText(polisi.get(position).getAlamat());
        holder.txtnomor.setText(polisi.get(position).getNomor());

    }

    @Override
    public int getItemCount() {
        return polisi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnama, txtalamat, txtnomor;
        public ViewHolder(View view){
            super(view);
            txtnama = (TextView)view.findViewById(R.id.txtnama);
            txtalamat = (TextView)view.findViewById(R.id.txtalamat);
            txtnomor = (TextView)view.findViewById(R.id.txtnomor);
        }
    }
}
