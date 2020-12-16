package com.stmikbanisaleh.latihanrecycleview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import com.stmikbanisaleh.latihanrecycleview.remote.PagingResponse;
import com.stmikbanisaleh.latihanrecycleview.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView = null;
    private List<Dosen> list= null;
    private DosenAdapter adapter = null;

    private DosenDao dao = null;
    private View viewDialog = null;
    private EditText textNama, textkompetensi;
    private CheckBox checkBoxstatus;
    private Button buttonsave, buttoncancel, buttondelete;
    private AlertDialog dialog = null;
    private Dosen dosen = null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
//        dao = AppDatabase.getDb(this).dosenDao();
//        list = dao.getAll();
        final MainActivity activity = this;
        Call<PagingResponse> call = RetrofitClient.getInstance().getApi().getlist();
        call.enqueue(new Callback<PagingResponse>() {
            @Override
            public void onResponse(Call<PagingResponse> call, Response<PagingResponse> response) {
                list = response.body().getData();
                adapter =  new DosenAdapter(activity, list, activity);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PagingResponse> call, Throwable t) {
                list = new ArrayList<>();
                adapter =  new DosenAdapter(activity, list, activity);
                recyclerView.setAdapter(adapter);
            }
        });

        setupDialog();
    }

    private void setupDialog() {
        viewDialog = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        textNama = viewDialog.findViewById(R.id.editNama);
        textkompetensi = viewDialog.findViewById(R.id.editkompetensi);
        checkBoxstatus = viewDialog.findViewById(R.id.checkboxsts);
        buttonsave = viewDialog.findViewById(R.id.buttonsave);
        buttoncancel = viewDialog.findViewById(R.id.buttoncancel);
        buttondelete = viewDialog.findViewById(R.id.buttondelete);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dosen Detail");
        builder.setView(viewDialog);
        dialog = builder.create();
        buttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processSave();
            }
        });
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processDelete();
            }
        });
    }

    private void showDialog(){
        textNama.setText(dosen.getNama());
        textkompetensi.setText(dosen.getKomptensi());
        checkBoxstatus.setChecked(dosen.isStatus());
        dialog.show();
    }

    private void processSave(){
        dosen.setNama(textNama.getText().toString());
        dosen.setKomptensi(textkompetensi.getText().toString());
        dosen.setStatus(checkBoxstatus.isChecked());
        try {
            if(dosen.getId()>0){
                dao.update(dosen);
            }else {
                long id = dao.insert(dosen);
                dosen.setId((int)id);
                list.add(0, dosen);
            }
            adapter.notifyDataSetChanged();
            dialog.dismiss();
            Toast.makeText(this, "Data dosen berhasil disimpan", Toast.LENGTH_SHORT).show();

        }catch (Exception ex){
            Toast.makeText(this, "Data dosen gagal disimpan", Toast.LENGTH_SHORT).show();
        }
    }

    private void processDelete(){
        try {
            list.remove(dosen);
            adapter.notifyDataSetChanged();
            dialog.dismiss();
            Toast.makeText(this, "Data dosen berhasil dihapus", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(this, "Data dosen gagal dihapus", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonAddClick(View v){
        dosen = new Dosen();
        dosen.setId(0);
        buttondelete.setVisibility(View.INVISIBLE);
        showDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.menu_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("cari dosen");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public void onClick(View v) {
        int position = recyclerView.getChildAdapterPosition(v);
        dosen = list.get(position);
        buttondelete.setVisibility(View.VISIBLE);
        showDialog();

    }
}
