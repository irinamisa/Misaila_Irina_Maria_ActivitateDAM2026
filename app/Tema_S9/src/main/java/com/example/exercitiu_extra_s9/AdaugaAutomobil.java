package com.example.exercitiu_extra_s9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaAutomobil extends AppCompatActivity {
    private EditText etId;
    private Spinner spMarca;
    private EditText etModel;
    private EditText etCapacitate;
    private NumberPicker npAnFabricatie;
    private CheckBox cbEsteElectrica;
    private Button btnSalveaza;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_automobil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etId=findViewById(R.id.id_ET);
        spMarca=findViewById(R.id.marca_SP);
        etModel=findViewById(R.id.model_ET);
        etCapacitate=findViewById(R.id.capacitate_ET);
        npAnFabricatie=findViewById(R.id.anFabricatie_NP);
        cbEsteElectrica=findViewById(R.id.esteElectric_CB);

        String[] marca_auto=getResources().getStringArray(R.array.marca_auto);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,marca_auto);
        spMarca.setAdapter(adapter);

        npAnFabricatie.setMinValue(1950);
        npAnFabricatie.setMaxValue(2050);

        btnSalveaza=findViewById(R.id.salveaza_BTN);
        btnSalveaza.setOnClickListener(v->{
            String idText=etId.getText().toString().trim();
            String model=etModel.getText().toString().trim();
            String capacitateText=etCapacitate.getText().toString().trim();

            //facem validarea pentru a ne asigura ca au fost introduse date in et
            if(idText.isEmpty() || model.isEmpty() || capacitateText.isEmpty())
            {
                Toast.makeText(this,"Completati toate campurile!",Toast.LENGTH_SHORT).show();
                return;
            }

            int id=Integer.parseInt(idText);

            String marca=spMarca.getSelectedItem().toString();

            float capacitate=Float.parseFloat(capacitateText);

            int anFabricatie=npAnFabricatie.getValue();

            boolean esteElectric=cbEsteElectrica.isChecked();

            Automobil auto=new Automobil(anFabricatie,capacitate,esteElectric,id,marca,model);

            Bundle bundle=new Bundle();
            bundle.putSerializable("automobil",auto);

            Intent it=new Intent();
            it.putExtras(bundle);

            setResult(RESULT_OK,it);
            finish();
        });
    }
}