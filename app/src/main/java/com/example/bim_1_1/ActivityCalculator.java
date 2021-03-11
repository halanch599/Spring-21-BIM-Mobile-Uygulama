package com.example.bim_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCalculator extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnplus, btnminus,btndivide,btnmmultiply,btnc,btnce,btnback,btnplusminus,btndot,btnequal;
    TextView tvhistory, tvresult;

    String text = null;

    double num1=0, num2=0;
    String status = null;
    boolean operator = false;
    String history, currentResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btn0 =  findViewById(R.id.btn0);
        btn1 =  findViewById(R.id.btn1);
        btn2 =  findViewById(R.id.btn2);
        btn3 =  findViewById(R.id.btn3);
        btn4 =  findViewById(R.id.btn4);
        btn5 =  findViewById(R.id.btn5);
        btn6 =  findViewById(R.id.btn6);
        btn7 =  findViewById(R.id.btn7);
        btn8 =  findViewById(R.id.btn8);
        btn9 =  findViewById(R.id.btn9);

        btnplus =  findViewById(R.id.btnplus);
        btnminus =  findViewById(R.id.btnminus);
        btndivide =  findViewById(R.id.btndivide);
        btnmmultiply =  findViewById(R.id.btnMultiply);
        btnplusminus =  findViewById(R.id.btnplusminus);

        btnce =  findViewById(R.id.btnce);
        btnc =  findViewById(R.id.btnc);
        btnback =  findViewById(R.id.btnBackspace);
        btndot =  findViewById(R.id.btndot);
        btnequal =  findViewById(R.id.btnequal);

        tvresult = findViewById(R.id.tvresult);
        tvhistory =findViewById(R.id.tvhistory);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateNumeber("9");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text==null)
                {
                    text="0.";
                }
                else
                {
                    if (text.indexOf(('.'))==-1)
                    {
                        text = text + ".";
                    }
                }
                tvresult.setText(text);
            }
        });

        btnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text=null;
                tvresult.setText("");
                tvhistory.setText("");
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text!=null){
                    if (text.length()>0){
                        text = text.substring(0,text.length()-1);
                        tvresult.setText(text);
                        if (text.length()==0)
                        {
                            tvresult.setText("0");
                        }
                    }
                    else {
                        text=null;
                        tvresult.setText("0");
                    }
                }
            }
        });

    }

    public void UpdateNumeber(String num)
    {
        if (text==null)
        {
            text=num;
        }
        else  {

            if ((num.equals("0")  && Double.parseDouble(text)==0))
            {
                if (text.indexOf('0')==0 && text.indexOf('.')==1)
                {
                    text=text+num;
                }
            }
            else{
                text=text+num;
            }
        }

        tvresult.setText(text);
    }

    private void plus()
    {
        num2 = Double.parseDouble(tvresult.getText().toString());
        num1 += num2;
        tvresult.setText(""+num1);
    }

    private  void minus()
    {
        num2 = Double.parseDouble(tvresult.getText().toString());
        num1 -= num2;
        tvresult.setText(""+num1);
    }

    private  void multiply()
    {
        num2 = Double.parseDouble(tvresult.getText().toString());
        num1 *= num2;
        tvresult.setText(""+num1);
    }

    private  void divide()
    {
        num2 = Double.parseDouble(tvresult.getText().toString());
        if (num2==0)
        {
            tvresult.setText("");
        }
        else   {
            num1 /= num2;
            tvresult.setText(""+num1);
        }

    }
}