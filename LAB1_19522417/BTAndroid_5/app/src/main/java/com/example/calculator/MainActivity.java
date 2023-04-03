package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnHistory, btnAC, btnC, btnPer,btnPlus, btnDiv, btnMul,btnMinus, btnDot, btnDel, btnEqual;
    private TextView textviewResult;
    private String  number = null;
    double lastnumber = 0, firstnumber = 0;
    boolean operator = false;
    String status = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = this.findViewById(R.id.btn0);
        btn1 = this.findViewById(R.id.btn1);
        btn2 = this.findViewById(R.id.btn2);
        btn3 = this.findViewById(R.id.btn3);
        btn4 = this.findViewById(R.id.btn4);
        btn5 = this.findViewById(R.id.btn5);
        btn6 = this.findViewById(R.id.btn6);
        btn7 = this.findViewById(R.id.btn7);
        btn8 = this.findViewById(R.id.btn8);
        btn9 = this.findViewById(R.id.btn9);

        btnHistory = this.findViewById(R.id.btnHistory);
        btnAC = this.findViewById(R.id.btnAC);
        btnC = this.findViewById(R.id.btnDel);

        btnPlus = this.findViewById(R.id.btnPlus);
        btnDiv = this.findViewById(R.id.btnDivide);
        btnMul = this.findViewById(R.id.btnX);
        btnMinus = this.findViewById(R.id.btnMinus);

        btnPer = this.findViewById(R.id.btnPercent);
        btnDot = this.findViewById(R.id.btnComma);
        btnDel = this.findViewById(R.id.btnDel);
        btnEqual = this.findViewById(R.id.btnEqual);

        textviewResult = this.findViewById(R.id.textviewResult);

        btn0.setOnClickListener(view -> numberclick("0"));
        btn1.setOnClickListener(view -> numberclick("1"));
        btn2.setOnClickListener(view -> numberclick("2"));
        btn3.setOnClickListener(view -> numberclick("3"));
        btn4.setOnClickListener(view -> numberclick("4"));
        btn5.setOnClickListener(view -> numberclick("5"));
        btn6.setOnClickListener(view -> numberclick("6"));
        btn7.setOnClickListener(view -> numberclick("7"));
        btn8.setOnClickListener(view -> numberclick("8"));
        btn9.setOnClickListener(view -> numberclick("9"));

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, historyActivity2.class);
                startActivity(intent);
            }
        });

        btnPlus.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multi") {
                    Multi();
                } else {
                    if (status == "Div") {
                        Div();
                    } else {
                        if (status == "Minus") {
                            Minus();
                        } else {
                            Plus();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Plus";
        });

        btnMinus.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multi") {
                    Multi();
                } else {
                    if (status == "Div") {
                        Div();
                    } else {
                        if (status == "Plus") {
                            Plus();
                        } else {
                            Minus();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Minus";
        });

        btnMul.setOnClickListener(view -> {
            if (operator) {
                if (status == "Div") {
                    Div();
                } else {
                    if (status == "Plus") {
                        Plus();
                    } else {
                        if (status == "Minus") {
                            Minus();
                        } else {
                            Multi();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Multi";
        });

        btnDiv.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multi") {
                    Multi();
                } else {
                    if (status == "Plus") {
                        Plus();
                    } else {
                        if (status == "Minus") {
                            Minus();
                        } else {
                            Div();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Div";
        });

        btnEqual.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multi") {
                    Multi();
                } else {
                    if (status == "Plus") {
                        Plus();
                    } else {
                        if (status == "Minus") {
                            Minus();
                        } else {
                            if (status == "Div") {
                                Div();
                            } else {
                                firstnumber = Double.parseDouble(textviewResult.getText().toString());
                            }
                        }
                    }
                }
            }
            operator = false;
        });

        btnAC.setOnClickListener(view -> {
            number = null;
            operator = false;
            textviewResult.setText("0");
            firstnumber = 0;
            lastnumber = 0;
        });

        btnC.setOnClickListener(view -> {
            number = number.substring(0,number.length()-1);
            textviewResult.setText(number);
        });

        btnDot.setOnClickListener(view -> {
            if (number == null) {
                number = "0.";
            } else {
                number = number + ".";
            }
            textviewResult.setText(number);
        });
    }
    public void numberclick (String view) {
        if (number == null) {
            number = view;
        } else {
            number = number +view;
        }
        textviewResult.setText(number);
        operator = true;
    }

    public void Minus() {
        if(firstnumber == 0) {
            firstnumber = Double.parseDouble(textviewResult.getText().toString());
        } else {
            lastnumber = Double.parseDouble(textviewResult.getText().toString());
            firstnumber = firstnumber - lastnumber;
        }
        textviewResult.setText(""+firstnumber);
    }
    public void Plus() {
        if (firstnumber == 0) {
            firstnumber = Double.parseDouble(textviewResult.getText().toString());
        } else {
            lastnumber = Double.parseDouble(textviewResult.getText().toString());
            firstnumber = firstnumber + lastnumber;
        }
        textviewResult.setText("" + firstnumber);
    }
    public void Multi() {
        if (firstnumber == 0) {
            firstnumber = Double.parseDouble(textviewResult.getText().toString());
        } else {
            lastnumber = Double.parseDouble(textviewResult.getText().toString());
            firstnumber = firstnumber * lastnumber;
        }
        textviewResult.setText("" + firstnumber);
    }
    public void Div() {
        if (firstnumber == 0) {
            firstnumber = Double.parseDouble(textviewResult.getText().toString());
        } else {
            lastnumber = Double.parseDouble(textviewResult.getText().toString());
            firstnumber = firstnumber / lastnumber;
        }
        textviewResult.setText("" + firstnumber);
    }

}