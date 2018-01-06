package br.com.rbarbioni.constraintlayoutstarter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView subtitle = findViewById(R.id.subtitle);

        final String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit! adipiscing elit";
        final String text2 = "Lorem ipsum dolor sit amet";

        new Thread(new Runnable() {
            @Override
            public void run() {

                final AtomicInteger index = new AtomicInteger(1);
                while (true){

                    try {
                        Thread.sleep(3000L);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                              if (index.getAndDecrement() % 2 == 0){
                                  subtitle.setText(text1);
                              }else{
                                  subtitle.setText(text2);
                              }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}