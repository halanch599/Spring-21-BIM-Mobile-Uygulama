package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class YemekActivity extends AppCompatActivity {

    List<String> yemekList;
    ArrayAdapter<String> yememkAdapter;

    ListView lvYemek;
    EditText etYemekAdi;
    Button btnAddYemek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek);

        yemekList = new ArrayList<>();
        yememkAdapter = new ArrayAdapter<>(this,R.layout.list_view_yemek,yemekList);

        lvYemek = findViewById(R.id.lvYemek);
        etYemekAdi = findViewById(R.id.etYemekAdi);
        btnAddYemek = findViewById(R.id.btnAddYemek);

        lvYemek.setAdapter(yememkAdapter);

        btnAddYemek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = etYemekAdi.getText().toString();
                if(!txt.equals("")) {
                    yemekList.add(txt);
                    yememkAdapter.notifyDataSetChanged();
                    etYemekAdi.setText("");
                }
            }
        });

        lvYemek.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TextView textView = (TextView) view;
                Toast.makeText(YemekActivity.this, textView.getText().toString(), Toast.LENGTH_LONG).show();

                textView.setBackgroundColor(Color.BLACK);
                textView.setTextColor(Color.WHITE);


            }
        });

        // Class activity for next week
        // add a text view and button to search and show the yemek list.



    }
}