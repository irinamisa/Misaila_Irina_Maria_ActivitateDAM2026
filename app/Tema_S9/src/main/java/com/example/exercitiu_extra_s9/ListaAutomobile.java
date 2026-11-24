package com.example.exercitiu_extra_s9;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;import java.util.ArrayList;import java.util.List;

public class ListaAutomobile extends AppCompatActivity {
    private List<Automobil> automobile=new ArrayList<>();
    private ListView lvAutomobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_automobile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvAutomobile=findViewById(R.id.auto_LV);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            ArrayList<Automobil> listaPrimita=(ArrayList<Automobil>) bundle.getSerializable("lista_automobile");
            if(listaPrimita!=null)
            {
                automobile=listaPrimita;
            }
        }

        AutomobilAdapter adapter=new AutomobilAdapter(automobile,this,R.layout.item_lv_automobil);
        lvAutomobile.setAdapter(adapter);

        lvAutomobile.setOnItemClickListener((parent, view, position, id) -> {
            Automobil auto=automobile.get(position);
            Toast.makeText(this,auto.toString(),Toast.LENGTH_SHORT).show();
        });

        lvAutomobile.setOnItemLongClickListener((parent, view, position, id) -> {
            Automobil auto=automobile.get(position);

            int anFabricatieNou=(int) (auto.getAnFabricatie()-1);
            auto.setAnFabricatie(anFabricatieNou);

            adapter.notifyDataSetChanged();
            return true;
        });

        Button btnIntoarce=findViewById(R.id.intoarce_BTN);
        btnIntoarce.setOnClickListener(v ->{
            finish();
        });
    }
}