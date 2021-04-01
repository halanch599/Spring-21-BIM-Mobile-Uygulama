package com.example.bim_1_1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bim_1_1.R;

import java.sql.Array;
import java.util.ArrayList;

public class ProductAdapterRecycler extends RecyclerView.Adapter<ProductAdapterRecycler.ViewHolder> {

    ArrayList<Product> productArrayList;
    Context context;
    int index=-1;

    ItemClicked activity;

    public interface ItemClicked{
        void OnItemClicked(int index);
    }

    public ProductAdapterRecycler(Context context, ArrayList<Product> list)
    {
        this.context = context;
        this.productArrayList = list;
        activity = (ItemClicked)context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImage;
        TextView tvProductName, tvProductPrice;
        Button btnProductAdd, btnProductDeails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage =  itemView.findViewById(R.id.ivImage);
            tvProductName =  itemView.findViewById(R.id.tvProductName);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            btnProductAdd = itemView.findViewById(R.id.btnAdd);
            btnProductDeails = itemView.findViewById(R.id.btnDetail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context, "You clicked the Itemview", Toast.LENGTH_SHORT).show();
                    int tag = Integer.parseInt(itemView.getTag().toString());
                    activity.OnItemClicked(tag);
                }
            });

            btnProductAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Toast.makeText(context, "You clicked the Button", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    @NonNull
    @Override
    public ProductAdapterRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapterRecycler.ViewHolder holder, int position) {
        Product p = productArrayList.get(position);
        holder.ivImage.setImageDrawable(context.getResources().getDrawable(p.getImage()));
        holder.tvProductName.setText(p.getName());
        holder.tvProductPrice.setText(p.getName());

        holder.itemView.setTag(position);
        index = position;
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
