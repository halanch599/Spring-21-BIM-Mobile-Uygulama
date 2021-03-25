package com.example.bim_1_1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bim_1_1.R;

import java.util.List;

public class ProdcutAdapter extends ArrayAdapter<Product> {


    List<Product> productList;
    Context context;
    int resourceID;

    public ProdcutAdapter(@NonNull Context context, int resource, @NonNull List<Product> list) {
        super(context, resource, list);

        this.productList = list;
        this.context = context;
        this.resourceID = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View view =  inflater.inflate(resourceID,null,false);

        ImageView ivImage = (ImageView) view.findViewById(R.id.ivImage);
        TextView tvProductName = (TextView) view.findViewById(R.id.tvProductName);
        TextView tvProductPrice = (TextView) view.findViewById(R.id.tvProductPrice);
        Button btnAdd = (Button) view.findViewById(R.id.btnAdd);

        Product product = productList.get(position);
        ivImage.setImageDrawable(context.getResources().getDrawable(product.getImage(),null));
        tvProductName.setText(product.getName());
        tvProductPrice.setText(String.valueOf(product.getPrice()));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Indirim Yok!", Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Are you sure to Add?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "You added one product", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, "Oh NOOOOO", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        return view;
    }
}
