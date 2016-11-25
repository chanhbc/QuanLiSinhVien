package com.chanhbc.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private ArrayList<SinhVien> sinhViens;

    public ListViewAdapter(Context context, ArrayList<SinhVien> sinhViens){
        this.sinhViens = sinhViens;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sinhViens.size();
    }

    @Override
    public SinhVien getItem(int i) {
        return sinhViens.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            holder = new Holder();
            view = inflater.inflate(R.layout.item_list_view, viewGroup, false);
            holder.tvId = (TextView) view.findViewById(R.id.tv_id);
            holder.tvName = (TextView) view.findViewById(R.id.tv_name);
            holder.tvTong = (TextView) view.findViewById(R.id.tv_total);
            holder.tvToan = (TextView) view.findViewById(R.id.tv_toan);
            holder.tvLi = (TextView) view.findViewById(R.id.tv_li);
            holder.tvHoa = (TextView) view.findViewById(R.id.tv_hoa);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        SinhVien sinhVien = sinhViens.get(i);
        holder.tvId.setText("Id: " + sinhVien.getId());
        holder.tvName.setText(" - Name: " + sinhVien.getName());
        holder.tvTong.setText(" - Tong: " + sinhVien.getTong());
        holder.tvToan.setText("Toán: " + sinhVien.getToan());
        holder.tvLi.setText(" - Lí: " + sinhVien.getLi());
        holder.tvHoa.setText(" - Hóa: " + sinhVien.getHoa());
        return view;
    }

    private class Holder{
        private TextView tvId;
        private TextView tvName;
        private TextView tvTong;
        private TextView tvToan;
        private TextView tvLi;
        private TextView tvHoa;
    }
}
