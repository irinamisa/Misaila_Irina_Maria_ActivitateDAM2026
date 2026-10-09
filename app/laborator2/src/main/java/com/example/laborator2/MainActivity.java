package com.example.laborator2;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }
//2. Implementați metodele pentru prezentarea ciclului de viață al unei activități:
// onStart(), onResume(), onPause(), onStop().
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Seminar","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("Seminar","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Seminar","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Seminar","onStop");
    }
    //3. In cadrul fiecărei metode salvați un log de tipul error,
    // warning, debug, info: Log.e(), Log.w(), Log.d(), Log.i(), Log.v()-asemanator cu info.
    //logurile sunt fisiere cu detalii despre ceea ce s a intamplat
    //cand schimbam in view landscape se apeleaza ondestroy dupa onstart, iar starea trebuie salvata de programator
}
