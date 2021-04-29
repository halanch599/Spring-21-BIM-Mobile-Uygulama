package com.example.bim_1_1.model;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bim_1_1.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomerListViewAdapter extends ArrayAdapter<Customer> {

    private ArrayList<Customer>  customers;
    Context context;
    int layoutID;
    public CustomerListViewAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Customer> list) {
        super(context, resource, list);

        this.context = context;
        layoutID = resource;
        customers = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(layoutID,parent,false);


        Customer customer = customers.get(position);

        TextView tvCustomerID = (TextView) view.findViewById(R.id.tvCustomerID);
        TextView tvCustomerFirstnname = (TextView) view.findViewById(R.id.tvCustomerFirstName);
        TextView tvCustomerlastname = (TextView) view.findViewById(R.id.tvCustomerLastName);

        tvCustomerID.setText(String.valueOf(customer.getCustomerID()));
        tvCustomerFirstnname.setText(customer.getFirstName());
        tvCustomerlastname.setText(customer.getLastName());

        return view;
    }
}
