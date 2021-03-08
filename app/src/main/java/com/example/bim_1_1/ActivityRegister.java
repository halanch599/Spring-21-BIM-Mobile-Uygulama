package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bim_1_1.model.DBUser;
import com.example.bim_1_1.model.User;

public class ActivityRegister extends AppCompatActivity {

    EditText etName, etEmail, etPassword, etPasswordReenter;
    CheckBox cb8Hours, cb24Hours;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    Spinner spinnerCountry;
    Button btnRegister, btnClear, btnBack;
    TextView tvMessage;
    DBUser db;

    String country="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        LoadComponents();

        db = new DBUser();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMessage.setVisibility(View.GONE);
                tvMessage.setText("");


                String name = etName.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String passwrod = etPassword.getText().toString().trim();
                String passwordreenter = etPasswordReenter.getText().toString().trim();

                String gender ="";

                String workingHours="";
                if (cb8Hours.isChecked())
                {
                    workingHours = cb8Hours.getText().toString();
                }

                if (cb24Hours.isChecked())
                {
                    if (workingHours.isEmpty()) {
                        workingHours = cb24Hours.getText().toString();
                    }
                    else{
                        workingHours += "," + cb24Hours.getText().toString();
                    }
                }

                if (rgGender.getCheckedRadioButtonId()!=-1)
                {
                    if (rgGender.getCheckedRadioButtonId()==R.id.rbMale)
                    {
                        gender="Male";
                    }
                    else
                    {
                        gender = "Female";
                    }
                }

                if (name.isEmpty())
                {
                    tvMessage.setText("Enter Name");
                    tvMessage.setTextColor(Color.RED);
                    etName.requestFocus();
                    tvMessage.setVisibility(View.VISIBLE);
                    return;
                }

                if (email.isEmpty())
                {
                    tvMessage.setText("Enter email");
                    tvMessage.setTextColor(Color.RED);
                    etEmail.requestFocus();
                    tvMessage.setVisibility(View.VISIBLE);
                    return;
                }

                // check for Empty in password and re enter password

                // ayni varmi

                if(passwrod.isEmpty() || passwordreenter.isEmpty() || !passwrod.equals(passwordreenter) )
                {
                    tvMessage.setText("Password and re-entered password does not match");
                    tvMessage.setTextColor(Color.RED);
                    etPassword.requestFocus();
                    tvMessage.setVisibility(View.VISIBLE);
                    return;
                }

                if (gender.isEmpty())
                {
                    tvMessage.setText("Select Gender.");
                    tvMessage.setTextColor(Color.RED);
                    tvMessage.setVisibility(View.VISIBLE);
                    return;
                }

                if (country.isEmpty())
                {
                    tvMessage.setText("Select Country.");
                    tvMessage.setTextColor(Color.RED);
                    tvMessage.setVisibility(View.VISIBLE);
                    return;
                }
                // show message if there is any error
//                if (!tvMessage.getText().toString().isEmpty())
//                {
//                    tvMessage.setVisibility(View.VISIBLE);
//                }

                User user = new User();
                user.setName(name);
                user.setPassword(passwrod);
                user.setEmail(email);
                user.setGender(gender);
                user.setCountry(country);
                user.setUserID(db.GetAllUsers().size()+1);

                int result = db.AddUser(user);
                if (result==1)
                {
                    tvMessage.setText("User Added to DB.");
                    tvMessage.setTextColor(Color.GREEN);
                    tvMessage.setVisibility(View.VISIBLE);
                }
                else
                {
                    tvMessage.setText("Failed to  Add user to DB.");
                    tvMessage.setTextColor(Color.RED);
                    tvMessage.setVisibility(View.VISIBLE);
                }

            }
        });






    }

    // practice 3. Implement this method
    private void clearComponents()
    {
        // add code to clear all components
    }
    private void LoadComponents()
    {
        etName =  (EditText) findViewById(R.id.etName);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPasswordUser);
        etPasswordReenter = (EditText) findViewById(R.id.etPasswordAgain);

        cb8Hours =  (CheckBox) findViewById(R.id.cb8Hours);
        cb24Hours = (CheckBox) findViewById(R.id.cb24Hours);

        rgGender =  findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        rbFemale =  findViewById(R.id.rbFemale);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnBack =  (Button)findViewById(R.id.btnBack);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityRegister.this,MainActivity.class);
                startActivity(intent);
            }
        });
        tvMessage =  findViewById(R.id.tvMessageRegister);

        spinnerCountry = findViewById(R.id.spinnerCountry);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapter);

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (position!=0) {
                    country = adapterView.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}