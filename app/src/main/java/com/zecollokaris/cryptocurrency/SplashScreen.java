package com.zecollokaris.cryptocurrency;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SplashScreen extends AppCompatActivity {


//    TextView text;
//    Typeface tfc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        text = (TextView) findViewById(R.id.splashText);
//        tfc1 = Typeface.createFromAsset(getAssets(), "fonts/limelight.ttf");
//        text.setTypeface(tfc1);

    Thread myThread = new Thread(){
        @Override
        public void run(){
            try {
                sleep(4000);
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
        myThread.start();

    }
}













