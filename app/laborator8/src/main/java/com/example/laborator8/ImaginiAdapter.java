package com.example.laborator8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImaginiAdapter extends BaseAdapter {
    private List<ImaginiDomeniu> imagini=null;
    private Context ctx;
    private int resursaLayout;

    public ImaginiAdapter(Context ctx, List<ImaginiDomeniu> imagini, int resursaLayout) {
        this.ctx = ctx;
        this.imagini = imagini;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return imagini.size();
    }

    @Override
    public Object getItem(int position) {
        return imagini.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(resursaLayout, parent,false);

        ImageView imagine=v.findViewById(R.id.imagine);
        TextView descriere=v.findViewById(R.id.descriere);

        ImaginiDomeniu img=(ImaginiDomeniu) getItem(position);

        imagine.setImageBitmap(img.getImagine());
        descriere.setText(img.getTextAfisat());

        return v;
    }
}
