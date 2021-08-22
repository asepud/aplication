package com.stmikbanisaleh.navbottom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class splashscreen extends Activity {

    TextView sub;
    ImageView foto;
    Animation fromButton, fromTop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(splashscreen.this, login.class));
                    finish();

                }
            }
        };
        thread.start();

        sub = (TextView) findViewById(R.id.sub);
        foto= (ImageView) findViewById(R.id.foto);

        fromButton= AnimationUtils.loadAnimation(this,R.anim.frombutton);
        fromTop= AnimationUtils.loadAnimation(this,R.anim.fromtop);

        sub.setAnimation(fromButton);
        foto.setAnimation(fromTop);
    }
}
