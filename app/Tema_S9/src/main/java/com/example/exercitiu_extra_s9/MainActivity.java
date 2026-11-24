package com.example.exercitiu_extra_s9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnAdauga;
    private Button btnAfiseaza;
    private List<Automobil> automobile=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAdauga=findViewById(R.id.adaugaBtn);
        btnAdauga.setOnClickListener(v->{
            Intent it=new Intent(this, AdaugaAutomobil.class);
            startActivityForResult(it,111);
        });

        btnAfiseaza=findViewById(R.id.afiseaza_Btn);
        btnAfiseaza.setOnClickListener(v->{
            Intent it=new Intent(this, ListaAutomobile.class);
            it.putExtra("lista_automobile",new ArrayList<>(automobile));

            startActivity(it);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111 && resultCode==RESULT_OK && data!=null)
        {
            Bundle bundle=data.getExtras();

            if(bundle!=null)
            {
                Automobil auto=(Automobil) bundle.getSerializable("automobil");

                if(auto!=null)
                {
                    automobile.add(auto);
                }
            }
        }
    }
}