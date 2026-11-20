package com.example.laborator8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private List<Bitmap> imagini=new ArrayList<>();
    private List<ImaginiDomeniu> listaImagini;
    private ListView lvImagini;
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

        lvImagini=findViewById(R.id.imagini_lv);

        List<String> linkuriImagini=new ArrayList<>();
        linkuriImagini.add("https://gomagcdn.ro/domains2/bazardemuzica.ro/files/product/large/luna-amara-asfalt-209065.jpg");
        linkuriImagini.add("https://i.discogs.com/WhUlzDLsbHjy-fN02c-fhgiNchhfzTuVJyd2jjZ625A/rs:fit/g:sm/q:40/h:300/w:300/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTMxMjgz/MDAtMTM0MTY1ODI2/OC00MTQ2LmpwZWc.jpeg");
        linkuriImagini.add("https://i.discogs.com/dVkDdRFfNvQY0chnftrXKaPLQnGBYnMoYpKnxHugxVw/rs:fit/g:sm/q:40/h:300/w:300/czM6Ly9kaXNjb2dz/LWRhdGFiYXNlLWlt/YWdlcy9SLTI1Njgw/Nzk2LTE2NzMwMzM4/NDctOTMzNi5qcGVn.jpeg");
        linkuriImagini.add("https://cdn-images.dzcdn.net/images/cover/ba6c7c231c21930465a4f51a41e3d5a5/0x1900-000000-80-0-0.jpg");
        linkuriImagini.add("https://cdn-images.dzcdn.net/images/cover/31752b79ecbbdc65a26593759c8e08f8/0x1900-000000-80-0-0.jpg");

        Executor executor= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                for(String link:linkuriImagini){
                    HttpURLConnection con=null;
                    try{
                        URL url=new URL(link);
                        con=(HttpURLConnection) url.openConnection();
                        InputStream is=con.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        listaImagini = new ArrayList<>();
                        listaImagini.add(new ImaginiDomeniu(imagini.get(0), "https://letsrock.ro/reviews/cronica-de-concert-luna-amara-asfalt-20-de-ani-in-club-quantic-1485.html", "Asfalt - Luna Amara"));
                        listaImagini.add(new ImaginiDomeniu(imagini.get(1), "https://thefalconsnestalbumjukebox.wordpress.com/2013/07/13/beth-hart-and-joe-bonamassa-dont-explain/", "Don't Explain - Beth Hart & Joe bonamassa"));
                        listaImagini.add(new ImaginiDomeniu(imagini.get(2), "https://classicalbumsundays.com/album-of-the-month-neil-young-harvest/", "Harvest - Neil Young"));
                        listaImagini.add(new ImaginiDomeniu(imagini.get(3), "https://www.metalnerdery.com/episodes/album-dive-vulgar-display-of-power", "Vulgar Display of Power - Pantera"));
                        listaImagini.add(new ImaginiDomeniu(imagini.get(4), "https://loudwire.com/why-alice-in-chains-dirt-greatest-album-all-time/", "Dirt - Alice in Chains"));

                        ImaginiAdapter adapter = new ImaginiAdapter(getApplicationContext(), listaImagini, R.layout.item_lv);

                        lvImagini.setAdapter(adapter);
                    }
                });
            }
        });

        lvImagini.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(getApplicationContext(), ActivitateWebView.class);
                it.putExtra("link",listaImagini.get(position).getLink());
                startActivity(it);
            }
        });
    }
}