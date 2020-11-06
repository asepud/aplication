package com.stmikbanisaleh.navbottom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {

    Button login;
    Button regist;
    EditText textpesan= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login);
        regist = (Button) findViewById(R.id.regist);
        textpesan = findViewById(R.id.username);



        login.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                startActivity(new Intent(login.this, MainActivity.class));
                View layout = getLayoutInflater().inflate(R.layout.customtoast, (ViewGroup) findViewById(R.id.custom_toast_container));
                TextView textView = layout.findViewById(R.id.text);
                textpesan.setText(textpesan.getText());
                Toast toast = Toast.makeText(login.this, " ", Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();
            }
        });

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, daftar.class));
            }
        });
    }
}
