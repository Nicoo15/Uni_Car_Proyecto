package com.example.uni_car;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;



/**
 * Crea un Activity con una animacion y arranca el login
 * @author Nico
 * @see SplashScreenActivity
 */

public class SplashScreenActivity extends Activity {
    @RequiresApi(api = Build.VERSION_CODES.O)
    /**
     * Ejecutamos splash_screen.xml
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        /**
         * Declaramos los textos del SplashScreem
         */


        TextView mySubtitle = (TextView)findViewById(R.id.textView11);
        ImageView myImage = (ImageView)findViewById(R.id.imageView3);
/**
 * Ponemos tipografia a nuestro texto
 */

        /**
         * Añadimos animacion a el splashScreen
         */

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.shake);

        mySubtitle.startAnimation(myanim);
        openApp(true);
    }

    /**
     * Iniciamos la app
     * @param locationPermission
     */
    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity
                        .this, Login.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }

}

