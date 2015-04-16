package com.kevinveldkamp.ceasarcalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CalcScreen extends ActionBarActivity {

    Button bClear,bBack,bOne,bTwo,bThree,bFour,bFive,bSix,bSeven,bEight,bNine,bZero,bDec,
    bEq,bPlus,bMinus,bMult,bDiv;

    boolean add,subtract,mult,div,decimal,calculated = false;

    double value1, value2;
    int total;

    EditText calcScreen;

    String current = "";
    String M = "M";
    String CM = "CM";
    String X = "X";
    String V = "V";
    String L = "L";
    String D = "D";
    String C = "C";
    String CD = "CD";
    String XC = "XC";
    String XL = "XL";
    String I = "I";
    String IX = "IX";
    String IV = "IV";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_screen);

        //setting numeric buttons
        bOne = (Button) findViewById(R.id.bOne);
        bTwo = (Button) findViewById(R.id.bTwo);
        bThree = (Button) findViewById(R.id.bThree);
        bFour = (Button) findViewById(R.id.bFour);
        bFive = (Button) findViewById(R.id.bFive);
        bSix = (Button) findViewById(R.id.bSix);
        bSeven = (Button) findViewById(R.id.bSeven);
        bEight = (Button) findViewById(R.id.bEight);
        bNine = (Button) findViewById(R.id.bNine);
        bZero = (Button) findViewById(R.id.bZero);

        //setting top row of buttons
        bClear = (Button) findViewById(R.id.bClear);


        //setting the operator buttons
        bPlus = (Button) findViewById(R.id.bPlus);
        bMinus = (Button) findViewById(R.id.bMinus);
        bMult = (Button) findViewById(R.id.bMult);
        bDiv = (Button) findViewById(R.id.bDiv);

        //setting decimal and equals buttons

        bDec = (Button) findViewById(R.id.bDec);
        bEq = (Button) findViewById(R.id.bEq);

        //linking the calcScreen (EditText) field;

        calcScreen = (EditText) findViewById(R.id.calcScreen);

        //calculator Button onclick actions

        bOne.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();
                calcScreen.setText(calcScreen.getText()+"1");

            }

        });

        bTwo.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"2");

            }

        });


        bThree.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"3");

            }

        });

        bFour.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"4");

            }

        });


        bFive.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"5");

            }

        });


        bSix.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"6");

            }

        });

        bSeven.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"7");

            }

        });

        bEight.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"8");

            }

        });

        bNine.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"9");

            }

        });


        bZero.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                checkField();

                calcScreen.setText(calcScreen.getText()+"0");

            }

        });


        bDec.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                decimal = true;

                checkField();

                calcScreen.setText(calcScreen.getText()+".");

            }

        });


        //Operators

        bPlus.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                add = true;


                value1 = Double.parseDouble(calcScreen.getText().toString());

                calcScreen.setText("+");

            }

        });

        bMinus.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                subtract = true;

                // TODO Auto-generated method stub
                value1 = Double.parseDouble(calcScreen.getText().toString());

                calcScreen.setText("-");

            }

        });

        bMult.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                mult = true;


                value1 = Double.parseDouble(calcScreen.getText().toString());

                calcScreen.setText("X");

            }

        });


        bDiv.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                div = true;




                value1 = Double.parseDouble(calcScreen.getText().toString());

                calcScreen.setText("/");

            }

        });


        //clear and equals

        bClear.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                // TODO Auto-generated method stub

                calcScreen.setText("0");

            }

        });


        bEq.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                value2 = Double.parseDouble(calcScreen.getText().toString());

                if(add==true){
                    value1 = value1 + value2;
                    add = false;
                }

                if(subtract==true){
                    value1 = value1 - value2;
                    subtract = false;
                }

                if(mult==true){
                    value1 = value1 * value2;
                    mult = false;
                }

                if(div==true){
                    value1 = value1 / value2;
                    div = false;
                }

                total = (int)value1;
                calcScreen.setText(romConversion(total));

                calculated = true;



            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calc_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String romConversion(int num){

        //if statements to convert int to roman numeral

        //could be optimized

        String temp="";


        if(num>4999){
            temp = "Error";
            return temp;
        }

        while(num/1000>=1){
            temp += M;
            num -=1000;
        }

        if(num/900>=1){

            temp += CM;
            num -= 900;
        }

        if(num/500>=1){
            temp +=D;
            num -= 500;
        }
        else if(num/400>=1){
            temp += CD;
            num -=400;
        }

        while(num/100>=1){
            temp+=C;
            num -=100;
        }

        if(num/90>=1){
            temp += XC;
            num-=90;
        }

        if(num/50>=1){
            temp += L;
            num-=50;
        }

        else if(num/40>=1){
            temp+= XL;
            num -=40;
        }

        while(num/10>=1){
            temp +=X;
            num -=10;
        }

        if(num/9>=1){
            temp+= IX;
            num -=9;
        }

        if(num/5>=1){
            temp +=V;
            num -=5;
        }

        else if(num/4>=1){
            temp += IV;
            num -=4;
        }

        while(num/1>=1){
            temp+=I;
            num-=1;
        }


        return temp;

    }


    public void checkField(){
        current = calcScreen.getText().toString();

        //special check for decimal button b/c we want to put a number like 0.1

        if(decimal==true){
            if(current.equals("+")||current.equals("-")||current.equals("X")||current.equals("/")||calculated){
                calcScreen.setText("");
            }
        }

        //normal case checking for something in the textfield to replace it
        else if(current.equals("+")||current.equals("-")||current.equals("X")||current.equals("/")||current.equals("0")||calculated){

            calcScreen.setText("");
        }

        //set decimal back to false
        calculated = false;
        decimal = false;
    }
}
