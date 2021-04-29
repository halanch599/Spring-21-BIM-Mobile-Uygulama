package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.bim_1_1.model.Customer;
import com.example.bim_1_1.model.CustomerListViewAdapter;
import com.example.bim_1_1.model.DbHelperCustomer;

import java.util.ArrayList;

public class CustomerListViewActivity extends AppCompatActivity {

    Button btnShow, btnAddCustomer;
    ListView lvCustomers;

    ArrayList<Customer> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list_view);

        btnShow = findViewById(R.id.btnShowCustomers);
        btnAddCustomer = findViewById(R.id.btnCustomerAddActivity);
        lvCustomers = findViewById(R.id.lvCustomer);

        DbHelperCustomer dbHelperCustomer = new DbHelperCustomer(this);


        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerListViewActivity.this, CustomerAddActivity.class);
                startActivity(intent);
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customers =  dbHelperCustomer.CustomerGetAll();
                CustomerListViewAdapter adapter = new CustomerListViewAdapter(CustomerListViewActivity.this,R.layout.customer_listview,customers);
                lvCustomers.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });




    }
}