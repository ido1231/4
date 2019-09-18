package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    EditText etName,etPhone,etEmail;
    Button btnReady;
    ArrayList<String> peoples;
    ArrayAdapter<String>adap;
    String st1,st2,st3,st4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        btnReady = findViewById(R.id.btnReady);
        peoples = new ArrayList<String>();

        btnReady.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                st1 = etName.getText().toString();
                st2 = etPhone.getText().toString();
                st3 = etEmail.getText().toString();

                st4 = st1 +"\n"+st2+"\n"+st3;
                peoples.add(st4);
                adap = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, peoples);
                lv.setAdapter(adap);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String temp = peoples.get(position);
                Toast.makeText(MainActivity.this, "Detailes:\n" + temp, Toast.LENGTH_SHORT).show();

            }
        });


    }

}
