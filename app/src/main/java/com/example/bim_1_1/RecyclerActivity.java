package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.bim_1_1.model.Product;
import com.example.bim_1_1.model.ProductAdapterRecycler;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity implements ProductAdapterRecycler.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter prodtAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Product> productList;
    Button btnAddProduct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        btnAddProduct = findViewById(R.id.btnAddMainProduct);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList.add(new Product("New Laptop",3500,R.drawable.laptop_100px,0,"Eletronics","This is an email laptop"));
                prodtAdapter.notifyDataSetChanged();
            }
        });

        productList = new ArrayList<>();
        productList.add(new Product("Laptop",3500,R.drawable.laptop_100px,0,"Eletronics","This is an email laptop"));
        productList.add(new Product("Apple MObile Phone",6500,R.drawable.apple_100px,5,"Eletronics","This is an email laptop"));
        productList.add(new Product("Mobile",5000,R.drawable.mobile_phone_100px,3,"Eletronics","This is an email laptop"));
        productList.add(new Product("Watch",4600,R.drawable.smart_watch_100px,6,"Eletronics","This is an email laptop"));
        productList.add(new Product("Mobile",5000,R.drawable.mobile_phone_100px,0,"Eletronics","This is an email laptop"));


        recyclerView = findViewById(R.id.rvProductList);
        prodtAdapter = new ProductAdapterRecycler(this,productList);

        // default vertical layout for linear layout
        layoutManager = new LinearLayoutManager(this);

        //layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);

        //layoutManager =new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(prodtAdapter);

        //ProductAdapterRecycler adapterRecycler = new ProductAdapterRecycler(this,)

    }

    @Override
    public void OnItemClicked(int index) {
        Toast.makeText(this, "Welcome Index" + index, Toast.LENGTH_SHORT).show();
    }
}