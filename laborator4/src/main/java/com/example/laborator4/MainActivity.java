package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView rezultatTV;
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

        rezultatTV=findViewById(R.id.rezultat_TV);
    }

    public void deschideActivitateNoua(View view) {
        Intent it=new Intent(this, ActivitateNoua.class);
        startActivityForResult(it,52);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==52)
        {
            if(resultCode==RESULT_OK)
            {
                Bundle b=data.getExtras();
                Melodie m = new Melodie(
                        b.getString("titlu", ""),
                        b.getString("artist", ""),
                        b.getString("gen", ""),
                        b.getInt("an", 0),
                        b.getFloat("nota", 0),
                        b.getBoolean("esteLansata", false));
                Toast.makeText(this, m.toString(), Toast.LENGTH_LONG).show();
                rezultatTV.setText(m.toString());
            }
        }
    }

    public void deschideActivitateAI(View view) {
        Intent it=new Intent(this, ActivitateAI.class);
        startActivityForResult(it,52);
    }

    //        public void culegeDate(View view)
//        {
//            EditText et=findViewById(R.id.nume_ET);
//            CheckBox cb=findViewById(R.id.eStudent_CB);
//
//            String nume=et.getText().toString();
//            Boolean eStudent=cb.isChecked(); //fol Boolean clasa pt metode; e imutabila; am referinta si o pot init cu null
//        }


}