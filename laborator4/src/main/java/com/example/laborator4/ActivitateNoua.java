package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

public class ActivitateNoua extends AppCompatActivity {
    private EditText titluET, artistET;
    private RadioGroup genRG;
    private Spinner anSP;
    private RatingBar notaRB;
    private CheckBox esteLansataCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_noua);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        titluET=findViewById(R.id.titlu_ET);
        artistET=findViewById(R.id.artist_ET);
        genRG=findViewById(R.id.gen_RG);
        anSP=findViewById(R.id.an_SP);
        notaRB=findViewById(R.id.nota_RB);
        esteLansataCB=findViewById(R.id.esteLansata_CB);

        List<Integer> ani=new ArrayList<>();
        for(int an=2026;an>=1900;an--)
        {
            ani.add(an);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, ani);
        anSP.setAdapter(adapter);
    }

    public void trimiteDatele(View view) {
        SwitchMaterial confirmSW = findViewById(R.id.confirm_SW);
        if (!confirmSW.isChecked()) {
            Toast.makeText(this, "Confirmă datele înainte de trimitere", Toast.LENGTH_SHORT).show();
            return;
        }

        String titlu=titluET.getText().toString();
        String artist=artistET.getText().toString();

        int idSelectat=genRG.getCheckedRadioButtonId();
        RadioButton genSelectat=findViewById(idSelectat);
        String gen=genSelectat.getText().toString();

        int an=(int) anSP.getSelectedItem();
        float nota=notaRB.getRating();
        Boolean esteLansata=esteLansataCB.isChecked();

        Bundle bundle=new Bundle();
        bundle.putString("titlu",titlu);
        bundle.putString("artist",artist);
        bundle.putString("gen",gen);
        bundle.putInt("an",an);
        bundle.putFloat("nota",nota);
        bundle.putBoolean("esteLansata",esteLansata);

        Intent it=new Intent();
        it.putExtras(bundle);
        setResult(RESULT_OK,it);
        finish();
    }
}