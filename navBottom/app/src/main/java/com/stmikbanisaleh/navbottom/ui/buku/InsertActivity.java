package com.stmikbanisaleh.navbottom.ui.buku;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stmikbanisaleh.navbottom.R;
import com.stmikbanisaleh.navbottom.api.retrofitClient;
import com.stmikbanisaleh.navbottom.model.buku_m;
import com.stmikbanisaleh.navbottom.model.responseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    private Button buttonsave, buttoncancel, buttondelete;
    private EditText editjudul, editpenulis, editjenis, edittahun;
    private String judul, penulis, jenis, tahun;
    com.stmikbanisaleh.navbottom.api.api api;
    private buku_m buku = null;
    private retrofitClient retro;
    private AlertDialog dialog = null;
    private final InsertActivity activity = this;
    private boolean isNew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        editjenis = (EditText) findViewById(R.id.editjenis);
        editpenulis = (EditText) findViewById(R.id.editpenulis);
        editjenis = (EditText) findViewById(R.id.editjenis);
        edittahun = (EditText) findViewById(R.id.edittahun);
        buttonsave = (Button) findViewById(R.id.buttonsave);
        buttoncancel = (Button) findViewById(R.id.buttoncancel);
        buttondelete = (Button) findViewById(R.id.buttondelete);

        api = retro.getInstance().getApi();

        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                judul = editjudul.getText().toString();
                penulis = editpenulis.getText().toString();
                jenis = editjenis.getText().toString();
                tahun = edittahun.getText().toString();

                if(judul.trim().equals("")){
                    editjudul.setError("judul harus diisi");
                }else if(penulis.trim().equals("")) {
                    editpenulis.setError("Penulis harus diisi");
                }else{
                    prosesSave();

                }
            }
        });


    }

    private void prosesSave() {
    }


}