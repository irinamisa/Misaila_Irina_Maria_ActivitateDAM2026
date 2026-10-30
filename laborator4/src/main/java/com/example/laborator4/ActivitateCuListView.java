package com.example.laborator4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ActivitateCuListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activitate_cu_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent it=getIntent();
        Bundle bundle=it.getExtras();

        List<String> melodiiStr=bundle.getStringArrayList("melodii");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, melodiiStr);
        ListView lv = findViewById(R.id.lista1_LV);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, melodiiStr.get(position).toString(), Toast.LENGTH_LONG).show());

        lv.setOnItemLongClickListener((parent, view, position, id) ->
        {   melodiiStr.remove(position);
            adapter.notifyDataSetChanged();
            return true;});
    }
}