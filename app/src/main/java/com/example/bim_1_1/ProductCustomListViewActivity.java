package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bim_1_1.model.ProdcutAdapter;
import com.example.bim_1_1.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductCustomListViewActivity extends AppCompatActivity {

    List<Product> productList;
    ListView lvProdcut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_custom_list_view);

        lvProdcut =  findViewById(R.id.lvProducts);
        productList = new ArrayList<>();
        productList.add(new Product("Laptop",3500,R.drawable.laptop_100px));
        productList.add(new Product("Apple",6500,R.drawable.apple_100px));
        productList.add(new Product("Mobile",5000,R.drawable.mobile_phone_100px));
        productList.add(new Product("Watch",4600,R.drawable.smart_watch_100px));
        productList.add(new Product("Mobile",5000,R.drawable.mobile_phone_100px));

        ProdcutAdapter adapter =  new ProdcutAdapter(this,R.layout.listview_product,productList);
        lvProdcut.setAdapter(adapter);

    }
}