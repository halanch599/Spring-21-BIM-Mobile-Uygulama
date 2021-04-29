package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bim_1_1.model.DbHelperCustomer;

public class CustomerAddActivity extends AppCompatActivity {


    Button btnAdd;
    TextView tvMessgage;
    EditText etFName, etLName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);


        btnAdd =  findViewById(R.id.btnCustomerAdd);
        tvMessgage = findViewById(R.id.tvCustomerMessage);
        etFName  =  findViewById(R.id.etCustomerFirstName);
        etLName = findViewById(R.id.etCustomerLastName);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelperCustomer dbHelperCustomer = new DbHelperCustomer(CustomerAddActivity.this);
                long result = dbHelperCustomer.CustomerAdd(etFName.getText().toString().trim(),etLName.getText().toString().trim());

                if(result>0)
                {
                    tvMessgage.setText("Customer added");
                    tvMessgage.setTextColor(Color.GREEN);
                    etFName.setText("");
                    etLName.setText("");
                }
                else
                {
                    tvMessgage.setText("Failed to add Customer");
                    tvMessgage.setTextColor(Color.RED);
                }
            }
        });
    }
}