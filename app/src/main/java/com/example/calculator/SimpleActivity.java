package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleActivity extends AppCompatActivity {

    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonEquals;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonDivide;
    Button buttonMultiply;
    Button buttonDot;
    Button buttonClear;


    private TextView editText;
    private TextView infoText;

    private DecimalFormat format;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private enum Action{
        ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, UNKNOWN
    }

    private Action currentAction;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        editText = findViewById(R.id.editText);
        infoText = findViewById(R.id.infoTextView);
        assignButtons();
        format = new DecimalFormat("#.######");

    }

    public void assignButtons(){
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
        buttonZero = findViewById(R.id.buttonZero);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonPlus = findViewById(R.id.buttonAdd);
        buttonMinus = findViewById(R.id.buttonSubstract);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDot = findViewById(R.id.buttonDot);
        buttonClear = findViewById(R.id.buttonClear);

        this.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(editText.getText().charAt(editText.getText().length()-1) == '.'))
                    editText.setText(editText.getText() + ".");
            }
        });
        this.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "1");
            }
        });

        this.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "2");
            }
        });
        this.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "3");
            }
        });
        this.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "4");
            }
        });
        this.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "5");
            }
        });
        this.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "6");
            }
        });
        this.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "7");
            }
        });
        this.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "8");
            }
        });
        this.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "9");
            }
        });
        this.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText() + "0");
            }
        });
        this.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                currentAction = Action.ADDITION;
                infoText.setText(format.format(valueOne) + "+");
                editText.setText(null);
            }
        });
        this.buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                currentAction = Action.SUBSTRACTION;
                infoText.setText(format.format(valueOne) + "-");
                editText.setText(null);
            }
        });
        this.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                currentAction = Action.MULTIPLICATION;
                infoText.setText(format.format(valueOne) + "*");
                editText.setText(null);
            }
        });
        this.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                currentAction = Action.DIVISION;
                infoText.setText(format.format(valueOne) + "/");
                editText.setText(null);;
            }
        });
        this.buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
                infoText.setText(infoText.getText().toString() + format.format(valueTwo) + " = " + format.format(valueOne));
                editText.setText(valueOne + "");
                valueOne = Double.NaN;
                currentAction = Action.UNKNOWN;
            }
        });
        this.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText.getText().length() > 0){
                    String currentText = editText.getText().toString();
                    editText.setText(currentText.substring(0, currentText.length()-1));
                }else{
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    editText.setText("");
                    infoText.setText("");
                }
            }
        });
    }

    private void calculate(){
        if(!Double.isNaN(valueOne)){

            try{
                valueTwo = Double.valueOf(editText.getText().toString());
                editText.setText(null);
            }catch(NumberFormatException e){
                Toast toast = Toast.makeText(getApplicationContext(), "Incorrect operand. Try again.", Toast.LENGTH_LONG);
                toast.show();
            }

            if(Double.isNaN(valueTwo)){
                Toast toast = Toast.makeText(getApplicationContext(), "Try again", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                switch(currentAction){
                    case ADDITION:
                        valueOne = this.valueOne + valueTwo;
                        break;
                    case SUBSTRACTION:
                        valueOne = this.valueOne - valueTwo;
                        break;
                    case MULTIPLICATION:
                        valueOne = this.valueOne * valueTwo;
                        break;
                    case DIVISION:
                        valueOne = this.valueOne / valueTwo;
                        break;
                    case UNKNOWN:
                        Toast.makeText(getApplicationContext(), "Unknown action", Toast.LENGTH_LONG).show();
                }
            }
        }else{
            try{
                valueOne = Double.valueOf(editText.getText().toString());
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "First value is null", Toast.LENGTH_LONG).show();
            }
        }
    }
}
