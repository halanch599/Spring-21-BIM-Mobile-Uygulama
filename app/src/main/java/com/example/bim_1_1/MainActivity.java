package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bim_1_1.model.DBUser;

public class MainActivity extends AppCompatActivity {

    Button tbRegister, btnAbout;
    CheckBox cbRemember;
    EditText etUserName, etPassword;
    TextView tvMessage;

    private static final String PEFERENCES_USERNAME= "username";
    private static final String PEFERENCES_PASSWORD= "password";
    private static final String PEFERENCES_ABOUT= "about";
    private static final String PEFERENCES_NAME= "MY_Preference";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvMessage =  (TextView) findViewById(R.id.tvMessage);
        tbRegister =  findViewById(R.id.btnRegister);
        cbRemember =  findViewById(R.id.cbRemember);
        btnAbout = findViewById(R.id.btnAbout);

//        SharedPreferences sharedPreferences = this.getPreferences(this.MODE_PRIVATE);
        SharedPreferences sharedPreferences = this.getSharedPreferences(PEFERENCES_NAME,this.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(PEFERENCES_ABOUT,"This is a new version of the android app. \n For testing purpose");

        editor.apply(); // asynchornos save

        if (sharedPreferences!=null)
        {
            String uname = sharedPreferences.getString(PEFERENCES_USERNAME,"");
            String pwd = sharedPreferences.getString(PEFERENCES_PASSWORD,"");
            etUserName.setText(uname);
            etPassword.setText(pwd);
            cbRemember.setChecked(true);
            Toast.makeText(this, "Loaded from SharredPreferences", Toast.LENGTH_SHORT).show();
        }
        else
        {
            cbRemember.setChecked(false);
        }


        tbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   Intent intent = new Intent(MainActivity.this,ActivityRegister.class);
                   startActivity(intent);
            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String details = sharedPreferences.getString(PEFERENCES_ABOUT,"");
                String details = sharedPreferences.getString(PEFERENCES_ABOUT,"");

                Toast.makeText(MainActivity.this, details, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Login(View v)
    {



        String username = etUserName.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.equals("")){
            tvMessage.setText("Enter your User Name.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etUserName.requestFocus();
            return;
        }

        if (password.equals("")){
            tvMessage.setText("Enter your Password.");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
            etPassword.requestFocus();
            return;
        }



        // database
        //if (username.equals("admin") && password.equals("12345"))
        if (DBUser.Login(username,password))
        {
            tvMessage.setText("Login Sussfully");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.GREEN);

            if(cbRemember.isChecked())
            {
//                SharedPreferences sharedPreferences = this.getPreferences(this.MODE_PRIVATE);
                SharedPreferences sharedPreferences = this.getSharedPreferences(PEFERENCES_NAME,this.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(PEFERENCES_USERNAME,username);
                editor.putString(PEFERENCES_PASSWORD,password);

                editor.apply(); // asynchornos save
//                editor.commit(); // synchornosu
                Toast.makeText(this, "Preferrences Saved", Toast.LENGTH_SHORT).show();

            }


            // Intent

//            Intent intent = new Intent(this,HomeActivity.class);
//            intent.putExtra("data",username);
//            startActivity(intent);
        }
        else{
            tvMessage.setText("Incorrect username or password");
            tvMessage.setVisibility(View.VISIBLE);
            tvMessage.setTextColor(Color.RED);
        }


    }
}