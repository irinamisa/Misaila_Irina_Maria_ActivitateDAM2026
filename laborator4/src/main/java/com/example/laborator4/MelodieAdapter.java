package com.example.laborator4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MelodieAdapter extends BaseAdapter {
    private List<Melodie> melodii=null;
    private Context ctx;
    private int resursaLayout;

    public MelodieAdapter(Context ctx, List<Melodie> melodii, int resursaLayout) {
        this.ctx = ctx;
        this.melodii = melodii;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return melodii.size();
    }

    @Override
    public Object getItem(int position) {
        return melodii.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v = inflater.inflate(R.layout.activity_list_view_custom_adapter, parent,false);
        TextView titlu=v.findViewById(R.id.titlu_TW);
        TextView artist=v.findViewById(R.id.artist_TW);
        TextView gen=v.findViewById(R.id.gen_TW);
        TextView an=v.findViewById(R.id.an_TW);
        TextView nota=v.findViewById(R.id.nota_TW);
        TextView esteLansata=v.findViewById(R.id.esteLansata_TW);

        Melodie m=(Melodie) getItem(position);

        titlu.setText(m.getTitlu());
        artist.setText(m.getArtist());
        gen.setText(m.getGenMuzical());
        an.setText(""+m.getAnLansare());
        nota.setText(""+m.getNota());
        esteLansata.setText(m.isEsteLansata() ? "Lansată" : "Nelansată");

        return v;
    }
}
