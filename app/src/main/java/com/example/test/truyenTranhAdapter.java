package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class truyenTranhAdapter extends ArrayAdapter<truyenTranh> {

    private Context context;
    private ArrayList<truyenTranh> arrayList;

    public truyenTranhAdapter(@NonNull Context context, int resource, @NonNull List<truyenTranh> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = new ArrayList<>(objects);
    }


    public void nhantext(String s) {
        s = s.toUpperCase();

        int k = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            // chuyen tat ca chuoi text sang chu hoa
            truyenTranh tt = arrayList.get(i);
            String ten = tt.getTenTruyen().toUpperCase();

            // xap sep

            if (ten.indexOf(s) >= 0) {

                arrayList.set(i, arrayList.get(k));
                arrayList.set(k, tt);
                k++;

            }
        }
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.item_truyen, null);

        }

        if (arrayList.size() > 0) {
            truyenTranh truyenTranh = this.arrayList.get(position);

            TextView tenTruyen = convertView.findViewById(R.id.tvTenTruyen);
            TextView tenChap = convertView.findViewById(R.id.tvTenChap);
            ImageView imgAnh = convertView.findViewById(R.id.imgAnh);

            tenTruyen.setText(truyenTranh.getTenTruyen());
            tenChap.setText(truyenTranh.getTenChap());
            Glide.with(this.context).load(truyenTranh.getAnh()).into(imgAnh);

        }
        return convertView;

    }
}