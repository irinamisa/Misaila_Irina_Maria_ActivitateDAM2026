package com.example.exercitiu_extra_s9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AutomobilAdapter extends BaseAdapter {
    private Context ctx;
    private List<Automobil> automobile=null;
    private int resursaLayout;

    public AutomobilAdapter(List<Automobil> automobile, Context ctx, int resursaLayout) {
        this.automobile = automobile;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return automobile.size();
    }

    @Override
    public Object getItem(int position) {
        return automobile.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v=inflater.inflate(resursaLayout,parent,false);

        TextView tvId=v.findViewById(R.id.idTV);
        TextView tvMarca=v.findViewById(R.id.marcaTV);
        TextView tvModel=v.findViewById(R.id.modelTV);
        TextView tvEsteElectric=v.findViewById(R.id.esteElectricTV);
        TextView tvAnFabricatie=v.findViewById(R.id.anFabricatieTV);

        Automobil auto=(Automobil) getItem(position);

        tvId.setText(""+auto.getIdAutomobil());
        tvMarca.setText(auto.getMarca());
        tvModel.setText(auto.getModel());
        tvEsteElectric.setText(auto.isEsteElectric() ? "Este electric" : "NU este electric");
        tvAnFabricatie.setText(""+auto.getAnFabricatie());
        return v;
    }
}
